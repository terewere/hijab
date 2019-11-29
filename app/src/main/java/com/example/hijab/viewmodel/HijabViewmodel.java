package com.example.hijab.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hijab.db.HijabDatasource;
import com.example.hijab.entity.Hijab;
import com.example.hijab.repo.HijabRepo;

import java.util.List;

import javax.inject.Inject;

public class HijabViewmodel extends ViewModel {

    private LiveData<List<Hijab>> hijabs;

    @Inject
    HijabViewmodel(HijabRepo hijabRepo) {


        hijabs = hijabRepo.getHijabs();


    }




    public LiveData<List<Hijab>> getHijabs() {

        return hijabs;
    }


}
