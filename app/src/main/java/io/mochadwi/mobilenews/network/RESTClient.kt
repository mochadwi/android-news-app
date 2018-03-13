package io.mochadwi.mobilenews.network

import io.mochadwi.mobilenews.news_source.model.NewsSourceModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by mochadwi on 3/13/18.
 */
interface RESTClient {

    @GET("sources")
    fun getRecommendedSources(@Query("apiKey") action: String): Call<NewsSourceModel>
}