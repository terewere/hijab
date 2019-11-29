package com.example.hijab.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hijab.entity.Hijab;
import com.example.hijab.repo.HijabRepo;
import com.example.hijab.repo.Repo;

import java.util.List;



public class ViewM extends AndroidViewModel {

    private Context context;

    public ViewM(Application application) {
        super(application);

       context = application.getApplicationContext();
    }



    public LiveData<List<Hijab>> findAll() {

        return Repo.getInstance(context).findAll();
    }

    public void insertData(Hijab hijab) {
        Repo.getInstance(context).insertData(hijab);
    }
}
