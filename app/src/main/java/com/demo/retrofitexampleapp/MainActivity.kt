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
import com.demo.retrofitexampleapp.repository.Repository

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)


        val repository= Repository()
        val viewModelFactory=MainViewModelProviderFactory(repository)
        viewModel= ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

            findViewById<Button>(R.id.btn).setOnClickListener{
            val myNumber=findViewById<EditText>(R.id.editTextNumber).text.toString()
            viewModel. getCustomPost(Integer.parseInt(myNumber),"id","desc")
            viewModel.myResponse3.observe(this, Observer{ response->
                if (response.isSuccessful){
                    textView.text = response.body().toString()


                    response.body()?.forEach {

                        Log.d("respon",it.id.toString())
                        Log.d("respon",it.title.toString())
                        Log.d("respon",it.body.toString())
                    }
//                    Log.d("eeee" ,response.body()?.title.toString())
//                    Log.d("eeee" ,response.body()?. id.toString())
//                    Log.d("eeee" ,response.body()?.userId.toString())
//                    Log.d("eeee" ,response.body()?. body.toString())
                }else{
                    Toast.makeText(this,response.code().toString(),Toast.LENGTH_SHORT).show()
                }



            })


        }









    }

}