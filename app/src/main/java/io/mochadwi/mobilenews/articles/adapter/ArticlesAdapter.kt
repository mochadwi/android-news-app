package io.mochadwi.mobilenews.articles.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import io.mochadwi.mobilenews.R
import io.mochadwi.mobilenews.articles.model.ArticlesModel

/**
 * Created by mochadwi on 3/13/18.
 */
class ArticlesAdapter : RecyclerView.Adapter<ArticlesViewHolder> {

    private val mArticles: ArticlesModel
    private val mCtx: Context

    constructor(c: Context, dataIn: ArticlesModel) {
        this.mCtx = c
        mArticles = dataIn
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_articles, parent, false)
        return ArticlesViewHolder(v)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {

        val item = mArticles.articles!![position]

        holder.mTxtTitle.text = item?.author
        Glide.with(mCtx)
                .load(item?.urlToImage)
                .into(holder.mIvMedia)
//        holder.mTxtSource!!.text = mCtx.getString(R.string.message_articles, item?.url)
    }

    override fun getItemCount(): Int {
        return mArticles.totalResults!!
    }
}
