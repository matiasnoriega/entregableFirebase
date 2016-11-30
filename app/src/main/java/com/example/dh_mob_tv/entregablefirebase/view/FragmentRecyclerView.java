package com.example.dh_mob_tv.entregablefirebase.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dh_mob_tv.entregablefirebase.R;
import com.example.dh_mob_tv.entregablefirebase.model.Artist;
import com.example.dh_mob_tv.entregablefirebase.model.Paint;
import com.example.dh_mob_tv.entregablefirebase.model.RecyclerViewAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class FragmentRecyclerView extends Fragment{

    private List<Paint> listAMostrar;
    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        Bundle unBundle = getArguments();
        listAMostrar = new ArrayList<>();
        listAMostrar.addAll((List<Paint>) unBundle.getSerializable("pinturas"));
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_main);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), listAMostrar, new Listener());
        recyclerView.setAdapter(recyclerViewAdapter);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter.notifyDataSetChanged();

        return view;
    }

    public static FragmentRecyclerView creadorDeRecyclerViewFragment(Artist artista){

        FragmentRecyclerView recyclerViewFragment = new FragmentRecyclerView();
        Bundle bundle = new Bundle();
        bundle.putSerializable("pinturas", (Serializable) artista.getPaints());
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
