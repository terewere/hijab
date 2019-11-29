package com.example.hijab.dagger;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.hijab.App;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.HasSupportFragmentInjector;


/**
 * Helper class to automatically inject fragments if they implement [Injectable].
 */
public class AppInjector {
        public static void init( App app) {

        DaggerAppComponent.builder().application(app)
        .build().inject(app);

        app.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                handleActivity(activity);

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });


        }

private static void handleActivity(Activity activity) {
//        if (activity instanceof HasSupportFragmentInjector) {
            AndroidInjection.inject(activity);
//        }

    if (activity instanceof FragmentActivity) {

        ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentCreated(@NonNull FragmentManager fm, @NonNull Fragment f, @Nullable Bundle savedInstanceState) {

               if( f instanceof HasFragmentInjector) {
//                   AndroidSupportInjection.inject(f);
               }
            }
        }, true);
    }




        }
        }
