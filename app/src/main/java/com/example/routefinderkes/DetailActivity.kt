package com.example.routefinderkes

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val route = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("EXTRA_ROUTE", Route::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("EXTRA_ROUTE") as? Route
        }

        route?.let {
            findViewById<TextView>(R.id.textDetailNumber).text = getString(R.string.route_number, it.number)
            findViewById<TextView>(R.id.textDetailRoute).text = getString(R.string.route_path, it.origin, it.destination)
            findViewById<TextView>(R.id.textDetailStops).text = getString(R.string.route_stops, it.stops.joinToString(", "))
            findViewById<TextView>(R.id.textDetailFare).text = getString(R.string.route_fare, it.fare)
        }
    }
}