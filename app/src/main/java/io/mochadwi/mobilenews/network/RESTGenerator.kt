package io.mochadwi.mobilenews.network

import io.mochadwi.mobilenews.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by mochadwi on 3/13/18.
 */
class RESTGenerator {

    companion object {
        val logging = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

        fun getRetrofitClient(): Retrofit {
            return buildClient(BuildConfig.BASEURL)
        }

        fun getRetrofitClient(url: String): Retrofit {
            return buildClient(url)
        }

        private fun buildClient(url: String): Retrofit {

            return Retrofit.Builder()
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(url)
                    .client(UnsafeOkhttpClient.unsafeOkHttpClient)
                    .build()
        }

        fun <S> createService(url: String, serviceClass: Class<S>): S {

            return buildClient(url).create(serviceClass)
        }

    }
}