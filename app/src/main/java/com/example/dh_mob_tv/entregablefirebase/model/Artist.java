package com.example.dh_mob_tv.entregablefirebase.model;

import java.util.List;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class Artist {

    private String name;
    private List<Paint> paints;

    public Artist() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Paint> getPaints() {
        return paints;
    }

    public void setPaints(List<Paint> paintings) {
        this.paints = paintings;
    }
}
