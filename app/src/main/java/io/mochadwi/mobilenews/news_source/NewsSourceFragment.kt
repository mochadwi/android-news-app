package io.mochadwi.mobilenews.news_source

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import io.mochadwi.mobilenews.R

class NewsSourceFragment : Fragment(), NewsSourceContract.View {

    private var mPresenter: NewsSourceContract.Presenter? = null

    override fun onResume() {
        super.onResume()
        mPresenter!!.start()
    }

    override fun setPresenter(presenter: NewsSourceContract.Presenter) {
        this.mPresenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.activity_news_source, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        fun newInstance(): NewsSourceFragment {
            return NewsSourceFragment()
        }
    }
}
