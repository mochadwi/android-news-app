package io.mochadwi.mobilenews.splashscreen

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.mochadwi.mobilenews.R
import io.mochadwi.mobilenews.news_source.NewsSourceActivity

/**
 * Created by mochadwi on 3/13/18.
 */
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, NewsSourceActivity::class.java))
    }
}