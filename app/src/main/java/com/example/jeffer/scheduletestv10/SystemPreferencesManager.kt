package com.example.jeffer.scheduletestv10

import android.app.Activity
import android.content.Context
import android.view.View
import com.example.jeffer.scheduletestv10.R.id.date_input
import kotlinx.android.synthetic.main.dates_view.*
import java.io.IOException

/**
 * Created by Jeffer on 20/04/2018.
 */
class SystemPreferencesManager {

    companion object {

        fun save_date(view: View,
                      selected_date: String,
                      materia: String,
                      context : Context ) {

            try {
                val preferences = context.getSharedPreferences("MyPreferences", Activity.MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putString(materia, selected_date) // save the value of date with the name of "materia"
                editor.apply()
            } catch (e: IOException){
            }

        }

    }
}