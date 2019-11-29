package com.example.hijab.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hijab.entity.Hijab;

import java.util.List;

@Dao
public interface HijabDao {

    @Query("SELECT * FROM Hijab")
    LiveData<List<Hijab>> getHijabs();

    @Insert
    void insert(Hijab hijab);
}
