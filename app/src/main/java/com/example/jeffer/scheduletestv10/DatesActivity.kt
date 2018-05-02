package com.example.jeffer.scheduletestv10

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.dates_view.*
import java.util.*
import android.widget.EditText
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

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
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dates_view)

        materia = intent.getStringExtra("materia")
        dates_title.text = materia

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
    }

    // Set the button as DatePicker and set the selected value for each input
    fun loadDate(){
        // Call the static dateSetListener function from DateListener class
        DateListener.dateSetListener(cal, button_date!!, input_date_1!!, val_name_1!!, this)
        DateListener.dateSetListener(cal, button_date_2!!, input_date_2!!, val_name_2!!, this)
        DateListener.dateSetListener(cal, button_date_3!!, input_date_3!!, val_name_3!!, this)
    }

    // Save selected date from datePicker to the User Preferences
    fun saveSelectedDate(view: View) {
        // Call the static saveDate function from SystemPreferencesManager
        val date_selected = input_date_1!!.text.toString()
        val date_selected_2 = input_date_2!!.text.toString()
        val date_selected_3 = input_date_3!!.text.toString()
        SystemPreferencesManager.saveDate(view, date_selected, val_name_1!!, this)
        SystemPreferencesManager.saveDate(view, date_selected_2, val_name_2!!, this)
        SystemPreferencesManager.saveDate(view, date_selected_3, val_name_3!!, this)
        toast("Fechas guardadas")
    }

    fun cancel(view: View){
        startActivity<ScheduleActivity>()
    }



    /*override fun date(){
        updateDateInView()
    }*/

}