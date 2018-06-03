package com.syllerim.restaurants.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syllerim.restaurants.R
import com.syllerim.restaurants.adapter.TableRecyclerViewAdapter
import com.syllerim.restaurants.model.Table
import com.syllerim.restaurants.model.Tables
import kotlinx.android.synthetic.main.fragment_table_list.*

class TableFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = TableFragment()
    }

    private var onTableSelectedListener: OnTableSelectedListener? = null

    val list: RecyclerView by lazy {
        val list: RecyclerView = view!!.findViewById(R.id.table_list)
        list.layoutManager = GridLayoutManager(context, 2)
        list
    }

    var tableData: List<Table>? = null
        set(value) {
            field = value

            if (value != null) {
                val adapter = TableRecyclerViewAdapter(value)
                table_list.adapter = adapter
                setRecyclerViewClickListener()
            }
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_table_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        table_list.layoutManager = GridLayoutManager(activity, 2)
        table_list.itemAnimator = DefaultItemAnimator()
        tableData = Tables.allItems
    }

    fun setRecyclerViewClickListener() {
        val adapter = table_list?.adapter as? TableRecyclerViewAdapter
        adapter?.onClickListener = View.OnClickListener {
            val index = table_list.getChildAdapterPosition(it)
            val table = Tables.allItems[index]
            onTableSelectedListener?.onTableSelected(table, index)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        commonAttach(context as Activity)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        commonAttach(activity)
    }

    private fun commonAttach(activity: Activity?) {
        if (activity is OnTableSelectedListener) {
            onTableSelectedListener = activity
        }
        else {
            onTableSelectedListener = null
        }
    }

    override fun onDetach() {
        super.onDetach()

        onTableSelectedListener = null
    }

    interface OnTableSelectedListener {
        fun onTableSelected(table: Table, position: Int)
    }
}
