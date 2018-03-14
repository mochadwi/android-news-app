package io.mochadwi.mobilenews.articles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
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
        mWvArticle.webViewClient = WebViewClient()
        mWvArticle.settings.javaScriptEnabled = true
        mWvArticle.loadUrl(article!!.url)
    }
}
