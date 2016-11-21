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
        return this.list.get(position);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    public CharSequence getPageTitle(int position){
        String title = null;
        switch (position){
            case 0:
                title= "Andy";
                break;
            case 1:
                title= "Michelangelo";
                break;
            case 2:
                title= "Keith Haring";
                break;
            case 3:
                title= "Miro";
                break;
            case 4:
                title= "Polac (El Polaco)";
                break;
        }
        return title;
    }
}
