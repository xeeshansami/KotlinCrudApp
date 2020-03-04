package com.paxees.kotlinlearner

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NAME TEXT,NUMBER TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun insertData(name: String, number: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, name)
        contentValues.put(COL_3, number)
        db.insert(TABLE_NAME, null, contentValues)
    }

    fun deleteDate(id: String): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "ID = ?", arrayOf(id))
    }

    fun updateData(id: String, name: String, number: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, id)
        contentValues.put(COL_2, name)
        contentValues.put(COL_3, number)
        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(id))
        return true
    }

    val allData: Cursor
        get() {
            val db = this.writableDatabase
            return db.rawQuery("SELECT  * FROM " + TABLE_NAME, null)
        }

    companion object {
        val DATABASE_NAME = "kotlinLearner_DB.db"
        val TABLE_NAME = "kotlinLearner_TBL"
        val COL_1 = "ID"
        val COL_2 = "NAME"
        val COL_3 = "NUMBER"
    }

}