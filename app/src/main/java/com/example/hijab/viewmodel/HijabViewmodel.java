package com.example.hijab.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.hijab.entity.Hijab;
import com.example.hijab.repo.HijabRepo;

import java.util.List;

import javax.inject.Inject;

public class HijabViewmodel extends ViewModel {

    private LiveData<List<Hijab>> hijabs;
    private HijabRepo hijabRepo;

    @Inject
    HijabViewmodel(HijabRepo hijabRepo) {

        this.hijabRepo = hijabRepo;
        hijabs = hijabRepo.getHijabs();


    }




    public LiveData<List<Hijab>> getHijabs() {

        return hijabs;
    }

    public void insert(Hijab hijab) {

        hijabRepo.insert(hijab);

    }




}
