package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInOptions gso;

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

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient =GoogleSignIn.getClient(this,gso);


       Button botonSalir = findViewById(R.id.butonlogouat);
       botonSalir.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               FirebaseAuth.getInstance().signOut();

               mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                   @Override
                   public void onComplete(@NonNull Task<Void> task) {
                       Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                       startActivity(intent);
                       MainActivity.this.finish();

                   }
               });

           }
       });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumainactivity,menu);
        return  true;

    }
}