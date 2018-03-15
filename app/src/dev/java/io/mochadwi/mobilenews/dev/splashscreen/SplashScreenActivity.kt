package io.mochadwi.mobilenews.dev.splashscreen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.mochadwi.mobilenews.R
import io.mochadwi.mobilenews.util.PublicMethods


/**
 * Created by mochadwi on 3/13/18.
 */
class SplashScreenActivity : AppCompatActivity() {

    private var mPresenter: SplashScreenContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var view: SplashScreenFragment? = supportFragmentManager
                .findFragmentById(R.id.fragment_layout) as? SplashScreenFragment

        if (view == null) {
            view = SplashScreenFragment.newInstance()

            PublicMethods.addFragmentToActivity(supportFragmentManager,
                    view, R.id.fragment_layout)
        }

        mPresenter = SplashScreenPresenter(view)
        mPresenter!!.start()
    }
}