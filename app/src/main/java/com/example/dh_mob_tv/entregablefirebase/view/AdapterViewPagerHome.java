package com.example.dh_mob_tv.entregablefirebase.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class AdapterViewPagerHome extends FragmentStatePagerAdapter {

    List<FragmentRecyclerView> list = new ArrayList<FragmentRecyclerView>();

    public AdapterViewPagerHome(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }
}
