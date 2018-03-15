package io.mochadwi.mobilenews.news_source.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.gson.Gson
import io.mochadwi.mobilenews.R
import io.mochadwi.mobilenews.articles.ArticlesActivity
import io.mochadwi.mobilenews.news_source.NewsSourceActivity
import io.mochadwi.mobilenews.news_source.model.NewsSourceModel
import io.mochadwi.mobilenews.news_source.model.SourcesItem

/**
 * Created by mochadwi on 3/13/18.
 */
class NewsSourceAdapter : RecyclerView.Adapter<NewsSourceViewHolder> {

    private var mNews: ArrayList<SourcesItem?>? = null
    private val mCtx: Context
    private var count: Int = 0

    constructor(c: Context, dataIn: ArrayList<SourcesItem?>?) {
        this.mCtx = c
        mNews = dataIn
        count = mNews!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsSourceViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news_source, parent, false)
        return NewsSourceViewHolder(v)
    }

    override fun onBindViewHolder(holder: NewsSourceViewHolder, position: Int) {

        val item = mNews!![position]

        holder.mCvItem.setOnClickListener {
            val i = Intent(mCtx, ArticlesActivity::class.java)
            i.putExtra("sources", item.toString())
            mCtx.startActivity(i)
        }
        holder.mTxtTitle.text = item?.name
        holder.mTxtTitleSupport.text = item?.description
        holder.mTxtSource.text = mCtx.getString(R.string.message_news_source, item?.url)
    }

    override fun getItemCount(): Int {
        return count
    }
}
