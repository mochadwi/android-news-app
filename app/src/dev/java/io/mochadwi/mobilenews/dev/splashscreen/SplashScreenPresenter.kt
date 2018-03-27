package io.mochadwi.mobilenews.dev.splashscreen

import io.mochadwi.mobilenews.BuildConfig
import io.mochadwi.mobilenews.network.RESTClient
import io.mochadwi.mobilenews.network.RESTGenerator


/**
 * Created by mochadwi on 3/13/18.
 */
class SplashScreenPresenter(private val mView: SplashScreenContract.View) : SplashScreenContract.Presenter {
    private val mRest = RESTGenerator.createService(BuildConfig.BASEURL, RESTClient::class.java)

    override fun start() {
        mView.setPresenter(this)
    }
}