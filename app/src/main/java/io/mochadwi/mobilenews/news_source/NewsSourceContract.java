package io.mochadwi.mobilenews.news_source;

import io.mochadwi.mobilenews.BasePresenter;
import io.mochadwi.mobilenews.BaseView;

public interface NewsSourceContract {
    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {
        void getNews(String apiKey);
    }
}