package test.billeasy.com.billeasytest.injection.module

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory.*
import test.billeasy.com.billeasytest.BuildConfig
import test.billeasy.com.billeasytest.data.api.GitApi
import test.billeasy.com.billeasytest.data.api.RequestInterceptor
import test.billeasy.com.billeasytest.utils.BASE_URL
import test.billeasy.com.billeasytest.utils.CONNECT_TIMEOUT_IN_MS
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@Suppress("unused")
object NetworkModule {

    /**
     * Provides the RequestInterceptor object.
     * @return the RequestInterceptor object
     */
    @Singleton
    @Provides
    internal fun provideRequestInterceptor(): RequestInterceptor {
        return RequestInterceptor()
    }

    /**
     * Provides the OkHttpClient object.
     * @param requestInterceptor
     * @return the OkHttpClient object
     */
    @Singleton
    @Provides
    internal fun provideOkHttpClient(requestInterceptor: RequestInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(CONNECT_TIMEOUT_IN_MS.toLong(), TimeUnit.MILLISECONDS).addInterceptor(requestInterceptor)

        if(BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }

        return builder.build()
    }

    /**
     * Provides the Retrofit object.
     * @param okHttpClient
     * @return the Retrofit object
     */

    @Singleton
    @Provides
    internal fun provideRetrofitInterface(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okHttpClient)
            .build()
    }

    /**
     * Provides the Retrofit object.
     * @param retrofit
     * @return the GitApi object
     */
    @Singleton
    @Provides
    internal fun provideGitApi(retrofit: Retrofit): GitApi {
        return retrofit.create<GitApi>(GitApi::class.java)
    }
}