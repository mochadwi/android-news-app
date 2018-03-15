package io.mochadwi.mobilenews.news_source

import io.mochadwi.mobilenews.BasePresenter
import io.mochadwi.mobilenews.BaseView
import io.mochadwi.mobilenews.news_source.model.SourcesItem

/**
 * Created by mochadwi on 3/13/18.
 */
interface NewsSourceContract {
    interface View : BaseView<Presenter> {
        fun setRecyclerView(data: List<SourcesItem?>?)
    }

    interface Presenter : BasePresenter {
        fun getNews()
        fun getOfflineNews()
        fun isOfflineNewsEmpty(): Boolean
    }
}