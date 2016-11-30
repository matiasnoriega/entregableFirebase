package com.example.dh_mob_tv.entregablefirebase.DAO;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dh_mob_tv.entregablefirebase.R;
import com.example.dh_mob_tv.entregablefirebase.model.Artist;
import com.example.dh_mob_tv.entregablefirebase.util.ResultListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

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

    public void setImageFirebaseDAO(String path, final ImageView imageView, final Context context){

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        storageRef.child(path).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(context).load(uri).placeholder(R.drawable.momma).into(imageView);
            }
        });
    }
}
