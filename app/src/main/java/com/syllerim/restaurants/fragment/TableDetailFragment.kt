package com.syllerim.restaurants.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.syllerim.restaurants.model.Table

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
}