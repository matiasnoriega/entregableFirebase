package com.example.dh_mob_tv.entregablefirebase.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dh_mob_tv.entregablefirebase.R;

import java.io.File;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class SubirFotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subir_foto);
    }


    public void chooseImage(View view){
        EasyImage.openChooserWithGallery(SubirFotoActivity.this, "Selecciona una imagen", 666);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                //Some error handling
                Toast.makeText(SubirFotoActivity.this, "Fallo", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                Toast.makeText(SubirFotoActivity.this, "Todo ok", Toast.LENGTH_SHORT).show();

                Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());

                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);
            }
        });
    }
}
