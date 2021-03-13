 package com.demo.retrofitexampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.retrofitexampleapp.adapter.MyAdapter
import com.demo.retrofitexampleapp.model.Post
import com.demo.retrofitexampleapp.repository.Repository
import kotlin.math.log

 class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy{MyAdapter()}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository= Repository()
        val viewModelFactory=MainViewModelProviderFactory(repository)
        viewModel= ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        setupRecyclerView()

//        val post=Post("demo body from Estay",147,"from Estay Post",147)
        viewModel.pushPost2(147,101,"Estay","Demo post from Estay@@@@@@")
        viewModel.myResponse.observe(this,Observer {
            if(it.isSuccessful){
                Log.d("response",it.body().toString())
                Log.d("response",it.body()?.title.toString())
                Log.d("response","*******************************")
                Log.d("response",it.code().toString())
                Log.d("response","*******************************")
                Log.d("response",it.body()?.id.toString())
                Log.d("response",it.body()?.userId.toString())


//                it.body()?.let { it1 -> myAdapter.setData(it1) }
            }else{
                Toast.makeText(this,it.code().toString(),Toast.LENGTH_SHORT).show()
            }
        })}

    private fun setupRecyclerView(){

        findViewById< RecyclerView>(R.id.recyclerView).adapter=myAdapter
        findViewById< RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)


    }

}