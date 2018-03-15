package io.mochadwi.mobilenews.dev.articles

import android.support.v7.widget.SearchView
import io.mochadwi.mobilenews.BasePresenter
import io.mochadwi.mobilenews.BaseView
import io.mochadwi.mobilenews.dev.articles.adapter.ArticlesAdapter
import io.mochadwi.mobilenews.dev.articles.model.ArticlesModel

/**
 * Created by mochadwi on 3/13/18.
 */
interface ArticlesContract {
    interface View : BaseView<Presenter> {
        fun setRecyclerView(data: ArticlesModel)
    }

    interface Presenter : BasePresenter {
        fun getArticles(sources: String, apiKey: String)
        fun searchArticles(sv: SearchView, adapter: ArticlesAdapter)
    }
}