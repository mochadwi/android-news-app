package io.mochadwi.mobilenews.news_source.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import io.mochadwi.mobilenews.R;
import io.mochadwi.mobilenews.news_source.model.NewsSourceModel;
import io.mochadwi.mobilenews.news_source.model.SourcesItem;
import io.mochadwi.mobilenews.news_source.model.SourcesItem;

/**
 * Created by mochadwi on 3/13/18.
 */
public class NewsSourceAdapter extends RecyclerView.Adapter<NewsSourceViewHolder> {

    private NewsSourceModel mNews;
    private Context mCtx;

    public NewsSourceAdapter() {

    }

    public NewsSourceAdapter(Context c, NewsSourceModel dataIn) {
        this.mCtx = c;
        mNews = dataIn;
    }

    @Override
    public NewsSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news_source, parent, false);
        return new NewsSourceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsSourceViewHolder holder, int position) {

        SourcesItem item = mNews.getSources().get(position);

        holder.mTxtTitle.setText(item.getName());
        holder.mTxtTitleSupport.setText(item.getDescription());
        holder.mTxtSource.setText(mCtx.getString(R.string.message_news_source, item.getUrl()));
    }

    @Override
    public int getItemCount() {
        return mNews.getSources().size();
    }
}
