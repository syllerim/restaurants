package com.syllerim.restaurants.model

object Dishes {

    private val dishes: List<Dish> = listOf(
            Dish("Coconut Rice", "Tipical Colombian Rice with coconut", "icn_coconut", listOf("White Rice", "Coconut", "Fish", "Green Banana"), DishCategory.FISH, "1"),
            Dish("Russian Salad", "Tipical Russian Salad", "icn_russian_salad", listOf("Potatoes", "Mayonnaise", "Carrot", "Green Shelters"), DishCategory.STARTER, "2"),
            Dish("Flauta", "Tipical Spanish Thing", "icn_flauta", listOf("bread", "tomato", "jam"), DishCategory.STARTER, "3")
    )

    var allItems = dishes
        private set

    val count
        get() = dishes.size

    fun getTable(index: Int) = dishes[index]

    fun getIndex(dish: Dish) = dishes.indexOf(dish)

    operator fun get(index: Int) = dishes[index]

    fun toArray() = dishes.toTypedArray()
}