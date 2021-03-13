package com.demo.retrofitexampleapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.retrofitexampleapp.R
import com.demo.retrofitexampleapp.model.Post

class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var myList=emptyList<Post>()


    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.itemView.findViewById<TextView>(R.id.textView_id).text=myList[position].id.toString()
       holder.itemView.findViewById<TextView>(R.id.textView_userId).text=myList[position].userId.toString()
       holder.itemView.findViewById<TextView>(R.id.textView_name).text=myList[position].title.toString()
       holder.itemView.findViewById<TextView>(R.id.textView_body).text=myList[position].body.toString()
    }
    override fun getItemCount()=myList.size

    fun setData(newList: List<Post>){
        myList=newList
        notifyDataSetChanged()
    }
}