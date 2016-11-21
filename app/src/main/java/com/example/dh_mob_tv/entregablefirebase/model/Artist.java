package com.example.dh_mob_tv.entregablefirebase.model;

import java.util.List;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class Artist {

    private String name;
    private List<Paint> paintings;

    public Artist() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Paint> getPaintings() {
        return paintings;
    }

    public void setPaintings(List<Paint> paintings) {
        this.paintings = paintings;
    }
}
