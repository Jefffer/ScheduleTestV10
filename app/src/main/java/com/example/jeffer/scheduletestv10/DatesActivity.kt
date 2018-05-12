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

    private var materia: String ?= null
    private var button_date : ImageButton ?= null
    private var button_date_2 : ImageButton ?= null
    private var button_date_3 : ImageButton ?= null
    private var input_date_1 : EditText ?= null
    private var input_date_2 : EditText ?= null
    private var input_date_3 : EditText ?= null
    private var qualif_input_1 : EditText ?= null
    private var qualif_input_2 : EditText ?= null
    private var qualif_input_3 : EditText ?= null
    private var perc_input_1 : EditText ?= null
    private var perc_input_2 : EditText ?= null
    private var perc_input_3 : EditText ?= null
    private var val_name_1 : String ?= null
    private var val_name_2 : String ?= null
    private var val_name_3 : String ?= null
    private var qual_name_1 : String ?= null
    private var qual_name_2 : String ?= null
    private var qual_name_3 : String ?= null
    private var perc_name_1 : String ?= null
    private var perc_name_2 : String ?= null
    private var perc_name_3 : String ?= null

    private var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dates_view)

        materia = intent.getStringExtra("materia")
        dates_title.text = materia

        // First selector
        button_date = this.btn_calendar
        input_date_1 = this.date_input
        qualif_input_1 = this.qualification_input
        perc_input_1 = this.percent_input
        val_name_1 = materia + "_1"
        qual_name_1 = materia + "_qual_1"
        perc_name_1 = materia + "_per_1"

        // Second selector
        button_date_2 = this.btn_calendar_2
        input_date_2 = this.date_input_2
        qualif_input_2 = this.qualification_input_2
        perc_input_2 = this.percent_input_2
        val_name_2 = materia + "_2"
        qual_name_2 = materia + "_qual_2"
        perc_name_2 = materia + "_per_2"

        // Third selector
        button_date_3 = this.btn_calendar_3
        input_date_3 = this.date_input_3
        qualif_input_3 = this.qualification_input_3
        perc_input_3 = this.percent_input_3
        val_name_3 = materia + "_3"
        qual_name_3 = materia + "_qual_3"
        perc_name_3 = materia + "_per_3"

        loadDate()
        loadPercentage()
        loadQualification()
        hideKeyboard()
    }

    private fun hideKeyboard() {
        HideKeyboard.checkEditTextFocus(this, qualification_input)
        HideKeyboard.checkEditTextFocus(this, qualification_input_2)
        HideKeyboard.checkEditTextFocus(this, qualification_input_3)
        HideKeyboard.checkEditTextFocus(this, percent_input)
        HideKeyboard.checkEditTextFocus(this, percent_input_2)
        HideKeyboard.checkEditTextFocus(this, percent_input_3)
    }

    private fun loadPercentage() {
        SystemPreferencesManager.loadData(perc_input_1!!, perc_name_1!!, this)
        SystemPreferencesManager.loadData(perc_input_2!!, perc_name_2!!, this)
        SystemPreferencesManager.loadData(perc_input_3!!, perc_name_3!!, this)
    }

    private fun loadQualification() {
        SystemPreferencesManager.loadData(qualif_input_1!!, qual_name_1!!, this)
        SystemPreferencesManager.loadData(qualif_input_2!!, qual_name_2!!, this)
        SystemPreferencesManager.loadData(qualif_input_3!!, qual_name_3!!, this)
    }

    // Set the button as DatePicker and set the selected value for each input
    private fun loadDate(){
        // Call the static dateSetListener function from DateListener class
        DateListener.dateSetListener(cal, button_date!!, input_date_1!!, val_name_1!!, this)
        DateListener.dateSetListener(cal, button_date_2!!, input_date_2!!, val_name_2!!, this)
        DateListener.dateSetListener(cal, button_date_3!!, input_date_3!!, val_name_3!!, this)
    }

    // Save selected date from datePicker to the User Preferences
    fun saveSelectedData(view: View) {
        // Validation if one of the the percentage inputs are empty
        if (percent_input.text.toString().isEmpty()) perc_input_1!!.setText("0")
        if (percent_input_2.text.toString().isEmpty()) perc_input_2!!.setText("0")
        if (percent_input_3.text.toString().isEmpty()) perc_input_3!!.setText("0")

        // Call the static saveDate function from SystemPreferencesManager
        SystemPreferencesManager.saveData(view, input_date_1!!, val_name_1!!, this)
        SystemPreferencesManager.saveData(view, input_date_2!!, val_name_2!!, this)
        SystemPreferencesManager.saveData(view, input_date_3!!, val_name_3!!, this)
        SystemPreferencesManager.saveData(view, qualif_input_1!!, qual_name_1!!, this)
        SystemPreferencesManager.saveData(view, qualif_input_2!!, qual_name_2!!, this)
        SystemPreferencesManager.saveData(view, qualif_input_3!!, qual_name_3!!, this)
        SystemPreferencesManager.saveData(view, perc_input_1!!, perc_name_1!!, this)
        SystemPreferencesManager.saveData(view, perc_input_2!!, perc_name_2!!, this)
        SystemPreferencesManager.saveData(view, perc_input_3!!, perc_name_3!!, this)
        toast("¡Guardado correctamente!")
    }

    fun cancel(view: View){
        startActivity<ScheduleActivity>()
    }
}