package com.example.hijab.dagger;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.hijab.App;
import com.example.hijab.dao.HijabDao;
import com.example.hijab.db.HijabDB;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module

class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application app )

    {

        return app.getApplicationContext();

    }


    @Singleton
    @Provides
    HijabDB provideDb(Application app) {
        return Room
                .databaseBuilder(app, HijabDB.class, "hijabDatabase.db")
            .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    HijabDao provideUserDao( HijabDB db) {
        return db.getHijabDao();
    }


}
