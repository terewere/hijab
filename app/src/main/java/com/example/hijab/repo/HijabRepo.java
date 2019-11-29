package com.example.hijab.repo;

import androidx.lifecycle.LiveData;

import com.example.hijab.dao.HijabDao;
import com.example.hijab.entity.Hijab;

import java.util.List;

import javax.inject.Inject;

public class HijabRepo {


    private HijabDao hijabDao;

    @Inject
    HijabRepo(HijabDao hijabDao) {
        this.hijabDao = hijabDao;
    }

    public LiveData<List<Hijab>>getHijabs(){

        return  hijabDao.getHijabs();
    }



}
