package com.example.lab4.Clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4.Jugador;
import com.example.lab4.R;

public class ListaHitosAdapter extends RecyclerView.Adapter<ListaHitosAdapter.HitoViewHolder> {

    private Jugador[] listaJugador;
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Jugador[] getListaJugador() {
        return listaJugador;
    }

    public void setListaJugador(Jugador[] listaJugador) {
        this.listaJugador = listaJugador;
    }

    public class HitoViewHolder extends RecyclerView.ViewHolder {
        Jugador jugador;

        public HitoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public HitoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_hitos, parent, false);
        return new HitoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HitoViewHolder holder, int position) {

        Jugador jugador = getListaJugador()[position];
        holder.jugador = jugador;
        TextView textView = holder.itemView.findViewById(R.id.textViewHitos);
        textView.setText(jugador.getHitoJugador());

    }

    @Override
    public int getItemCount() {
        return getListaJugador().length;
    }

}
