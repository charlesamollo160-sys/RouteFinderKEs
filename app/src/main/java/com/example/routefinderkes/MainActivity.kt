package com.example.routefinderkes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val routeList = listOf(
            Route("7C", "CBD", "Pipeline", listOf("Imara Daima", "Cabanas"), "KSh 50-80"),
            Route("23", "CBD", "Ngong", listOf("Adams", "Karen"), "KSh 60-100"),
            Route("105", "CBD", "Thika", listOf("Githurai", "Juja"), "KSh 80-120"),
            Route("4W", "CBD", "Westlands", listOf("Museum", "Mpaka Rd"), "KSh 40-50"),
            Route("33B", "CBD", "Embakasi", listOf("Fedha", "Nyayo Estate"), "KSh 50-70")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRoutes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RouteAdapter(routeList) { route ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("EXTRA_ROUTE", route)
            startActivity(intent)
        }
    }
}