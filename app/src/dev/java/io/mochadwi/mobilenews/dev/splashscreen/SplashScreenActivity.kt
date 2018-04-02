package io.mochadwi.mobilenews.dev.splashscreen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.mochadwi.mobilenews.R
import io.mochadwi.mobilenews.util.PublicMethods


/**
 * Created by mochadwi on 3/13/18.
 */
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, NewsSourceActivity::class.java))
    }
}