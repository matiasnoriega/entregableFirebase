package com.example.dh_mob_tv.entregablefirebase.controller;

import android.content.Context;

import com.example.dh_mob_tv.entregablefirebase.DAO.ArtistDAO;
import com.example.dh_mob_tv.entregablefirebase.model.Artist;
import com.example.dh_mob_tv.entregablefirebase.model.Paint;
import com.example.dh_mob_tv.entregablefirebase.util.ResultListener;

import java.util.List;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class ArtistController {

    public ArtistController() {
    }

    public void obtenerArtistaDelDAO(final ResultListener<Artist> resultListener, Context context){

        ArtistDAO artistDAO = new ArtistDAO();
        artistDAO.obtenerArtistDeFirebase(new ResultListener<Artist>() {
            @Override
            public void finish(Artist resultado) {
                resultListener.finish(resultado);
            }
        }, context);

    }
}
