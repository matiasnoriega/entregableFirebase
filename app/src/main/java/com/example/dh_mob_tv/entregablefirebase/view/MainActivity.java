package com.example.dh_mob_tv.entregablefirebase.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.dh_mob_tv.entregablefirebase.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        FragmentViewPagerHome homeFragment = new FragmentViewPagerHome();
        cargadorDeFragments(homeFragment);


     }

    public void cargadorDeFragments(android.support.v4.app.Fragment unFragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main,unFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {

        FragmentViewPagerHome homeFragment = new FragmentViewPagerHome();
        cargadorDeFragments(homeFragment);
    }



}
