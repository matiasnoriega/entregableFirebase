package com.example.dh_mob_tv.entregablefirebase.model;

import java.io.Serializable;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class Paint implements Serializable {

    private String image;
    private String name;

    public Paint() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
