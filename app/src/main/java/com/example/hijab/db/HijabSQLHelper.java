package com.example.hijab.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class HijabSQLHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "hijab.db";
    public static final int VERSION = 3;

public static final String TAG = "HIJBA";

    public static final String TABLE_HIJAB ="hijabs";
    public static final String COLUMN_ID = "hijabId";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IMG = "image";

    public static final String TABLE = "CREATE TABLE " + TABLE_HIJAB +
            " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_IMG + " TEXT " +  ")";

    public HijabSQLHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLE);

        Log.i(TAG, "onCreate: db created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS " + TABLE_HIJAB);
       onCreate(sqLiteDatabase);

        Log.i(TAG, "onCreate: db upgraded");
    }
}
