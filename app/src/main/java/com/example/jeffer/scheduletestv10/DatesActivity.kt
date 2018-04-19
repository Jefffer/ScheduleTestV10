package com.example.jeffer.scheduletestv10

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.dates_view.*

/**
 * Created by Jeffer on 19/04/2018.
 */
class DatesActivity : AppCompatActivity() {

    var materia: String?=null
    //var date_note_name: String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dates_view)

        materia = intent.getStringExtra("materia")
        //date_note_name = intent.getStringExtra("note_name")
        dates_title.text = materia

    }


}