package com.example.dh_mob_tv.entregablefirebase.DAO;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dh_mob_tv.entregablefirebase.R;
import com.example.dh_mob_tv.entregablefirebase.model.Artist;
import com.example.dh_mob_tv.entregablefirebase.util.ResultListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {

    private ImageView imageView;
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
    public void subirImagenFirebaseDAO(final ImageView imageView, final Context context) throws IOException{

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference imagesRef = storageRef.child("fotosvisitantes/foto.jpg");


        // Get the data from an ImageView as bytes

        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(imageView.getDrawingCache());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = imagesRef.putBytes(data);


        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show();
                downloadImage(context, imageView);
            }
        });
    }

    public void downloadImage(final Context context, final ImageView imageView){


        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference imagesRef = storageRef.child("fotosvisitantes/foto.jpg");

        try {

            final File localFile = File.createTempFile("images", "jpg");
            imagesRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                    imageView.setImageBitmap(bitmap);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
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
