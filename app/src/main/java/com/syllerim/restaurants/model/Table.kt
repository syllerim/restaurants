package com.syllerim.restaurants.model

import java.io.Serializable

data class Table(var name: String, var numberPlaces: Int): Serializable {
    override fun toString() = name
}