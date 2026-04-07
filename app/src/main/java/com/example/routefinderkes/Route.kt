package com.example.routefinderkes

import java.io.Serializable

data class Route(
    val number: String,
    val origin: String,
    val destination: String,
    val stops: List<String>,
    val fare: String
) : Serializable