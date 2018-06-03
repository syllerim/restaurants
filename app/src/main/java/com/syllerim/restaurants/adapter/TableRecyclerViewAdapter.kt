package com.syllerim.restaurants.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.syllerim.restaurants.R
import com.syllerim.restaurants.model.Table

class TableRecyclerViewAdapter(private val table: List<Table>): RecyclerView.Adapter<TableRecyclerViewAdapter.TableViewHolder>() {

    var onClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_table, parent, false)
        view.setOnClickListener {
            onClickListener?.onClick(it)
        }
        return TableViewHolder(view)
    }

    override fun getItemCount(): Int = table.size

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        holder.bindForecast(table[position], position)
    }

    inner class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tableNameText = itemView.findViewById<TextView?>(R.id.table_name)

        fun bindForecast(table: Table, position: Int) {
            tableNameText?.text = table.name
        }

    }
}