package com.example.dh_mob_tv.entregablefirebase.DAO;

import android.os.AsyncTask;

import com.example.dh_mob_tv.entregablefirebase.model.Artist;
import com.example.dh_mob_tv.entregablefirebase.util.ResultListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {

    public ArtistDAO() {
    }

    public void obtenerListArtistDeFirebase(ResultListener<List<Artist>> resultListener){

        LeerFirebaseDatabaseAsync leerFirebaseDatabaseAsync = new LeerFirebaseDatabaseAsync(resultListener);
        leerFirebaseDatabaseAsync.execute();

    }


   private class LeerFirebaseDatabaseAsync extends AsyncTask<String, Void, List<Artist>>{

        private ResultListener<List<Artist>> resultListener;
        private List<Artist> listADevolver;

        public LeerFirebaseDatabaseAsync(ResultListener<List<Artist>> resultListener) {
            this.resultListener = resultListener;
            this.listADevolver = new ArrayList<>();
        }

        @Override
        protected List<Artist> doInBackground(String... strings) {

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

            try{

                databaseReference.child("artists").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()){
                            listADevolver.add(artistSnapshot.getValue(Artist.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {

                return listADevolver;

            }



        }

        @Override
        protected void onPostExecute(List<Artist> artists) {
            this.resultListener.finish(artists);
        }


    }
}
