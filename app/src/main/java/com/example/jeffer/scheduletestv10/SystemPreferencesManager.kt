package com.example.jeffer.scheduletestv10

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.EditText
import com.example.jeffer.scheduletestv10.R.id.date_input
import kotlinx.android.synthetic.main.dates_view.*
import java.io.IOException

/**
 * Created by Jeffer on 20/04/2018.
 */
class SystemPreferencesManager {

    companion object {

        fun loadData(selected_data: EditText,
                     var_name: String,
                     context : Context ){
            try {
                val preferences = context.getSharedPreferences("MyPreferences", Activity.MODE_PRIVATE)
                var set_date = preferences.getString(var_name,"")
                selected_data.setText(set_date)
            } catch (e: IOException){
            }

        }

        fun saveData(view: View,
                      selected_data: EditText,
                      var_name: String,
                      context : Context ) {

            try {
                val preferences = context.getSharedPreferences("MyPreferences", Activity.MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putString(var_name, selected_data.text.toString()) // save the value of data with the name of "var_name"
                editor.apply()
            } catch (e: IOException){
            }

        }

    }
}