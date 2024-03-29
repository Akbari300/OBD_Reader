package com.github.pires.obd.reader.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME1 = "register.dp";
    public static final String TABLE_NAME1 = "register";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FirstName";
    public static final String COL_3 = "LastName";
    public static final String COL_4 = "UserName";
    public static final String COL_5 = "Password";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME1, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " +TABLE_NAME1+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, UserName TEXT, Password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int k) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);

    }
}
