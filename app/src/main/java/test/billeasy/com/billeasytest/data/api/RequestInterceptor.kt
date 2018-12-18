package test.billeasy.com.billeasytest.data.api

import okhttp3.Interceptor
import okhttp3.Response
import test.billeasy.com.billeasytest.utils.GIT_API_KEY

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("access_token", GIT_API_KEY)
            .build()

        val request = original.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}