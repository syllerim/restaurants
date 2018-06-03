package com.syllerim.restaurants.fragment

import android.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.syllerim.restaurants.model.Dish
import com.syllerim.restaurants.model.Dishes
import com.syllerim.restaurants.model.Order
import com.syllerim.restaurants.model.Table
import kotlinx.android.synthetic.main.fragment_table_detail.*

class TableDetailFragment: Fragment() {

    companion object {
        val ARG_TABLE = "ARG_TABLE"

        fun newInstance(table: Table): Fragment {
            val fragment = TableDetailFragment()
            val arguments = Bundle()
            arguments.putSerializable(ARG_TABLE, table)
            fragment.arguments = arguments
            return fragment
        }
    }

    private var onDishSelectedListener: OnDishSelectedListener? = null

    var selectedDishes: MutableList<Dish>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.syllerim.restaurants.R.layout.fragment_table_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter<Dish>(
                activity,
                android.R.layout.simple_list_item_1,
                selectedDishes)

        order_list.adapter

        order_list.setOnItemClickListener { _, _, index, _ ->
            onDishSelectedListener?.onDishSelected(Dishes.allItems[index], index)
        }

    }

    override fun onDetach() {
        super.onDetach()
        onDishSelectedListener = null
    }

    interface OnDishSelectedListener {
        fun onDishSelected(dish: Dish, position: Int)
    }

}