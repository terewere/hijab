package com.example.hijab.dagger;


import com.example.hijab.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = {})
    abstract MainActivity contributeMainActivity();
}

