package com.syllerim.restaurants.model

import java.io.Serializable

data class Table(var id:Int, var name: String): Serializable {
    override fun toString() = name
}