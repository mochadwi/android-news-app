package io.mochadwi.mobilenews.splashscreen

import io.mochadwi.mobilenews.BasePresenter
import io.mochadwi.mobilenews.BaseView

/**
 * Created by mochadwi on 3/13/18.
 */
interface SplashScreenContract {
    interface View : BaseView<Presenter>

    interface Presenter : BasePresenter
}