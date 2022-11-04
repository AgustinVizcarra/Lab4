package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botonAdmin = findViewById(R.id.button_admin);
        botonAdmin.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Admin.class);
            startActivity(intent);
        });
        Button botonUsuario = findViewById(R.id.button_user);
        botonUsuario.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,UsuarioActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumainactivity,menu);
        return  true;

    }
}