package io.mochadwi.mobilenews.news_source

import io.mochadwi.mobilenews.BuildConfig
import io.mochadwi.mobilenews.network.RESTClient
import io.mochadwi.mobilenews.network.RESTGenerator
import io.mochadwi.mobilenews.news_source.model.NewsSourceModel
import io.mochadwi.mobilenews.news_source.model.SourcesItem
import io.realm.Realm
import io.realm.RealmResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by mochadwi on 3/13/18.
 */
class NewsSourcePresenter(private val mView: NewsSourceContract.View) : NewsSourceContract.Presenter {
    private val mRest = RESTGenerator.createService(BuildConfig.BASEURL, RESTClient::class.java)
    private val mRealm = Realm.getDefaultInstance()

    override fun start() {
        mView.setPresenter(this)
    }

    override fun getNews() {
        mView.showProgress()

        mRest
                .getRecommendedSources()
                .enqueue(object : Callback<NewsSourceModel> {
                    override fun onResponse(call: Call<NewsSourceModel>, response: Response<NewsSourceModel>) {
                        mView.hideProgress()

                        if (response.isSuccessful) {
                            mRealm.use { realmInstance ->
                                realmInstance.executeTransaction { realm ->
                                    realm.insertOrUpdate(response.body()!!.sources!!)
                                }
                            }

                            mView.setRecyclerView(response.body()!!.sources!!)
                        }
                    }

                    override fun onFailure(call: Call<NewsSourceModel>, t: Throwable) {
                        mView.hideProgress()
                        mView.showToast(t.message!!)
                    }
                })
    }

    override fun getOfflineNews() {
        mView.showProgress()

        mRealm.use { realm ->
            realm.executeTransaction { // YES
                inRealm ->
                val newsRealm = inRealm.where(SourcesItem::class.java).findAll() // YES

                if (newsRealm!!.isLoaded && newsRealm.isNotEmpty()) {
                    mView.hideProgress()

                    val news = ArrayList<SourcesItem>()

                    newsRealm.asSequence()
                            .mapTo(news) { it }

                    mView.setRecyclerView(news)
                } else {
                    mView.hideProgress()

                    mView.showToast("Error get data from database")
                }
            }
        }
    }

    override fun isOfflineNewsEmpty(): Boolean {

        var isEmpty = false
        mRealm.use { realm ->
            realm.executeTransaction { // YES
                inRealm ->
                val news = inRealm.where(SourcesItem::class.java).findAll() // YES
                isEmpty = news.isEmpty()
            }
        }

        return isEmpty
    }
}