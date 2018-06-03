package com.syllerim.restaurants.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.syllerim.restaurants.R
import com.syllerim.restaurants.fragment.TableFragment
import com.syllerim.restaurants.fragment.TableFragment.OnTableSelectedListener
import com.syllerim.restaurants.model.Table


class TableActivity() : AppCompatActivity(), OnTableSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        if (findViewById<ViewGroup>(R.id.table_list_fragment) != null) {

            if (supportFragmentManager.findFragmentById(R.id.table_list_fragment) == null) {

                val fragment = TableFragment.newInstance()

                supportFragmentManager.beginTransaction()
                        .add(R.id.table_list_fragment, fragment)
                        .commit()
            }
        }
    }

    override fun onTableSelected(table: Table, position: Int) {
        val intent = TableDetailActivity.intent(this, position)
        startActivity(intent)
    }

}
