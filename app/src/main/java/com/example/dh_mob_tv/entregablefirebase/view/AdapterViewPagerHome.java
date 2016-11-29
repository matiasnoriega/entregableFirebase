package com.example.dh_mob_tv.entregablefirebase.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.dh_mob_tv.entregablefirebase.controller.ArtistController;
import com.example.dh_mob_tv.entregablefirebase.model.Artist;
import com.example.dh_mob_tv.entregablefirebase.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class AdapterViewPagerHome extends FragmentStatePagerAdapter {

    List<FragmentRecyclerView> list;
    List<Artist> artistList;

    public AdapterViewPagerHome(FragmentManager fm) {
        super(fm);
        list = new ArrayList<FragmentRecyclerView>();
        artistList = new ArrayList<Artist>();

        ArtistController artistController = new ArtistController();
        artistController.leerFirebaseDelDAO(new ResultListener<List<Artist>>() {
            @Override
            public void finish(List<Artist> resultado) {
                for (Artist artist : resultado){
                    list.add(FragmentRecyclerView.creadorDeRecyclerViewFragment(artist));
                }
                notifyDataSetChanged();
            }
        });


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

    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }
}
