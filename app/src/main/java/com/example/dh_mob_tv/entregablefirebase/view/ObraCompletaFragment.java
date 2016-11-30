package com.example.dh_mob_tv.entregablefirebase.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dh_mob_tv.entregablefirebase.R;
import com.example.dh_mob_tv.entregablefirebase.controller.ArtistController;
import com.example.dh_mob_tv.entregablefirebase.model.Paint;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class ObraCompletaFragment extends Fragment {

    private Paint paint;

    public ObraCompletaFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewADevolver = inflater.inflate(R.layout.layout_obra_completa, container, false);

        Bundle bundle = getArguments();
        paint = (Paint) bundle.getSerializable("pintura");

        ImageView imageViewObraCompleta = (ImageView) viewADevolver.findViewById(R.id.image_fragment_pantallaCompleta);
        TextView textViewObraCompleta = (TextView) viewADevolver.findViewById(R.id.titulo_fragment_pantallaCompleta);

        ArtistController artistController = new ArtistController();
        artistController.setImageFirebaseController(paint.getImage(), imageViewObraCompleta, getContext());

        textViewObraCompleta.setText(paint.getName());

        return viewADevolver;
    }
}
