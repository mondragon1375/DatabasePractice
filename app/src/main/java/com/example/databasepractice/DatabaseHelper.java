package com.example.databasepractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "student.db";    // Name of the Database
    public static final String TABLE_NAME = "student_table";    // Name of the Table storing the data
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";          // This is the name of each individual Column
    public static final String COL_3 = "SURNAME";       // Each are label to what they are storing
    public static final String COL_4 = "GRADE";

    public DatabaseHelper(Context context) {
        // Whenever this constructor is called the database and table is created
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // This will create the table for the database
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, SURNAME TEXT, GRADE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String surname, String grade){
        // This method will allow to data to be entered to the database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contetValues = new ContentValues();
        contetValues.put(COL_2, name);
        contetValues.put(COL_3, surname);
        contetValues.put(COL_4, grade);
        long result = db.insert(TABLE_NAME, null, contetValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
