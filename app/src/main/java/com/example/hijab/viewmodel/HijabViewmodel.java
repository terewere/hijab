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

public class HijabViewmodel extends AndroidViewModel {


    private MutableLiveData<List<Hijab>> all = new MutableLiveData<>();

    public HijabViewmodel(Application application) {
        super(application);

        HijabRepo repo = new HijabRepo(application.getApplicationContext());
       all.setValue(repo.findAll() );
    }



    public LiveData<List<Hijab>> findAll() {

       return all;
    }
}
