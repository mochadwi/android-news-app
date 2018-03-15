package io.mochadwi.mobilenews

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.mochadwi.mobilenews.articles.ArticlesContract
import io.mochadwi.mobilenews.articles.ArticlesFragment
import io.mochadwi.mobilenews.articles.ArticlesPresenter
import org.junit.Before
import org.junit.Test

/**
 * Created by mochadwi on 3/15/18.
 */
class ArticlesTest {

    private lateinit var mPresenter: ArticlesContract.Presenter
    private lateinit var mView: ArticlesFragment

    @Before
    fun setup() {
        mView = mock()
        mPresenter = ArticlesPresenter(mView)
        mPresenter.start()
    }

    @Test
    fun getArticlesFromUnknownSources() {

        mPresenter.getArticles("")

        verify(mView).mRvItems.adapter.itemCount < 1
    }
}