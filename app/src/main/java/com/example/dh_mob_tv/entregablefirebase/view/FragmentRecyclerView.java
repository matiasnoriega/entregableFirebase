package com.example.dh_mob_tv.entregablefirebase.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dh_mob_tv.entregablefirebase.R;
import com.example.dh_mob_tv.entregablefirebase.model.Artist;
import com.example.dh_mob_tv.entregablefirebase.model.Paint;

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


        return view;
    }

    public static FragmentRecyclerView creadorDeRecyclerViewFragment(String artista){

        FragmentRecyclerView recyclerViewFragment = new FragmentRecyclerView();
        Bundle bundle = new Bundle();
        bundle.putString("artista", artista);
        recyclerViewFragment.setArguments(bundle);

        return recyclerViewFragment;

    }
}
