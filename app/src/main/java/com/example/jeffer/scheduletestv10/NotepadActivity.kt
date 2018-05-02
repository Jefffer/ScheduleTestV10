package com.example.jeffer.scheduletestv10

//import android.database.sqlite.SQLiteDatabase
//import org.jetbrains.anko.db.*
import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.notepad_view.*
import java.io.*
import java.lang.StringBuilder
import android.widget.RelativeLayout
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


/**
 * Created by Jeffer on 4/02/2018.
 */
class NotepadActivity : AppCompatActivity() {

    //var id_vista : String ?= null
    var note_name : String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notepad_view)
        var materia = intent.getStringExtra("materia")
        note_name = intent.getStringExtra("note_name")
        notepad_title.text = materia
        //id_vista = intent.getIntExtra("id_vista", 0).toString()
        //var temporal = editTextNota.setText(id_vista)

        if(fileList().contains("notas.txt")){
            try {
                //val file = InputStreamReader(openFileInput("notas.txt"))
                val file = InputStreamReader(openFileInput(note_name))
                val br = BufferedReader(file)
                var line = br.readLine()
                val all = StringBuilder()
                while (line != null){
                    all.append(line + "\n")
                    line = br.readLine()
                }
                br.close()
                file.close()
                editTextNota.setText(all)

            }catch (e: IOException){
            }
        }
    }

    // Function for let the FAB above the keyboard
    /*fun fab_up(view: View){
        var parameter = fab_save_note.getLayoutParams() as RelativeLayout.LayoutParams
        parameter.setMargins(parameter.leftMargin, parameter.topMargin, parameter.rightMargin, 200) // left, top, right, bottom
        fab_save_note.setLayoutParams(parameter)
    }*/


    /**fun save_file(view: View, db: SQLiteDatabase){
        db.select("Notes", "id", "note").exec {
            editTextNota.setText(db)
        }
    }
     */

    // Function for saving the note
    fun save_file(view: View){
        try {
            //val file = OutputStreamWriter(openFileOutput("notas.txt", Activity.MODE_PRIVATE))
            val file = OutputStreamWriter(openFileOutput(note_name, Activity.MODE_PRIVATE))
            file.write(editTextNota.text.toString())
            file.flush()
            file.close()
        } catch (e: IOException){
        }
        toast("Nota guardada")
    }

    fun cancel(view: View){
        startActivity<ScheduleActivity>()
    }

}