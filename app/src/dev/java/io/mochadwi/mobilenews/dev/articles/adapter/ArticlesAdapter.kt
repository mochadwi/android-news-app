package io.mochadwi.mobilenews.dev.articles.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.bumptech.glide.Glide
import io.mochadwi.mobilenews.R
import io.mochadwi.mobilenews.articles.adapter.ArticlesViewHolder
import io.mochadwi.mobilenews.dev.articles.ArticlesWebViewActivity
import io.mochadwi.mobilenews.dev.articles.model.ArticlesItem
import io.mochadwi.mobilenews.dev.articles.model.ArticlesModel
import io.mochadwi.mobilenews.util.PublicMethods

/**
 * Created by mochadwi on 3/13/18.
 */
class ArticlesAdapter : RecyclerView.Adapter<ArticlesViewHolder>, Filterable {

    private var mArticles: List<ArticlesItem?>? = null
    private var mFilteredArticles: ArrayList<ArticlesItem?>? = null
    private var count: Int = 0
    private val mCtx: Context

    constructor(c: Context, dataIn: ArticlesModel) {
        this.mCtx = c
        mArticles = dataIn.articles
        mFilteredArticles = mArticles as? ArrayList<ArticlesItem?>
        count = mFilteredArticles!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_articles, parent, false)
        return ArticlesViewHolder(v)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {

        val item = mFilteredArticles?.get(position)

        holder.mCvItem.setOnClickListener {
            val i = Intent(mCtx, ArticlesWebViewActivity::class.java)
            i.putExtra("article", item!!.toString())
            mCtx.startActivity(i)
        }
        holder.mTxtAuthor.text = mCtx.getString(R.string.message_author, item?.author ?: "Unknown")
        holder.mTxtSource.text = item?.source?.name ?: "Unknown"
        Glide.with(mCtx)
                .load(item?.urlToImage)
                .into(holder.mIvMedia)
        holder.mTxtPublished.setReferenceTime(PublicMethods.stringToLocalDate(item?.publishedAt).time)
        holder.mTxtPrimary.text = item!!.title
        holder.mTxtDescription.text = item.description
    }

    override fun getItemCount(): Int {
        return count
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charString = p0.toString()

                when (charString.isEmpty()) {

                    true -> {
                        mFilteredArticles = mArticles as? ArrayList<ArticlesItem?>
                    }
                    false -> {
                        val filteredList = ArrayList<ArticlesItem?>()

                        for (article in mArticles!!.iterator()) {

                            if (article!!.title?.toLowerCase()!!.contains(charString) ||
                                    article.description?.toLowerCase()!!.contains(charString)) {

                                filteredList.add(article)
                            }
                        }

                        mFilteredArticles = filteredList
                        count = filteredList.size
                    }
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = mFilteredArticles

                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                mFilteredArticles = p1?.values as? ArrayList<ArticlesItem?>
                notifyDataSetChanged()
            }
        }
    }
}
