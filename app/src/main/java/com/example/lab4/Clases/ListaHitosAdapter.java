package com.example.lab4.Clases;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4.Clases.Hito;
import com.example.lab4.R;

public class ListaHitosAdapter extends RecyclerView.Adapter<ListaHitosAdapter.HitoViewHolder> {

    private Hito[] listaHito;
    private Context context;

    public class HitoViewHolder extends RecyclerView.ViewHolder {
        Hito hito;

        public HitoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public HitoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hitos, parent, false);
        return new HitoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HitoViewHolder holder, int position) {

        Hito hito = listaHito[position];
        holder.hito = hito;
        TextView textView = holder.itemView.findViewById(R.id.textViewHitos);
        textView.setText(hito.getHito());

    }

    @Override
    public int getItemCount() {
        return listaHito.length;
    }

}
