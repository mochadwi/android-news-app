package io.mochadwi.mobilenews.news_source

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import butterknife.ButterKnife
import io.mochadwi.mobilenews.R

class NewsSourceFragment:Fragment(), NewsSourceContract.View {

private var mPresenter: NewsSourceContract.Presenter? = null

public override fun onResume() {
super.onResume()
mPresenter!!.start()
}

 fun setPresenter(presenter: NewsSourceContract.Presenter) {
this.mPresenter = presenter
}

public override fun onCreateView(inflater:LayoutInflater?, container:ViewGroup?, savedInstanceState:Bundle?):View? {
val view = inflater!!.inflate(R.layout.activity_news_source, container, false)
ButterKnife.bind(this, view)
return view
}

public override fun onActivityCreated(savedInstanceState:Bundle?) {
super.onActivityCreated(savedInstanceState)
}

 fun showProgress() {

}

 fun hideProgress() {

}

companion object {

 fun newInstance(): NewsSourceFragment {
return NewsSourceFragment()
}
}
}
