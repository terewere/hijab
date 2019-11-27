package com.example.hijab.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hijab.entity.Hijab;

import java.util.ArrayList;
import java.util.List;

public class HijabDatasource {

    private static final String[] ALL_COLOMNS = {
            HijabSQLHelper.COLUMN_NAME,
            HijabSQLHelper.COLUMN_IMG,
            HijabSQLHelper.COLUMN_ID

    };
    private SQLiteOpenHelper hijabSQLHelper;
    private SQLiteDatabase database;
    public static final String TAG = "hijab";

    public HijabDatasource(Context context) {

         hijabSQLHelper = new HijabSQLHelper(context);
    }

    public void open() {

        database = hijabSQLHelper.getWritableDatabase();
        Log.i(TAG, "DB open: ");
    }


    public void close() {

        hijabSQLHelper.close();

        Log.i(TAG, " DB close:");
    }


    public Hijab insert(Hijab hijab) {

        ContentValues values = new ContentValues();
        values.put(HijabSQLHelper.COLUMN_NAME, hijab.getName());
        values.put(HijabSQLHelper.COLUMN_IMG, hijab.getImage());

        long insert = database.insert(HijabSQLHelper.TABLE_HIJAB, null, values);
        hijab.setId(insert);

        Log.i(TAG, "insert: " + insert);


        return hijab;
    }

    public List<Hijab> findAll() {

        ArrayList<Hijab> hijabs = new ArrayList<>();

        Cursor query = database.query(HijabSQLHelper.TABLE_HIJAB,ALL_COLOMNS, null, null, null, null, null);

        Log.i(TAG, "findAll counts: " + query.getCount());

        if (query.getCount() > 0) {

            while (query.moveToNext()){

               Hijab hijab = new Hijab();
               hijab.setId(query.getLong(query.getColumnIndex(HijabSQLHelper.COLUMN_ID)));
               hijab.setName(query.getString(query.getColumnIndex(HijabSQLHelper.COLUMN_NAME)));
               hijab.setImage(query.getString(query.getColumnIndex(HijabSQLHelper.COLUMN_IMG)));

               hijabs.add(hijab);

            }


        query.close();
        }


        return hijabs;
    }





}
