package io.mochadwi.mobilenews.news_source

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.mochadwi.mobilenews.R
import io.mochadwi.mobilenews.util.ActivityHelper

class NewsSourceActivity : AppCompatActivity() {

    private var mPresenter: NewsSourceContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_source)

        var view: NewsSourceFragment? = getSupportFragmentManager()
                .findFragmentById(R.id.fragment_layout) as NewsSourceFragment

        if (view == null) {
            view = NewsSourceFragment.newInstance()

            ActivityHelper.addFragmentToActivity(getSupportFragmentManager(),
                    view, R.id.fragment_layout)
        }

        mPresenter = NewsSourcePresenter(view)
    }
}