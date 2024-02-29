package com.example.examenfinal_victorhernandez_pmdm

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Clase DatabaseHelper
class DatabaseHelper(context: ThirdActivity) : SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE = "JuegosComprados.db"
        private const val TABLA_VIDEOJUEGOS = "tabla"
        private const val KEY_ID = "_id"
        private const val COLUMN_NOMBRE = "nombreVideojuego"
        private const val COLUMN_VALORACION = "valoracionVideojuego"
        private const val COLUMN_EMPRESA = "empresaDesarrolladora"
        private const val COLUMN_ANIO = "anioLanzamiento"

    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLA_VIDEOJUEGOS ($KEY_ID INTEGER PRIMARY KEY" +
                "$COLUMN_NOMBRE TEXT, $COLUMN_VALORACION NUMBER, $COLUMN_EMPRESA TEXT, $COLUMN_ANIO INTEGER)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_VIDEOJUEGOS")
        onCreate(db)
    }

    fun escribir(videojuego: Videojuego): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(KEY_ID, videojuego.getId())
            put(COLUMN_NOMBRE, videojuego.getNombre())
            put(COLUMN_VALORACION, videojuego.getValoracion())
            put(COLUMN_EMPRESA, videojuego.getEmpresaDesarrolladora())
            put(COLUMN_ANIO, videojuego.getAnioLanzamiento())
        }
        val id = db.insert(TABLA_VIDEOJUEGOS, null, values)
        db.close()
        return id
    }


    @SuppressLint("Range")
    fun lectura(): ArrayList<Videojuego> {
        val lectura = ArrayList<Videojuego>()
        val selectQuery = "SELECT * FROM $TABLA_VIDEOJUEGOS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val valoracion = cursor.getDouble(cursor.getColumnIndex(COLUMN_VALORACION))
                val empresa = cursor.getString(cursor.getColumnIndex(COLUMN_EMPRESA))
                val anio = cursor.getInt(cursor.getColumnIndex(COLUMN_ANIO))
                lectura.add(Videojuego(id, nombre, valoracion, empresa, anio))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lectura
    }
}