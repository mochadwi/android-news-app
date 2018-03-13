package io.mochadwi.mobilenews.news_source.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import io.mochadwi.mobilenews.R

/**
 * Created by mochadwi on 3/13/18.
 */
class NewsSourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.txt_title)
    var mTxtTitle: TextView? = null
    @BindView(R.id.txt_supporting)
    var mTxtTitleSupport: TextView? = null
    @BindView(R.id.txt_source)
    var mTxtSource: TextView? = null

    init {
        ButterKnife.bind(this, itemView)
    }
}
