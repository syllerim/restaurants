package com.syllerim.restaurants.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.syllerim.restaurants.R
import com.syllerim.restaurants.fragment.TableDetailFragment
import com.syllerim.restaurants.model.Tables

class TableDetailActivity: AppCompatActivity() {
    companion object {

        val EXTRA_TABLE_INDEX = "EXTRA_TABLE_INDEX"

        fun intent(context: Context, tableIndex: Int): Intent {
            val intent = Intent(context, TableDetailActivity::class.java)
            intent.putExtra(EXTRA_TABLE_INDEX, tableIndex)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_table_detail)

        if (findViewById<ViewGroup>(R.id.table_detail_fragment) != null) {

            if (supportFragmentManager.findFragmentById(R.id.table_detail_fragment) == null) {

                val tableIndex = intent.getIntExtra(EXTRA_TABLE_INDEX, 0)

                if (supportFragmentManager.findFragmentById(R.id.table_detail_fragment) == null) {
                    val fragment = TableDetailFragment.newInstance(Tables.allItems[tableIndex])
                    supportFragmentManager.beginTransaction()
                            .add(R.id.table_detail_fragment, fragment)
                            .commit()
                }
            }
        }

    }
}