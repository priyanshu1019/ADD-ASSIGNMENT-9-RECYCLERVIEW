package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val exampleList = generateList(100)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.adapter = ExampleAdapter(exampleList)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun generateList(size: Int):List<ExampleItem>{
        val list = mutableListOf<ExampleItem>()

        for (i in 0 until 100){
            val item = ExampleItem("This is item $i")
            list.add(item)
        }

        return list
    }
}