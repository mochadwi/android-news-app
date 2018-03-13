package io.mochadwi.mobilenews.network

import io.mochadwi.mobilenews.BuildConfig
import io.mochadwi.mobilenews.model.news_source.UnsafeOkHttpClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.security.cert.CertificateException
import java.util.concurrent.TimeUnit
import javax.net.ssl.*

/**
 * Created by mochadwi on 3/13/18.
 */
class RESTGenerator {

    companion object {
        private val logging = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

        fun getRetrofitClient(): Retrofit {
            return buildClient(BuildConfig.BASEURL)
        }

        fun getRetrofitClient(url: String): Retrofit {
            return buildClient(url)
        }

        private fun buildClient(url: String): Retrofit {
            val okHttpClient = OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)


            okHttpClient.addInterceptor(logging)

            return Retrofit.Builder()
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(url)
                    .client(UnsafeOkHttpClient.getUnsafeOkHttpClient())
                    .build()
        }

    }
}