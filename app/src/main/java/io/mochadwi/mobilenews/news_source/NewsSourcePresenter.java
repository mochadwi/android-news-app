package io.mochadwi.mobilenews.news_source;

import io.mochadwi.mobilenews.news_source.model.NewsSourceModel;
import io.mochadwi.mobilenews.network.RESTClient;
import io.mochadwi.mobilenews.network.RESTGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewsSourcePresenter implements NewsSourceContract.Presenter {

    private final NewsSourceContract.View mView;
    private final Retrofit mRest = RESTGenerator.Companion.getRetrofitClient();

    public NewsSourcePresenter(NewsSourceContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {
        mView.setPresenter(this);
    }

    @Override
    public void getNews(String apiKey) {
        mView.showProgress();

        mRest
                .create(RESTClient.class)
                .getRecommendedSources(apiKey)
                .enqueue(new Callback<NewsSourceModel>() {
                    @Override
                    public void onResponse(Call<NewsSourceModel> call, Response<NewsSourceModel> response) {
                        mView.hideProgress();
//                        mView.showToast(response.body().toString());
                        mView.setRecyclerView(response.body());
                    }

                    @Override
                    public void onFailure(Call<NewsSourceModel> call, Throwable t) {
                        mView.hideProgress();
                        mView.showToast(t.getMessage());
                    }
                });
    }
}