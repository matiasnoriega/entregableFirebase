package com.example.dh_mob_tv.entregablefirebase.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dh_mob_tv.entregablefirebase.R;
import com.example.dh_mob_tv.entregablefirebase.model.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewObras;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewObras = (RecyclerView) findViewById(R.id.recyclerView);

     }
}
