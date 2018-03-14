package io.mochadwi.mobilenews.articles.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import io.mochadwi.mobilenews.R

/**
 * Created by mochadwi on 3/13/18.
 */
class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.cv_item)
    lateinit var mCvItem: CardView
    @BindView(R.id.img_media)
    lateinit var mIvMedia: ImageView
    @BindView(R.id.txt_title)
    lateinit var mTxtTitle: TextView

    init {
        ButterKnife.bind(this, itemView)
    }
}
