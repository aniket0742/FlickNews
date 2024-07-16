package com.example.flicknews

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), NewsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView=findViewById(R.id.myRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val items= fetchData()
        val adapter = NewsListadapter(items,this)
        recyclerView.adapter= adapter
    }
    private fun fetchData():ArrayList<String>{
        val list= ArrayList<String>()
        for(i in 0 until 100){
            list.add("Item $i")
        }
        return list
    }

    override fun onItemClicked(Item: String) {
        Toast.makeText(this,"clicked on item $Item",Toast.LENGTH_LONG).show()
    }
}