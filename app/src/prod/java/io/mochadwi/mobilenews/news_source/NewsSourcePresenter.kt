package io.mochadwi.mobilenews.news_source

import io.mochadwi.mobilenews.BuildConfig
import io.mochadwi.mobilenews.network.RESTClient
import io.mochadwi.mobilenews.network.RESTGenerator
import io.mochadwi.mobilenews.news_source.model.NewsSourceModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by mochadwi on 3/13/18.
 */
class NewsSourcePresenter(private val mView: NewsSourceContract.View) : NewsSourceContract.Presenter {
    private val mRest = RESTGenerator.createService(BuildConfig.BASEURL, RESTClient::class.java)

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
//                        mView.showToast(response.body().toString());
                        mView.setRecyclerView(response.body()!!)
                    }

                    override fun onFailure(call: Call<NewsSourceModel>, t: Throwable) {
                        mView.hideProgress()
                        mView.showToast(t.message!!)
                    }
                })
    }
}