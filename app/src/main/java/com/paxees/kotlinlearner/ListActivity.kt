package com.paxees.kotlinlearner

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListActivity : AppCompatActivity() {
    var list: ArrayList<mForm> = ArrayList()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        var recyclerVIew:RecyclerView=findViewById(R.id.recyclerView)
        var intent: Intent? = intent
        list = intent?.extras?.getSerializable("ARRAYLIST") as ArrayList<mForm>
        var adapter=RecyclerAdapter(this,list)
        recyclerVIew.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerVIew.adapter = adapter

    }
}
