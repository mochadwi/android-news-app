package io.mochadwi.mobilenews.network

import io.mochadwi.mobilenews.model.news_source.NewsSourceModel
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by mochadwi on 3/13/18.
 */
interface RESTClient {

    @GET("sources")
    fun getRecommendedSources(@Query("apiKey") action: String): Observable<NewsSourceModel>
}