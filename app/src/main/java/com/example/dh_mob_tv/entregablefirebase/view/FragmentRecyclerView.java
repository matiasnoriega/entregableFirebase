package com.example.dh_mob_tv.entregablefirebase.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dh_mob_tv.entregablefirebase.R;
import com.example.dh_mob_tv.entregablefirebase.controller.ArtistController;
import com.example.dh_mob_tv.entregablefirebase.model.Artist;
import com.example.dh_mob_tv.entregablefirebase.model.Paint;
import com.example.dh_mob_tv.entregablefirebase.model.RecyclerViewAdapter;
import com.example.dh_mob_tv.entregablefirebase.util.ResultListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class FragmentRecyclerView extends Fragment{

    private List<Paint> listAMostrar;
    private RecyclerView recyclerView;
    private String artista;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listAMostrar = new ArrayList<>();
        Bundle unBundle = getArguments();
        this.artista = unBundle.getString("artista");

        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_main);
        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), listAMostrar, new Listener());

        ArtistController artistController = new ArtistController();
        artistController.obtenerArtistaDelDAO(new ResultListener<Artist>() {
            @Override
            public void finish(Artist resultado) {
                listAMostrar.clear();
                listAMostrar.addAll(resultado.getPaintings());
                recyclerViewAdapter.notifyDataSetChanged();

            }
        }, getContext());

        recyclerView.setAdapter(recyclerViewAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), GridLayoutManager.DEFAULT_SPAN_COUNT);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        return view;
    }

    public static FragmentRecyclerView creadorDeRecyclerViewFragment(String artista){

        FragmentRecyclerView recyclerViewFragment = new FragmentRecyclerView();
        Bundle bundle = new Bundle();
        bundle.putString("artista", artista);
        recyclerViewFragment.setArguments(bundle);

        return recyclerViewFragment;

    }

    public class Listener implements View.OnClickListener{


        @Override
        public void onClick(View view) {
            ObraCompletaFragment obraCompletaFragment = new ObraCompletaFragment();

            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_main, obraCompletaFragment);
            fragmentTransaction.commit();

        }
    }
}
