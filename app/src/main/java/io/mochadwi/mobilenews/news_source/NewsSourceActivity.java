package io.mochadwi.mobilenews.news_source;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.mochadwi.mobilenews.R;
import io.mochadwi.mobilenews.util.ActivityHelper;

public class NewsSourceActivity extends AppCompatActivity {

    private NewsSourceContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_source);

        NewsSourceFragment view = (NewsSourceFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_layout);

        if (view == null) {
            view = NewsSourceFragment.newInstance();

            ActivityHelper.Companion.addFragmentToActivity(getSupportFragmentManager(),
                    view, R.id.fragment_layout);
        }

        mPresenter = new NewsSourcePresenter(view);
        mPresenter.start();
    }
}