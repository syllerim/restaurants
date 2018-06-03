package com.syllerim.restaurants.model

import java.io.Serializable

enum class DishCategory {
    STARTER,
    MEET,
    FISH,
    DRINK,
    VEGAN
}

data class Dish(var name: String, var description: String, var image: String, var ingredients: List<String>, var category: DishCategory, var id: String): Serializable {
    override fun toString() = name
}