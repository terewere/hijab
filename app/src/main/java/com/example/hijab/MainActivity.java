package com.example.hijab;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.hijab.db.HijabDatasource;
import com.example.hijab.entity.Hijab;
import com.example.hijab.viewmodel.HijabViewmodel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HijabDatasource data;
    public static final String TAG = "hijab";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HijabViewmodel hijabViewmodel = ViewModelProviders
                .of(this, new ViewModelProvider.AndroidViewModelFactory((Application) this.getApplicationContext())).get(HijabViewmodel.class);




        recyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        

        hijabViewmodel.findAll().observe(this, new Observer<List<Hijab>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(List<Hijab> hijabs) {


                // specify an adapter (see also next example)
                mAdapter = new HijabListAdapter(hijabs);
                recyclerView.setAdapter(mAdapter);
                hijabs.forEach(hijab -> Log.i(TAG, "onChanged: " + hijab.getName()));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

//        data.open();

    }

    @Override
    protected void onStop() {
        super.onStop();

        data.close();
    }

    public void createHijabs() {
        Hijab hijab = new Hijab("First Hijab", "Abaya");

        data.insert(hijab);

        hijab = new Hijab("Second Hijab", "Veil");
        data.insert(hijab);

    }


}


