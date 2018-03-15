package io.mochadwi.mobilenews.splashscreen

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.ButterKnife
import io.mochadwi.mobilenews.R
import io.mochadwi.mobilenews.news_source.NewsSourceActivity

/**
 * Created by mochadwi on 3/13/18.
 */
class SplashScreenFragment : Fragment(), SplashScreenContract.View {

    // DATA
    private var mPresenter: SplashScreenContract.Presenter? = null
    private var mParam1: String? = null
    private var mParam2: String? = null

    // UI
    private lateinit var searchView: SearchView
    private var progress: ProgressDialog? = null

    companion object {

        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(): SplashScreenFragment {
            return SplashScreenFragment()
        }

        fun newInstance(param1: String, param2: String): SplashScreenFragment {
            val fragment = SplashScreenFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onStart() {
        super.onStart()
        mPresenter!!.start()
    }

    override fun onResume() {
        super.onResume()
        mPresenter!!.start()
    }

    override fun setPresenter(presenter: SplashScreenContract.Presenter) {
        this.mPresenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.content_articles, container, false)
        ButterKnife.bind(this, view)
        setHasOptionsMenu(true)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        startActivity(Intent(context, NewsSourceActivity::class.java))
    }

    override fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        progress = ProgressDialog(context)
        progress!!.setCancelable(true) // disable dismiss by tapping outside of the dialog
        progress!!.show()
        progress!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progress!!.setContentView(R.layout.progress_bar)
    }

    override fun hideProgress() {
        if (progress != null) { //null checker
            progress!!.dismiss()
        }
    }
}
