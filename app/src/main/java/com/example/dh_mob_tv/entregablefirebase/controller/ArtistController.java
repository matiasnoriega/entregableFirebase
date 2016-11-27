package com.example.dh_mob_tv.entregablefirebase.controller;

import com.example.dh_mob_tv.entregablefirebase.DAO.ArtistDAO;
import com.example.dh_mob_tv.entregablefirebase.model.Artist;
import com.example.dh_mob_tv.entregablefirebase.util.ResultListener;

import java.util.List;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class ArtistController {

    public ArtistController() {
    }

    public void leerFirebaseDelDAO(final ResultListener<List<Artist>> resultListener){
        ArtistDAO artistDAO = new ArtistDAO();
        artistDAO.obtenerListArtistDeFirebase(new ResultListener<List<Artist>>() {
            @Override
            public void finish(List<Artist> resultado) {
                resultListener.finish(resultado);
            }
        });

    }
}
