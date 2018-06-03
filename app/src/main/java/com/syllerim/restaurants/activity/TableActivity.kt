package com.syllerim.restaurants.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.syllerim.restaurants.R
import com.syllerim.restaurants.fragment.TableFragment
import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : AppCompatActivity() {

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
}
