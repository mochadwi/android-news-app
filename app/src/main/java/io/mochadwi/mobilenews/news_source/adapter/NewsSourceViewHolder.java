package io.mochadwi.mobilenews.news_source.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.mochadwi.mobilenews.R;

/**
 * Created by mochadwi on 3/13/18.
 */

public class NewsSourceViewHolder extends RecyclerView.ViewHolder {

    @Nullable @BindView(R.id.txt_title) public TextView mTxtTitle;
    @Nullable @BindView(R.id.txt_supporting) public TextView mTxtTitleSupport;
    @Nullable @BindView(R.id.txt_source) public TextView mTxtSource;

    public NewsSourceViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

