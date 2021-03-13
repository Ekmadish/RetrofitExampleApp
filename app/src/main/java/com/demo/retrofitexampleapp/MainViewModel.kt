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
  val  myCustomPost1 : MutableLiveData <Response<List<Post>>> =MutableLiveData()
  val  myCustomPost2 : MutableLiveData <Response<List<Post>>> =MutableLiveData()


    fun  getPost(auth:String){
        viewModelScope.launch{
            val response =repository.getPost(auth)
            myResponse.value=response
        }
    }
    fun getPost2(postNumber :Int){
        viewModelScope.launch{
            val response=repository.getPost2(postNumber)
            myResponse2.value=response
        }
    }
    fun getCustomPost(userId :Int,sort:String,order:String){
        viewModelScope.launch{
            val  response=repository.getCustomPosts(userId,sort,order)
            myCustomPost1.value=response
        }
    }
    fun getCustomPosts2(userId:Int,options:Map<String,String>){
         viewModelScope.launch{
             val response=repository.getCustomPosts2(userId, options)
             myCustomPost2.value=response
         }
    }



    fun pushPost(post:Post){
        viewModelScope.launch{
            val response=repository.pushPost(post)
            myResponse.value=response

        }
    }

    fun pushPost2(userId :Int,id :Int,title :String,body:String){
        viewModelScope.launch{
            val response=repository.pushPost2(userId, id, title, body)
            myResponse.value=response
        }
    }
}