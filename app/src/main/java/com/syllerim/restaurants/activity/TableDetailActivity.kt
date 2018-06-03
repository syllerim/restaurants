package com.syllerim.restaurants.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.EditText
import com.syllerim.restaurants.R
import com.syllerim.restaurants.fragment.TableDetailFragment
import com.syllerim.restaurants.model.Tables
import kotlinx.android.synthetic.main.activity_table_detail.*
import kotlinx.android.synthetic.main.content_table.*

class TableDetailActivity() : AppCompatActivity() {

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

                val data = Tables.allItems[tableIndex]

                //update interface
                table_name_text?.text = data.name

                if (supportFragmentManager.findFragmentById(R.id.table_detail_fragment) == null) {
                    val fragment = TableDetailFragment.newInstance(data)
                    supportFragmentManager.beginTransaction()
                            .add(R.id.table_detail_fragment, fragment)
                            .commit()
                }
            }
        }

        add_button.setOnClickListener {

        }

    }

}