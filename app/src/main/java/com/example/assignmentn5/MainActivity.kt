package com.example.assignmentn5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.productAddButton).setOnClickListener {
            startActivity(Intent(this, ProductAddActivity::class.java))
        }

        val databaseHelper = ProductDatabaseHelper(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProductAdapter(databaseHelper.getProducts())
        recyclerView.adapter = adapter
    }
}