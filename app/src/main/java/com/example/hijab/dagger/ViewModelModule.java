package com.example.hijab.dagger;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.hijab.viewmodel.HijabViewModelFactory;
import com.example.hijab.viewmodel.HijabViewmodel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HijabViewmodel.class)
    abstract ViewModel bindhijabsViewModel( HijabViewmodel hijabViewmodel);



    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory( HijabViewModelFactory factory);
}
