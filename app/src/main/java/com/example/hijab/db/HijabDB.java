package com.example.hijab.db;

import android.app.Application;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.hijab.dao.HijabDao;
import com.example.hijab.entity.Hijab;

import javax.inject.Inject;
import javax.inject.Singleton;


@Database(entities = { Hijab.class }, version = 2)
public abstract class HijabDB extends RoomDatabase {

    private static final String DB_NAME = "hijabDatabase.db";
    private static volatile HijabDB instance;


    public static HijabDB create(final Application context) {
        return Room.databaseBuilder(
                context,
                HijabDB.class,
                DB_NAME)
                .addMigrations(MIGRATION_1_2)
//                .fallbackToDestructiveMigration() clear data
                .build();
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    };


    public abstract HijabDao getHijabDao();
}

