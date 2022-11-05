package com.example.lab4.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4.Jugador;
import com.example.lab4.R;

import java.util.ArrayList;

public class ListaAlineacionAdapter extends RecyclerView.Adapter<ListaAlineacionAdapter.AlineacionViewHolder> {

    private ArrayList<Jugador> listaJugador;
    private Context context;

    public ListaAlineacionAdapter(ArrayList<Jugador> listajugador, Context context) {
        this.listaJugador = listajugador;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Jugador> getListaJugador() {
        return listaJugador;
    }

    public void setListaJugador(ArrayList<Jugador> listaJugador) {
        this.listaJugador = listaJugador;
    }

    @NonNull
    @Override
    public AlineacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_hitos, parent, false);
        return new ListaAlineacionAdapter.AlineacionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlineacionViewHolder holder, int position) {

        Jugador jugador = getListaJugador().get(position);
        holder.textView.setText("Jugador " + jugador.getNombreJugador() + " " + jugador.getApellidoJugador() + "\n"
                                + "Equipo " + jugador.getNombreEquipo());
        if (position%2 != 0) {
            holder.textView.setBackgroundColor(0xFFC5C5C5);
        }

    }

    @Override
    public int getItemCount() { return getListaJugador().size(); }

    public class AlineacionViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public AlineacionViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textViewHitos);
        }
    }

}
