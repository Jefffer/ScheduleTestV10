package com.example.jeffer.scheduletestv10

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.dates_view.*
import java.io.IOException
import java.util.*

/**
 * Created by Jeffer on 20/04/2018.
 */
class DateListener {

    companion object {

        fun dateSetListener(/*view: View,*/
                            cal: Calendar,
                            button_date: ImageButton,
                            date_input: EditText,
                            materia: String,
                            context: Context /*listener: DateListener = context as DateListener*/) {

// Create an OnDateSetListener
            val dateSetListener = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int){
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    //updateDateInView()
                    //listener.date()
                }
            }

            //when click the button, show DataPickerDialog that is set with OnDateSetListener
            button_date.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View) {
                    DatePickerDialog(context,
                            dateSetListener,
                            // set DataPickerDialog to point to today's date when it loads up
                            cal.get(Calendar.YEAR),
                            cal.get(Calendar.MONTH),
                            cal.get(Calendar.DAY_OF_MONTH)).show()
                }
            })

            try {
                val preferences = context.getSharedPreferences("MyPreferences", Activity.MODE_PRIVATE)
                var set_date = preferences.getString(materia,"--/--/----")
                date_input.setText(set_date)
            } catch (e: IOException){
            }

        }
    }

    /*interface listener{
        fun date()
    }*/
}