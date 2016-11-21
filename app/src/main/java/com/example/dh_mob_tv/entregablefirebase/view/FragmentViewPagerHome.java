package com.example.dh_mob_tv.entregablefirebase.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dh_mob_tv.entregablefirebase.R;

public class FragmentViewPagerHome extends Fragment {

    public FragmentViewPagerHome(){
        //Constructor default
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ViewPager pager = (ViewPager) view.findViewById(R.id.viewPager_home);
        TabLayout tabLayout=(TabLayout)view.findViewById(R.id.tabMenu_home);

        pager.setAdapter(new AdapterViewPagerHome(getFragmentManager()));
        tabLayout.setupWithViewPager(pager);

        return view;
    }
}
