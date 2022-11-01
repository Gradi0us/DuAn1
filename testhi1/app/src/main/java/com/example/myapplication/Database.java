package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.time.temporal.ValueRange;

public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context, "sinhvien.db", null , 1);

    }
    public static final String  TABLE_NAME = "sinhvien";
    public static final String  COLUMN_NAME = "name";
    public static final String  COLUMN_AGE = "tuoi";
    public static final String  COLUMN_MOTA = "mota";



    @Override
    public void onCreate(SQLiteDatabase db) {
String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COLUMN_NAME+" NVARCHAR(50) PRIMARY KEY, "+COLUMN_AGE+"  INTEGER,"+COLUMN_MOTA+"  NVARCHAR(50))";
    db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long themsinhvien(Sinhvien sinhvien){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,sinhvien.getName());
        values.put(COLUMN_AGE,sinhvien.getDate());
        values.put(COLUMN_MOTA,sinhvien.get);

    }
}
