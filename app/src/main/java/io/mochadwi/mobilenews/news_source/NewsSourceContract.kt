package io.mochadwi.mobilenews.news_source

import io.mochadwi.mobilenews.BasePresenter
import io.mochadwi.mobilenews.BaseView

interface NewsSourceContract {
    interface View : BaseView<Presenter> {
    }

    interface Presenter : BasePresenter {

    }
}