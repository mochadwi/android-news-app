package io.mochadwi.mobilenews.dev.news_source

import io.mochadwi.mobilenews.BasePresenter
import io.mochadwi.mobilenews.BaseView
import io.mochadwi.mobilenews.dev.news_source.model.NewsSourceModel

/**
 * Created by mochadwi on 3/13/18.
 */
interface NewsSourceContract {
    interface View : BaseView<Presenter> {
        fun setRecyclerView(data: NewsSourceModel)
    }

    interface Presenter : BasePresenter {
        fun getNews(apiKey: String)
    }
}