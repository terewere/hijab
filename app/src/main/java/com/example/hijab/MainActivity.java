package com.example.hijab;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hijab.db.HijabDatasource;
import com.example.hijab.entity.Hijab;
import com.example.hijab.viewmodel.HijabViewmodel;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector  {


    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    public HijabViewmodel hijabViewmodel;

    @Inject
   public ViewModelProvider.Factory viewModelFactory;
    private HijabDatasource data;
    public static final String TAG = "hijab";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;



    @Inject
    public Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hijabViewmodel = ViewModelProviders.of(this, viewModelFactory)
                .get(HijabViewmodel.class);

            mRecyclerView = findViewById(R.id.hijab_list_view);

            mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);


            Hijab hijab = new Hijab("Another Hijab", "Another Abaya");
            hijabViewmodel.insert(hijab);

        hijabViewmodel.getHijabs().observe(this, new Observer<List<Hijab>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(List<Hijab> hijabs) {


                mAdapter = new HijabListAdapter(hijabs);
                mRecyclerView.setAdapter(mAdapter);
                hijabs.forEach(hijab -> Log.i(TAG, "onChanged: " + hijab.getName()));
            }
        });


        Log.i(TAG, "onCreate: " + calculator.getName());




    }



    public void createHijabs() {
        Hijab hijab = new Hijab("First Hijab", "Abaya");

        data.insert(hijab);

        hijab = new Hijab("Second Hijab", "Veil");
        data.insert(hijab);

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }


}


