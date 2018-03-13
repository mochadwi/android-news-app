package io.mochadwi.mobilenews.news_source;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;
import io.mochadwi.mobilenews.BuildConfig;
import io.mochadwi.mobilenews.R;

public class NewsSourceFragment extends Fragment implements NewsSourceContract.View {

    private NewsSourceContract.Presenter mPresenter;

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
