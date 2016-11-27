package com.example.dh_mob_tv.entregablefirebase.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dh_mob_tv.entregablefirebase.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.List;

/**
 * Created by dh-mob-tv on 16/11/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter {

    Context context;
    List<Paint> listaDePaints;
    View.OnClickListener listener;

    public RecyclerViewAdapter(Context context, List<Paint> listaDePaints, View.OnClickListener onClickListener) {
        this.context = context;
        this.listaDePaints = listaDePaints;
        this.listener = onClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_celda_pintura, parent, false);
        view.setOnClickListener(listener);
        return new PinturaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Paint pintura = listaDePaints.get(position);
        PinturaViewHolder pinturaViewHolder = (PinturaViewHolder) holder;
        pinturaViewHolder.cargarPintura(pintura);
    }

    @Override
    public int getItemCount() {
        return listaDePaints.size();
    }

    public static class PinturaViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewHolder;

        public PinturaViewHolder(View itemView) {
            super(itemView);
            this.imageViewHolder = (ImageView) itemView.findViewById(R.id.imageViewCelda);
        }

        public void cargarPintura(Paint paint){

            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReferenceFromUrl("gs://entregablefirebase-3ed06.appspot.com");
            StorageReference imagesRef = storageRef.child(paint.getImage());

            try{

                final File localFile = File.createTempFile("images", "jpg");
                imagesRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                        Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                        imageViewHolder.setImageBitmap(bitmap);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });

            }
            catch (Exception e){
                e.printStackTrace();;
            }

        }
    }
}
