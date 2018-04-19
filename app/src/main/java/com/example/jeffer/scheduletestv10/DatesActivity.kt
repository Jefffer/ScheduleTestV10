package com.example.jeffer.scheduletestv10

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.dates_view.*
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

/**
 * Created by Jeffer on 19/04/2018.
 */
class DatesActivity : AppCompatActivity() {

    var materia: String?=null
    var button_date : ImageButton ?= null
    var textview_date : TextView ?= null
    var cal = Calendar.getInstance()
    //var date_note_name: String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dates_view)

        materia = intent.getStringExtra("materia")
        //date_note_name = intent.getStringExtra("note_name")
        dates_title.text = materia

        //get references from layout
        textview_date = this.date_input
        button_date = this.btn_calendar

        // Create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
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

    }

    private fun updateDateInView(){
        val myFormat = "dd/MM/yyyy" // format of date
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.getTime())
    }


}