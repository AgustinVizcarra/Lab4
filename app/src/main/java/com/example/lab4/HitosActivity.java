package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lab4.Clases.ListaHitosAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HitosActivity extends AppCompatActivity {

    ListaHitosAdapter adapter;
    FirebaseDatabase firebaseDatabase;
    ArrayList<Jugador> listaJugadores = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitos);
        getSupportActionBar().setTitle("Hitos");

        firebaseDatabase = FirebaseDatabase.getInstance();

        firebaseDatabase.getReference().child("jugador").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot ds : snapshot.getChildren()) {

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        adapter = new ListaHitosAdapter();
//        adapter.setListaJugador(empleadoDto.getLista());
//        adapter.setContext(HitosActivity.this);
//
//        RecyclerView recyclerView = findViewById(R.id.recyclerView_hitos);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(HitosActivity.this));
    }


}