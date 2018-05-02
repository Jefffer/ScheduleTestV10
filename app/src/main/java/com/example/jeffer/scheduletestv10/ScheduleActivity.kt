package com.example.jeffer.scheduletestv10

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.*
import kotlinx.android.synthetic.main.schedule_view.*
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Jeffer on 31/01/2018.
 */
class ScheduleActivity: AppCompatActivity() {

    var materia: String?=null
    var id_vista: Int?=null
    var note_name : String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_view)
    }

    private fun notepadLayout(view: View){
        startActivity<NotepadActivity>("materia" to materia, "id_vista" to id_vista, "note_name" to note_name)
    }

    private fun datesLayout(view: View){
        startActivity<DatesActivity>("materia" to materia, "note_name" to note_name)
    }

    // Método que muestra un alert con la descripción del espacio académico
    fun description(view: View){
        //snackbar(view, "Hi there!")
        var salon : String = ""
        var sede : String = ""
        var docente : String = ""
        var view_id = view.getId()

        // Catedra Francisco Jose - Lunes
        when {
             view_id == R.id.textView11 -> {
                 id_vista = R.id.textView11
                 materia = textView11.text.toString()
                 salon = "Aula 305"
                 sede = "Sabio Caldas"
                 docente = "José Noé Poveda Zafra"
                 note_name = "Catedra_1"
             }
        }

        // Procesos Catastrales - Lunes
        when {
            view_id == R.id.textView12 -> {
                id_vista = R.id.textView12
                materia = textView12.text.toString()
                salon = "Aula 308"
                sede = "Sabio Caldas"
                docente = "René Horacio Torres López"
                note_name = "Procesos_1"
            }
        }

        // Ordenamiento Territorial - Lunes
        when {
            view_id == R.id.textView13 -> {
                id_vista = view_id
                materia = textView13.text.toString()
                salon = "Aula 206"
                sede = "Alejandro Suárez Copete"
                docente = "William Eduardo Alfonso Valencia"
                note_name = "Ordenamiento_1"
            }
        }

        // Bases de Datos - Martes
        when {
            view_id == R.id.textView14 -> {
                id_vista = view_id
                materia = textView14.text.toString()
                salon = "Aula 203"
                sede = "Calle 34"
                docente = "Sandra Yaneth Velazco Florez"
                note_name = "Bases_1"
            }
        }

        // Geodesia Fisica - Martes
        when {
            view_id == R.id.textView17 -> {
                id_vista = view_id
                materia = textView17.text.toString()
                salon = "Aula 401"
                sede = "Sabio Caldas"
                docente = "Miguel Antonio Avila Angulo"
                note_name = "Geodesia_1"
            }
        }

        // Avaluos Puntuales - Martes
        when {
            view_id == R.id.textView18 -> {
                id_vista = view_id
                materia = textView18.text.toString()
                salon = "Aula 302"
                sede = "Sabio Caldas"
                docente = "Edwin Robert Pérez Carvajal"
                note_name = "Avaluos_1"
            }
        }

        // Fotogrametría - Miercoles
        when {
            view_id == R.id.textView20 -> {
                id_vista = view_id
                materia = textView20.text.toString()
                salon = "Aula 311"
                sede = "Sabio Caldas"
                docente = "Carlos Leonardo Mendoza"
                note_name = "Foto_1"
            }
        }

        // Geodesia Fisica - Miercoles
        when {
            view_id == R.id.textView23 -> {
                id_vista = view_id
                materia = textView23.text.toString()
                salon = "Aula 401"
                sede = "Sabio Caldas"
                docente = "Miguel Antonio Avila Angulo"
                note_name = "Geodesia_2"
            }
        }

        // Procesos Catastrales - Miercoles
        when {
            view_id == R.id.textView24 -> {
                id_vista = view_id
                materia = textView24.text.toString()
                salon = "Aula 202"
                sede = "Sabio Caldas"
                docente = "René Horacio Torres López"
                note_name = "Procesos_2"
            }
        }

        // Ordenamiento Territorial - Miercoles
        when {
            view_id == R.id.textView25 -> {
                id_vista = view_id
                materia = textView25.text.toString()
                salon = "Aula 203"
                sede = "Alejandro Suárez Copete"
                docente = "William Eduardo Alfonso Valencia"
                note_name = "Ordenamiento_2"
            }
        }

        // Bases de datos espaciales - Jueves
        when {
            view_id == R.id.textView26 -> {
                id_vista = view_id
                materia = textView26.text.toString()
                salon = "Sala de Informática 701"
                sede = "Sabio Caldas"
                docente = "Sandra Yaneth Velazco Florez"
                note_name = "Bases_2"
            }
        }

        // Avaluos puntuales - Jueves
        when {
            view_id == R.id.textView30 -> {
                id_vista = view_id
                materia = textView30.text.toString()
                salon = "Aula 206"
                sede = "Sabio Caldas"
                docente = "Edwin Robert Pérez Carvajal"
                note_name = "Avaluos_2"
            }
        }

        // Fotogrametria - Viernes
        when {
            view_id == R.id.textView32 -> {
                id_vista = view_id
                materia = textView32.text.toString()
                salon = "Lab. Fotogrametría Digital"
                sede = "Sabio Caldas"
                docente = "Carlos Leonardo Mendoza"
                note_name = "Foto_2"
            }
        }

        // Hombre sociedad y ecologia - Viernes
        when {
            view_id == R.id.textView33 -> {
                id_vista = view_id
                materia = textView33.text.toString()
                salon = "Aula 404"
                sede = "Sabio Caldas"
                docente = "Luz Helena Camargo Casallas"
                note_name = "Hombre_1"
            }
        }

        // Alert con la descripción de cada espacio academico
        alert{
            title = materia!!
            positiveButton("APUNTES"){
                longToast("Recuerda guardar la Nota")
                notepadLayout(view)
            }
            negativeButton("VOLVER"){
                toast("Tu Horario")
            }
            neutralPressed("FECHAS Y NOTAS"){
                toast("Agregar Fechas")
                datesLayout(view)
            }
            customView {
                verticalLayout{
                    padding = dip(16)
                    gravity = Gravity.CENTER
                    lparams(width = wrapContent, height = wrapContent)
                    textView("Salón: " + salon)
                    textView("Sede: "+ sede)
                    textView("Docente: " + docente)
                    textView()
                    /**themedButton("Agregar Notas", theme = R.style.AppTheme_Button) {
                        onClick {
                            notepadLayout(view)
                        }
                    }.lparams(width = wrapContent)
                    */
                }
            }
        }.show()
    }
}