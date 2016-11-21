package com.example.dh_mob_tv.entregablefirebase.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

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
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
