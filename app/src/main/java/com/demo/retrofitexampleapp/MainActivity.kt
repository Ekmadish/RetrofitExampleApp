package com.demo.retrofitexampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.demo.retrofitexampleapp.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository= Repository()
        val viewModelFactory=MainViewModelProviderFactory(repository)
        viewModel= ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer{ response->
            if (response.isSuccessful){
                Log.d("eeee" ,response.body()?.title.toString())
                Log.d("eeee" ,response.body()?. id.toString())
                Log.d("eeee" ,response.body()?.userId.toString())
                Log.d("eeee" ,response.body()?. body.toString())
            }else{
                Toast.makeText(this,response.code().toString(),Toast.LENGTH_SHORT).show()
            }


        })




    }
}