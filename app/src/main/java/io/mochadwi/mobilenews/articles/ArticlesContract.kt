package io.mochadwi.mobilenews.articles

import io.mochadwi.mobilenews.BasePresenter
import io.mochadwi.mobilenews.BaseView
import io.mochadwi.mobilenews.articles.model.ArticlesModel

/**
 * Created by mochadwi on 3/13/18.
 */
interface ArticlesContract {
    interface View : BaseView<Presenter> {
        fun setRecyclerView(data: ArticlesModel)
    }

    interface Presenter : BasePresenter {
        fun getArticles(sources: String, apiKey: String)
    }
}