package com.example.hijab.repo;

import androidx.lifecycle.LiveData;

import com.example.hijab.dao.HijabDao;
import com.example.hijab.entity.Hijab;
import com.example.hijab.utils.AppExecutors;

import java.util.List;

import javax.inject.Inject;

public class HijabRepo {


    private HijabDao hijabDao;
    private AppExecutors executors;

    @Inject
    HijabRepo(HijabDao hijabDao, AppExecutors executors) {
        this.hijabDao = hijabDao;
        this.executors = executors;
    }

    public LiveData<List<Hijab>>getHijabs(){

        return  hijabDao.getHijabs();
    }

    public void insert(Hijab hijab){

        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                hijabDao.insert(hijab);
            }
        });

    }



}
