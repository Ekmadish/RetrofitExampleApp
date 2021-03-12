package com.demo.retrofitexampleapp.repository

import com.demo.retrofitexampleapp.api.RetrofitInstance
import com.demo.retrofitexampleapp.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
       return RetrofitInstance.api.getPost()
    }
}