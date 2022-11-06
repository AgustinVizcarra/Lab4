package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Admin extends AppCompatActivity {
    //Inicializamos la instancia de base de datos ni bien arranque el activity
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Jugadores");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    public void Registrar(View view){

        String equipo = ((EditText) findViewById(R.id.editEquipo)).getText().toString();
        String nombreJugador = ((EditText) findViewById(R.id.editNombre)).getText().toString();
        String apellidoJugador = ((EditText) findViewById(R.id.editApellido)).getText().toString();
        String hito = ((EditText) findViewById(R.id.editHito)).getText().toString();
        boolean fieldEquipo = equipo.equalsIgnoreCase("")?true:false;
        boolean fieldNombre = nombreJugador.equalsIgnoreCase("")?true:false;
        boolean fieldApellido = apellidoJugador.equalsIgnoreCase("")?true:false;
        boolean fieldHito = hito.equalsIgnoreCase("")?true:false;
        if(!(fieldApellido&&fieldNombre&&fieldEquipo&&fieldHito)){
            //Quiere decir que todos los campos se encuentran llenos
            //Se crea el objeto persona a enviar
            Jugador jugador = new Jugador(equipo,apellidoJugador,nombreJugador,hito);
            //Se envia el jugador a la base de dato en tiempo real
            databaseReference.setValue(jugador).addOnSuccessListener(aVoid->{
                //Se limpian los campos
                ((EditText) findViewById(R.id.editEquipo)).setText("");
                ((EditText) findViewById(R.id.editNombre)).setText("");
                ((EditText) findViewById(R.id.editApellido)).setText("");
                ((EditText) findViewById(R.id.editHito)).setText("");
                //Se imprime un mensaje de confirmacion especificando que se ha creado el usuario de manera exitosa
                Toast.makeText(this, "El jugador se ha registrado exitosamente!!!!", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(e->{
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            });
        }else{
            //hay algun campo vacio
            if(fieldApellido&&fieldEquipo&&fieldHito&&fieldNombre){
                //Todos los campos se encuentran vacios
                Toast.makeText(this, "Todos los campos se encuentran vacios !!!!", Toast.LENGTH_LONG).show();
            }else{
                if(fieldEquipo){
                    Toast.makeText(this, "El equipo del jugador no puede estar vacío", Toast.LENGTH_LONG).show();
                }
                if(fieldNombre){
                    Toast.makeText(this, "El nombre del jugador no puede estar vacio", Toast.LENGTH_LONG).show();
                }
                if(fieldHito){
                    Toast.makeText(this, "El hito del jugador no puede estar vacio", Toast.LENGTH_LONG).show();
                }
                if(fieldApellido){
                    Toast.makeText(this, "El apellido del jugador no puede estar vacio", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}