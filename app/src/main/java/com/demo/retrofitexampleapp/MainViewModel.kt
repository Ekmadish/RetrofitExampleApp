package com.demo.retrofitexampleapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.retrofitexampleapp.model.Post
import com.demo.retrofitexampleapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository : Repository): ViewModel() {

  val  myResponse : MutableLiveData <Response<Post>> =MutableLiveData()


    fun  getPost(){
        viewModelScope.launch{
            val response =repository.getPost()
            myResponse.value=response
        }
    }
}