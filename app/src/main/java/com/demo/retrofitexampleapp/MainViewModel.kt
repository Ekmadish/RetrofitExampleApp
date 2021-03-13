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
  val  myResponse2 : MutableLiveData <Response<Post>> =MutableLiveData()


    fun  getPost(){
        viewModelScope.launch{
            val response =repository.getPost()
            myResponse.value=response
        }
    }


    fun getPost2(postNumber :Int){
        viewModelScope.launch{
            val response=repository.getPost2(postNumber)
            myResponse2.value=response
        }
    }

}