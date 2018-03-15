package io.mochadwi.mobilenews.splashscreen

import io.mochadwi.mobilenews.network.RESTGenerator


/**
 * Created by mochadwi on 3/13/18.
 */
class SplashScreenPresenter(private val mView: SplashScreenContract.View) : SplashScreenContract.Presenter {
    private val mRest = RESTGenerator.getRetrofitClient()

    override fun start() {
        mView.setPresenter(this)
    }

    override fun getNews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}