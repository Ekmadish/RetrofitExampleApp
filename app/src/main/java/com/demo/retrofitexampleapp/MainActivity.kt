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
import com.demo.retrofitexampleapp.repository.Repository

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
        viewModel.getCustomPost(2,"id","desc")
        viewModel.myCustomPost1.observe(this,Observer {
            if(it.isSuccessful){
                it.body()?.let { it1 -> myAdapter.setData(it1) }
            }else{
                Toast.makeText(this,it.code().toString(),Toast.LENGTH_SHORT).show()
            }
        })}

    private fun setupRecyclerView(){

        findViewById< RecyclerView>(R.id.recyclerView).adapter=myAdapter
        findViewById< RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)


    }

}