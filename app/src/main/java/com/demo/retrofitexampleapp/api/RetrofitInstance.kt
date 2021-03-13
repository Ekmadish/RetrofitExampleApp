package com.demo.retrofitexampleapp.api

import com.demo.retrofitexampleapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitInstance {
    private val headerClient = OkHttpClient.Builder().also {
        it.addInterceptor(MyInterceptor())
    }.build()



    private val retrofit  by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(headerClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }

}