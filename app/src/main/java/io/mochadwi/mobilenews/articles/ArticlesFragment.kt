package io.mochadwi.mobilenews.articles

import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.google.gson.Gson
import io.mochadwi.mobilenews.BuildConfig
import io.mochadwi.mobilenews.R
import io.mochadwi.mobilenews.articles.model.ArticlesModel
import io.mochadwi.mobilenews.articles.adapter.ArticlesAdapter

/**
 * Created by mochadwi on 3/13/18.
 */
class ArticlesFragment : Fragment(), ArticlesContract.View {

    // DATA
    private var mPresenter: ArticlesContract.Presenter? = null
    private var mAdapter: ArticlesAdapter? = null
    private var mParam1: String? = null
    private var mParam2: String? = null

    // UI
    @BindView(R.id.rv_items) internal lateinit var mRvItems: RecyclerView
    @BindView(R.id.txt_empty_items) internal lateinit var mTxtItems: TextView
    private var progress: ProgressDialog? = null

    companion object {

        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(): ArticlesFragment {
            return ArticlesFragment()
        }

        fun newInstance(param1: String, param2: String): ArticlesFragment {
            val fragment = ArticlesFragment()
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

    override fun setPresenter(presenter: ArticlesContract.Presenter) {
        this.mPresenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.content_articles, container, false)
        ButterKnife.bind(this, view)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val item = Gson().fromJson<ArticlesModel>(mParam1, ArticlesModel::class.java)
        mPresenter!!.getArticles(item.articles!![0]!!.source!!.id!!, BuildConfig.APIKEY)
    }

    override fun setRecyclerView(data: ArticlesModel) {

        mTxtItems.visibility = View.GONE
        mRvItems.visibility = View.VISIBLE

        mRvItems.layoutManager = GridLayoutManager(context, 2)
        mAdapter = ArticlesAdapter(context, data)
        mRvItems.adapter = mAdapter
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
