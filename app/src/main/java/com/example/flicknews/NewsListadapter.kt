package com.example.flicknews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecyclerListener
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class NewsListadapter(private val items: ArrayList<String>,private val listener:NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        val viewHolder=NewsViewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.bindingAdapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem=items[position]
        holder.titleView.text=currentItem
    }
}
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titleView: TextView = itemView.findViewById(R.id.title)
}

interface NewsItemClicked{
    fun onItemClicked(Item:String)
}
