package com.example.dh_mob_tv.entregablefirebase.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class Container {
    @SerializedName("artist")
    private List<Artist> artistList;

    public List<Artist> getArtistList() {
        return artistList;
    }
}
