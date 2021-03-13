package com.demo.retrofitexampleapp.api

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request()
            .newBuilder()
            .addHeader("content-Type","application/json")
            .addHeader("X-Platform","Android")
            .addHeader("X-Auth-Token","8768464")
            .build()
        return chain.proceed(request)
    }

}