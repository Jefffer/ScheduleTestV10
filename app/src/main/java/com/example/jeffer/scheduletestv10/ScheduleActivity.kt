package com.example.jeffer.scheduletestv10

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.*
import kotlinx.android.synthetic.main.schedule_view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Jeffer on 31/01/2018.
 */
class ScheduleActivity: AppCompatActivity() {

    var materia: String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_view)
    }

    fun notepadLayout(view: View){
        startActivity<NotepadActivity>("materia" to materia)
    }

    //lateinit var alerta : AlertDialog

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
                 materia = textView11.text.toString()
                 salon = "Aula 305"
                 sede = "Sabio Caldas"
                 docente = "José Noé Poveda Zafra"
             }
        }

        // Procesos Catastrales - Lunes
        when {
            view_id == R.id.textView12 -> {
                materia = textView12.text.toString()
                salon = "Aula 308"
                sede = "Sabio Caldas"
                docente = "René Horacio Torres López"
            }
        }

        // Ordenamiento Territorial - Lunes
        when {
            view_id == R.id.textView13 -> {
                materia = textView13.text.toString()
                salon = "Aula 206"
                sede = "Alejandro Suárez Copete"
                docente = "William Eduardo Alfonso Valencia"
            }
        }

        // Bases de Datos - Martes
        when {
            view_id == R.id.textView14 -> {
                materia = textView14.text.toString()
                salon = "Aula 203"
                sede = "Calle 34"
                docente = "Sandra Yaneth Velazco Florez"
            }
        }

        // Geodesia Fisica - Martes
        when {
            view_id == R.id.textView17 -> {
                materia = textView17.text.toString()
                salon = "Aula 401"
                sede = "Sabio Caldas"
                docente = "Miguel Antonio Avila Angulo"
            }
        }

        // Avaluos Puntuales - Martes
        when {
            view_id == R.id.textView18 -> {
                materia = textView18.text.toString()
                salon = "Aula 302"
                sede = "Sabio Caldas"
                docente = "Edwin Robert Pérez Carvajal"
            }
        }

        // Fotogrametría - Miercoles
        when {
            view_id == R.id.textView20 -> {
                materia = textView20.text.toString()
                salon = "Aula 311"
                sede = "Sabio Caldas"
                docente = "Carlos Leonardo Mendoza"
            }
        }

        // Geodesia Fisica - Miercoles
        when {
            view_id == R.id.textView23 -> {
                materia = textView23.text.toString()
                salon = "Aula 401"
                sede = "Sabio Caldas"
                docente = "Miguel Antonio Avila Angulo"
            }
        }

        // Procesos Catastrales - Miercoles
        when {
            view_id == R.id.textView24 -> {
                materia = textView24.text.toString()
                salon = "Aula 202"
                sede = "Sabio Caldas"
                docente = "René Horacio Torres López"
            }
        }

        // Ordenamiento Territorial - Miercoles
        when {
            view_id == R.id.textView25 -> {
                materia = textView25.text.toString()
                salon = "Aula 203"
                sede = "Alejandro Suárez Copete"
                docente = "William Eduardo Alfonso Valencia"
            }
        }

        // Bases de datos espaciales - Jueves
        when {
            view_id == R.id.textView26 -> {
                materia = textView26.text.toString()
                salon = "Sala de Informática 701"
                sede = "Sabio Caldas"
                docente = "Sandra Yaneth Velazco Florez"
            }
        }

        // Avaluos puntuales - Jueves
        when {
            view_id == R.id.textView30 -> {
                materia = textView30.text.toString()
                salon = "Aula 206"
                sede = "Sabio Caldas"
                docente = "Edwin Robert Pérez Carvajal"
            }
        }

        // Fotogrametria - Viernes
        when {
            view_id == R.id.textView32 -> {
                materia = textView32.text.toString()
                salon = "Lab. Fotogrametría Digital"
                sede = "Sabio Caldas"
                docente = "Carlos Leonardo Mendoza"
            }
        }

        // Avaluos puntuales - Jueves
        when {
            view_id == R.id.textView33 -> {
                materia = textView33.text.toString()
                salon = "Aula 404"
                sede = "Sabio Caldas"
                docente = "Luz Helena Camargo Casallas"
            }
        }

        // Alert con la descripción de cada espacio academico
        var alerta = alert{
            title = materia!!
            positiveButton("NOTAS"){
                toast("Agregar Notas")
                notepadLayout(view)
            }
            negativeButton("VOLVER"){
                toast("Tu Horario")
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
                    themedButton("Agregar Notas", theme = R.style.AppTheme_Button) {
                        onClick {
                            notepadLayout(view)

                        }
                    }.lparams(width = wrapContent)

                }
            }
        }.show()
    }
}