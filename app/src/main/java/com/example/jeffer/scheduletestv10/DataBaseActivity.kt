package com.example.jeffer.scheduletestv10

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by Jeffer on 12/02/2018.
 */
class DataBaseActivity(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "NotesDB", null, 1){
    companion object {
        private var instance: DataBaseActivity?= null

        @Synchronized
        fun getInstance(ctx: Context): DataBaseActivity {
            if (instance == null) {
                instance = DataBaseActivity(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable("Notes", true,
                "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                "matter" to TEXT,
                "note" to TEXT
        )

        db.insert("Notes",
                    "id" to 1,
                    "matter" to "Catedra_1",
                    "note" to "asdfasdf"
        )

        db.insert("Notes",
                "id" to 2,
                "matter" to "Procesos_1",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 3,
                "matter" to "Ordenamiento_1",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 4,
                "matter" to "Bases_1",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 5,
                "matter" to "Geodesia_1",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 6,
                "matter" to "Avaluos_1",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 7,
                "matter" to "Foto_1",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 8,
                "matter" to "Geodesia_2",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 9,
                "matter" to "Procesos_2",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 10,
                "matter" to "Ordenamiento_2",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 11,
                "matter" to "Bases_2",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 12,
                "matter" to "Avaluos_2",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 13,
                "matter" to "Foto_2",
                "note" to ""
        )

        db.insert("Notes",
                "id" to 14,
                "matter" to "Hombre_1",
                "note" to ""
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }




}