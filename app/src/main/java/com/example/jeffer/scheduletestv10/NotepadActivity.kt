package com.example.jeffer.scheduletestv10

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.notepad_view.*
import org.jetbrains.anko.db.*
import org.jetbrains.anko.toast

/**
 * Created by Jeffer on 4/02/2018.
 */
class NotepadActivity : AppCompatActivity() {

    var id_vista : String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notepad_view)
        var materia = intent.getStringExtra("materia")
        notepad_title.text = materia
        id_vista = intent.getIntExtra("id_vista", 0).toString()
        //var temporal = editTextNota.setText(id_vista)
    }

    fun save_file(view: View, db: SQLiteDatabase){
        var select = db.select("Notes", "note")
                .whereArgs("{id} == 1")

        editTextNota.setText(select.toString())
        //toast("Nota guardada")

    }

}