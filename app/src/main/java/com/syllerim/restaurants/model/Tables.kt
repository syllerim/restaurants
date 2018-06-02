package com.syllerim.restaurants.model

object Cities {

    private val tables: List<Table> = listOf(
            Table("Table 1", numberPlaces = 2),
            Table("Table 2", numberPlaces = 2),
            Table("Table 3", numberPlaces = 4),
            Table("Table 4", numberPlaces = 5),
            Table("Table 5", numberPlaces = 6),
            Table("Table 6", numberPlaces = 6),
            Table("Table 7", numberPlaces = 8),
            Table("Table 8", numberPlaces = 8)
    )

    val count
        get() = tables.size

    fun getTable(index: Int) = tables[index]

    fun getIndex(table: Table) = tables.indexOf(table)

    operator fun get(index: Int) = tables[index]

    fun toArray() = tables.toTypedArray()
}