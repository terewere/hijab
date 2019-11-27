package com.example.hijab.repo;

import android.content.Context;

import com.example.hijab.db.HijabDatasource;
import com.example.hijab.entity.Hijab;

import java.util.List;

public class HijabRepo {

    private HijabDatasource data;

    public HijabRepo(Context context) {
        this.data = new HijabDatasource(context);

    }

    public List<Hijab> findAll(){

        data.open();
        return  data.findAll();
    }

}
