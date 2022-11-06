package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.lab4.Adapters.ListaHitosAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.EventListener;

public class HitosActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    ArrayList<Jugador> listaJugadores;
    ListaHitosAdapter adapter;
    TextView nohitos;
    ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitos);
        getSupportActionBar().setTitle("Hitos");

        RecyclerView recyclerView = findViewById(R.id.recyclerView_hitos);
        databaseReference = FirebaseDatabase.getInstance().getReference("Jugador");
        recyclerView.setLayoutManager(new LinearLayoutManager(HitosActivity.this));

        listaJugadores = new ArrayList<>();
        adapter = new ListaHitosAdapter(listaJugadores, HitosActivity.this);
        recyclerView.setAdapter(adapter);

        nohitos = findViewById(R.id.text_noregistrohitos);

        valueEventListener = databaseReference.addValueEventListener(new listener());

    }

    @Override
    protected void onPause() {
        super.onPause();
        databaseReference = FirebaseDatabase.getInstance().getReference("Jugador");
        databaseReference.removeEventListener(valueEventListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        valueEventListener = databaseReference.addValueEventListener(new listener());
    }

    class listener implements ValueEventListener {

        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            if (snapshot.exists()) { //Nodo referente existe
                listaJugadores.clear();

                for (DataSnapshot ds : snapshot.getChildren()) {
                    Jugador jugador = ds.getValue(Jugador.class);
                    listaJugadores.add(jugador);
                }


                if (listaJugadores.size() == 0) {
                    nohitos.setVisibility(nohitos.VISIBLE);
                } else {
                    nohitos.setVisibility(nohitos.INVISIBLE);
                }
                adapter.notifyDataSetChanged();
            } else {
                nohitos.setVisibility(nohitos.VISIBLE);
                listaJugadores.clear();
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Log.e("msg", "Error onCancelled", error.toException());
        }
    }
}