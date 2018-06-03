package com.syllerim.restaurants.model

object Tables {

    private val tables: List<Table> = listOf(
            Table(1,"Table 1"),
            Table(2,"Table 2"),
            Table(3,"Table 3"),
            Table(4,"Table 4"),
            Table(5,"Table 5"),
            Table(6,"Table 6"),
            Table(7,"Table 7"),
            Table(8,"Table 8")
    )

    var allItems = tables
        private set

    val count
        get() = tables.size

    fun getTable(index: Int) = tables[index]

    fun getIndex(table: Table) = tables.indexOf(table)

    operator fun get(index: Int) = tables[index]

    fun toArray() = tables.toTypedArray()
}