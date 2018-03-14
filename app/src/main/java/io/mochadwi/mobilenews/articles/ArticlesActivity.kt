package io.mochadwi.mobilenews.articles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.mochadwi.mobilenews.R
import io.mochadwi.mobilenews.util.ActivityHelper

/**
 * Created by mochadwi on 3/13/18.
 */
class ArticlesActivity : AppCompatActivity() {

    private var mPresenter: ArticlesContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        val sources = intent.getStringExtra("sources")

        var view: ArticlesFragment? = supportFragmentManager
                .findFragmentById(R.id.fragment_layout) as? ArticlesFragment

        if (view == null) {
            view = ArticlesFragment.newInstance(sources!!, "")

            ActivityHelper.addFragmentToActivity(supportFragmentManager,
                    view, R.id.fragment_layout)
        }

        mPresenter = ArticlesPresenter(view)
        mPresenter!!.start()
    }
}