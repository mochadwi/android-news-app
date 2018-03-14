package io.mochadwi.mobilenews.articles

import android.support.v7.widget.SearchView
import android.util.Log
import android.widget.Toast
import io.mochadwi.mobilenews.articles.adapter.ArticlesAdapter
import io.mochadwi.mobilenews.articles.model.ArticlesModel
import io.mochadwi.mobilenews.network.RESTClient
import io.mochadwi.mobilenews.network.RESTGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by mochadwi on 3/13/18.
 */
class ArticlesPresenter(private val mView: ArticlesContract.View) : ArticlesContract.Presenter {
    private val mRest = RESTGenerator.getRetrofitClient()

    override fun start() {
        mView.setPresenter(this)
    }

    override fun getArticles(sources: String, apiKey: String) {
        mView.showProgress()

        mRest
                .create(RESTClient::class.java)
                .getArticles(sources, apiKey)
                .enqueue(object : Callback<ArticlesModel> {
                    override fun onResponse(call: Call<ArticlesModel>, response: Response<ArticlesModel>) {
                        mView.hideProgress()
//                        mView.showToast(response.body().toString());
                        mView.setRecyclerView(response.body()!!)
                    }

                    override fun onFailure(call: Call<ArticlesModel>, t: Throwable) {
                        mView.hideProgress()
                        mView.showToast(t.message!!)
                    }
                })
    }

    override fun searchArticles(sv: SearchView, adapter: ArticlesAdapter) {
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                adapter.filter.filter(newText)
                return true
            }
        })
    }
}