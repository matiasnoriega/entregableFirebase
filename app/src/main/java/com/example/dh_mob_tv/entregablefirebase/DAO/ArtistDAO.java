package com.example.dh_mob_tv.entregablefirebase.DAO;

import android.net.Uri;

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

    public void obtenerListaArtistasDeFirebase(final ResultListener<List<Artist>> resultListener) {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://entregablefirebase-3ed06.firebaseio.com/");
        databaseReference.child("artists").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Artist> lista = new ArrayList<Artist>();
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                    Artist artist = artistSnapshot.getValue(Artist.class);
                    lista.add(artist);
                }
                resultListener.finish(lista);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
