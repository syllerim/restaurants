package com.syllerim.restaurants.model

import java.io.Serializable

data class Order(var tableId: Int,
                 var dishes: List<Dish>,
                 var total: Double,
                 var extraDetails: String): Serializable {

    override fun toString() = tableId.toString()
}