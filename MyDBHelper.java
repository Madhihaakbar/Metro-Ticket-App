package com.example.crescentdbapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {

    public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE employee(id INTEGER PRIMARY KEY, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS employee");
        onCreate(db);
    }

    public void insertToTable(int id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO employee VALUES(" + id + ", '" + name + "')");
    }

    public String viewData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM employee", null);
        StringBuilder data = new StringBuilder();
        while (cursor.moveToNext()) {
            data.append("ID: ").append(cursor.getInt(0)).append(", Name: ").append(cursor.getString(1)).append("\n");
        }
        cursor.close();
        return data.toString();
    }
}
