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

        this.recyclerViewObras = (RecyclerView) findViewById(R.id.recyclerView);




     }

    public void cargadorDeFragments(android.support.v4.app.Fragment unFragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main,unFragment);
        fragmentTransaction.commit();
    }
}
