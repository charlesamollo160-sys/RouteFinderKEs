package com.example.routefinderkes

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val route = intent.getSerializableExtra("EXTRA_ROUTE") as? Route

        route?.let {
            findViewById<TextView>(R.id.textDetailNumber).text = "Route ${it.number}"
            findViewById<TextView>(R.id.textDetailRoute).text = "${it.origin} to ${it.destination}"
            findViewById<TextView>(R.id.textDetailStops).text = "Stops: ${it.stops.joinToString(", ")}"
            findViewById<TextView>(R.id.textDetailFare).text = "Fare: ${it.fare}"
        }
    }
}