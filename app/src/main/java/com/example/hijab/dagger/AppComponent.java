package com.example.hijab.dagger;

import android.app.Application;

import com.example.hijab.App;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class, //use has support
        AppModule.class,
        MainActivityModule.class

        }
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

//        @BindsInstance
//        fun info(url: String): Builder

        AppComponent build();
    }

    void inject( App app);
}