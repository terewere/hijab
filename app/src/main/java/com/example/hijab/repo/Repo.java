//package com.example.hijab.repo;
//
//import android.content.Context;
//
//import androidx.lifecycle.LiveData;
//
//import com.example.hijab.db.HijabDB;
//import com.example.hijab.entity.Hijab;
//
//import java.util.List;
//
//
//public class Repo {
//
//    private static volatile Repo instance;
//    private static Context context;
//    public static synchronized Repo getInstance(Context context) {
//        Repo.context = context;
//        if (instance == null) {
//            instance = new Repo() {
//            };
//        }
//        return instance;
//    }
//
//
//    public LiveData<List<Hijab>> findAll(){
//
//        return  HijabDB.getInstance(context).getHijabDao().getHijabs();
//
////        return  data.findAll();
//    }
//
//    public void insertData(Hijab hijab) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                HijabDB.getInstance(context).getHijabDao().insert(hijab);
//            }
//        }).start();
//
//    }
//}
