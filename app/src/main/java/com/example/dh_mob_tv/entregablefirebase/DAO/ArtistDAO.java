package com.example.dh_mob_tv.entregablefirebase.DAO;

import android.content.Context;
import android.os.AsyncTask;

import com.example.dh_mob_tv.entregablefirebase.model.Artist;
import com.example.dh_mob_tv.entregablefirebase.model.Container;
import com.example.dh_mob_tv.entregablefirebase.util.HTTPConnectionManager;
import com.example.dh_mob_tv.entregablefirebase.util.ResultListener;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ArtistDAO {

    public ArtistDAO() {
    }

    public void obtenerArtistDeFirebase(ResultListener<Artist> resultListener, String nombreArtista){

    }

    private class ReadFromJSONFileAsync extends AsyncTask<String, Void, Artist> {

        private Context context;
        private ResultListener<Artist> listenerFromController;
        private String nombreArtista;

        public ReadFromJSONFileAsync(Context context, ResultListener<Artist> listenerFromController, String nombreArtista) {
            this.context = context;
            this.listenerFromController = listenerFromController;
            this.nombreArtista = nombreArtista;
        }

        @Override
        protected Artist doInBackground(String... strings) {

            //TRABAJO PESADO QUE SE HACE EN SEGUNDO PLANO
            Artist artistADevolver = null;

            try {

                //HAGO UN REQUEST HTTP
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                InputStream input = httpConnectionManager.getRequestStream("https://api.myjson.com/bins/1nev4");

                //PARSER DE JSON
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
                Gson gson = new Gson();
                Container container = gson.fromJson(bufferedReader, Container.class);

                for (Artist artist : container.getArtistList()) {
                    if (artist.getName().equals(nombreArtista)) {
                        artistADevolver = artist;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            return artistADevolver;
        }

        @Override
        protected void onPostExecute(Artist artist) {
            listenerFromController.finish(artist);
        }
    }
}
