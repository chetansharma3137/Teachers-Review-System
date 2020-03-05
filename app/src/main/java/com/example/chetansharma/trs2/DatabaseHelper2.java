package com.example.chetansharma.trs2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Credits.db";
    public static final String TABLE_mahesh = "mahesh_table";
    public static final String TABLE2_ramakrishna = "ramakrishna_table";
    public static final String TABLE3_bhasker = "bhasker_table";
    public static final String TABLE4_srinivas = "srinivas_table";
    public static final String COL_1 = "sk";
    public static final String COL_2 = "tm";
    public static final String COL_3 = "rs";
    public static final String COL_4 = "cm";

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_mahesh + " (sk INTEGER,tm Integer, rs Integer, cm Integer )");
        db.execSQL("create table " + TABLE2_ramakrishna + " (sk INTEGER,tm Integer, rs Integer, cm Integer )");
        db.execSQL("create table " + TABLE3_bhasker + " (sk INTEGER,tm Integer, rs Integer, cm Integer )");
        db.execSQL("create table " + TABLE4_srinivas + " (sk INTEGER,tm Integer, rs Integer, cm Integer )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_mahesh);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_ramakrishna);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE3_bhasker);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE4_srinivas);
        onCreate(db);
    }

    public void insertDataMahesh(Integer sk,Integer tm, Integer rs, Integer cm) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, sk);
        contentValues.put(COL_2, tm);
        contentValues.put(COL_3, rs);
        contentValues.put(COL_4, cm);
        db.insert(TABLE_mahesh,null ,contentValues);

    }
    public void insertDataRama(Integer sk,Integer tm, Integer rs, Integer cm) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, sk);
        contentValues.put(COL_2, tm);
        contentValues.put(COL_3, rs);
        contentValues.put(COL_4, cm);


        db.insert(TABLE2_ramakrishna,null ,contentValues);

    }

    public void insertDataBhasker(Integer sk,Integer tm, Integer rs, Integer cm) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, sk);
        contentValues.put(COL_2, tm);
        contentValues.put(COL_3, rs);
        contentValues.put(COL_4, cm);
        db.insert(TABLE3_bhasker,null ,contentValues);

    }
    public void insertDataSrinivas(Integer sk,Integer tm, Integer rs, Integer cm) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, sk);
        contentValues.put(COL_2, tm);
        contentValues.put(COL_3, rs);
        contentValues.put(COL_4, cm);
        db.insert(TABLE4_srinivas,null ,contentValues);

    }

    public Cursor getInfoMahesh(SQLiteDatabase database)
    {
        String[] projections={COL_1,COL_2,COL_3,COL_4};
        Cursor cursor = database.query(TABLE_mahesh,projections,null,null,null,null,null);
        return cursor;
    }
    public Cursor getInfoRama(SQLiteDatabase database)
    {
        String[] projections={COL_1,COL_2,COL_3,COL_4};
        Cursor cursor = database.query(TABLE2_ramakrishna,projections,null,null,null,null,null);
        return cursor;
    }
    public Cursor getInfoBhasker(SQLiteDatabase database)
    {
        String[] projections={COL_1,COL_2,COL_3,COL_4};
        Cursor cursor = database.query(TABLE3_bhasker,projections,null,null,null,null,null);
        return cursor;
    }
    public Cursor getInfoSrinivas(SQLiteDatabase database)
    {
        String[] projections={COL_1,COL_2,COL_3,COL_4};
        Cursor cursor = database.query(TABLE4_srinivas,projections,null,null,null,null,null);
        return cursor;
    }

}












