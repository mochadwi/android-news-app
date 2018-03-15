package io.mochadwi.mobilenews.articles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import butterknife.BindView
import butterknife.ButterKnife
import com.google.gson.Gson
import io.mochadwi.mobilenews.R
import io.mochadwi.mobilenews.articles.model.ArticlesItem

class ArticlesWebViewActivity : AppCompatActivity() {

    @BindView(R.id.wv_article) internal lateinit var mWvArticle: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles_web_view)
        ButterKnife.bind(this)

        val article = Gson().fromJson<ArticlesItem>(
                intent.getStringExtra("article"),
                ArticlesItem::class.java)

        supportActionBar?.title = article?.title
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mWvArticle.webViewClient = WebViewClient()
        mWvArticle.settings.javaScriptEnabled = true
        mWvArticle.loadUrl(article?.url)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
