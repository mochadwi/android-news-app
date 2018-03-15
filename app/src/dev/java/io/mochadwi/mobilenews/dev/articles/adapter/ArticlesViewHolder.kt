package io.mochadwi.mobilenews.dev.articles.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.github.curioustechizen.ago.RelativeTimeTextView
import io.mochadwi.mobilenews.R

/**
 * Created by mochadwi on 3/13/18.
 */
class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.cv_item)
    lateinit var mCvItem: CardView
    @BindView(R.id.txt_source)
    lateinit var mTxtSource: TextView
    @BindView(R.id.txt_published)
    lateinit var mTxtPublished: RelativeTimeTextView
    @BindView(R.id.img_media)
    lateinit var mIvMedia: ImageView
    @BindView(R.id.txt_primary)
    lateinit var mTxtPrimary: TextView
    @BindView(R.id.txt_description)
    lateinit var mTxtDescription: TextView
    @BindView(R.id.txt_author)
    lateinit var mTxtAuthor: TextView

    init {
        ButterKnife.bind(this, itemView)
    }
}
