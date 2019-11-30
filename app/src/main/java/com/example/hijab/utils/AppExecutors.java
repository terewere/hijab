package com.example.hijab.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppExecutors {

    private Executor mDiskIO;
private Executor mNetworkIO;


    @Inject
 public AppExecutors(){
            this.mDiskIO = Executors.newSingleThreadExecutor();
            this.mNetworkIO =  Executors.newFixedThreadPool(3);

    }



    public Executor diskIO() {
     return mDiskIO;
    }


    public Executor networkIO() {
        return mNetworkIO;
    }


    public Executor mMainThread() {
        return mNetworkIO;
    }




        @Singleton
        private class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

            @Override
            public void execute(Runnable runnable) {
                mainThreadHandler.post(runnable);
            }

        }
        }