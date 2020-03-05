package com.example.chetansharma.trs2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper3 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Score.db";
    public static final String TABLE_SCORE= "score_table";
    public static final String COL_1 = "score";
    public DatabaseHelper3(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_SCORE + " (score INTEGER )");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);
    }
    public void insertScore(Integer score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, score);

        db.insert(TABLE_SCORE,null ,contentValues);

    }
    public Cursor getScore(SQLiteDatabase database)
    {
        String[] projections={COL_1};
        Cursor cursor = database.query(TABLE_SCORE,projections,null,null,null,null,null);
        return cursor;
    }
}
