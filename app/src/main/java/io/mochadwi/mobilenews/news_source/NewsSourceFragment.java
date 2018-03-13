package io.mochadwi.mobilenews.news_source;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.mochadwi.mobilenews.BuildConfig;
import io.mochadwi.mobilenews.R;
import io.mochadwi.mobilenews.news_source.adapter.NewsSourceAdapter;
import io.mochadwi.mobilenews.news_source.model.NewsSourceModel;

public class NewsSourceFragment extends Fragment implements NewsSourceContract.View {

    // DATA
    private NewsSourceContract.Presenter mPresenter;
    private NewsSourceAdapter mAdapter;

    // UI
    @BindView(R.id.rv_items) RecyclerView mRvItems;
    @BindView(R.id.txt_empty_items) TextView mTxtItems;

    public static NewsSourceFragment newInstance() {
        return new NewsSourceFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(NewsSourceContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_news_source, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mPresenter.getNews(BuildConfig.APIKEY);
    }

    @Override
    public void setRecyclerView(NewsSourceModel data) {

        mTxtItems.setVisibility(View.GONE);
        mRvItems.setVisibility(View.VISIBLE);

        mRvItems.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mAdapter = new NewsSourceAdapter(getContext(), data);
        mRvItems.setAdapter(mAdapter);
    }

    private ProgressDialog progress;

    @Override
    public void showToast(@NotNull String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progress = new ProgressDialog(getContext());
        progress.setCancelable(true); // disable dismiss by tapping outside of the dialog
        progress.show();
        progress.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progress.setContentView(R.layout.progress_bar);
    }

    @Override
    public void hideProgress() {
        if (progress != null) { //null checker
            progress.dismiss();
        }
    }
}
