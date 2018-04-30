package com.example.jeffer.scheduletestv10

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
//import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.dates_view.*
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*
//import android.R.id.edit
import android.app.Activity
import android.content.SharedPreferences
import android.content.Context.MODE_PRIVATE
import android.widget.EditText
import org.jetbrains.anko.toast
import java.io.IOException


/**
 * Created by Jeffer on 19/04/2018.
 */
class DatesActivity : AppCompatActivity()/*, DateListener.listener*/ {

    var materia: String ?= null
    var button_date : ImageButton ?= null
    var button_date_2 : ImageButton ?= null
    var button_date_3 : ImageButton ?= null
    var input_date_1 : EditText ?= null
    var input_date_2 : EditText ?= null
    var input_date_3 : EditText ?= null
    var val_name_1 : String ?= null
    var val_name_2 : String ?= null
    var val_name_3 : String ?= null

    //var textview_date : TextView ?= null
    var cal = Calendar.getInstance()
    //var selected_date : String ?= null
    //var date_note_name: String?=null

    // First date selector


    // Second date selector


    // Third date selector


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dates_view)

        materia = intent.getStringExtra("materia")
        //date_note_name = intent.getStringExtra("note_name")
        dates_title.text = materia

        //get references from layout
        //var button_date = this.btn_calendar
        //var input_date_1 = date_input

        // First date selector
        button_date = this.btn_calendar
        input_date_1 = this.date_input
        val_name_1 = materia + "_1"
        // Second date selector
        button_date_2 = this.btn_calendar_2
        input_date_2 = this.date_input_2
        val_name_2 = materia + "_2"
        // Third date selector
        button_date_3 = this.btn_calendar_3
        input_date_3 = this.date_input_3
        val_name_3 = materia + "_3"

        loadDate()
        //updateDateInView()


        // Create an OnDateSetListener
        /*val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int){
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        //when click the button, show DataPickerDialog that is set with OnDateSetListener
        button_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@DatesActivity,
                        dateSetListener,
                        // set DataPickerDialog to point to today's date when it loads up
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        try {
            val preferences = this.getSharedPreferences("MyPreferences", Activity.MODE_PRIVATE)
            var set_date = preferences.getString(materia,"--/--/----")
            date_input.setText(set_date)
        } catch (e: IOException){
        }*/

    }

    fun loadDate(){

        DateListener.dateSetListener(cal, button_date!!, input_date_1!!, val_name_1!!, this)
        DateListener.dateSetListener(cal, button_date_2!!, input_date_2!!, val_name_2!!, this)
        DateListener.dateSetListener(cal, button_date_3!!, input_date_3!!, val_name_3!!, this)
    }

    fun save_date(view: View) {

        val date_selected = input_date_1!!.text.toString()
        val date_selected_2 = input_date_2!!.text.toString()
        val date_selected_3 = input_date_3!!.text.toString()
        SystemPreferencesManager.save_date(view, date_selected, val_name_1!!, this)
        SystemPreferencesManager.save_date(view, date_selected_2, val_name_2!!, this)
        SystemPreferencesManager.save_date(view, date_selected_3, val_name_3!!, this)
        toast("Fechas guardadas")
        /*try {
            val preferences = this.getSharedPreferences("MyPreferences", Activity.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString(materia, selected_date) // save the value of date with the name of "materia"
            editor.apply()
        } catch (e: IOException){
        } */

    }

    /*override fun date(){
        updateDateInView()
    }*/

}