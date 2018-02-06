package com.example.jeffer.scheduletestv10

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.notepad_view.*
import org.jetbrains.anko.toast

/**
 * Created by Jeffer on 4/02/2018.
 */
class NotepadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notepad_view)
        var materia = intent.getStringExtra("materia")
        notepad_title.text = materia
    }

    fun save_file(){
        toast("Nota guardada")
    }

}