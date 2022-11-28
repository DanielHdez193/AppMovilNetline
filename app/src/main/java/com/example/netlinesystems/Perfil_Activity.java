package com.example.netlinesystems;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class Perfil_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_);
    }

    //Action-bar Overflow
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opcionescrud, menu);
        return true;
    } //Cierre del oncreate

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.itMenu) {
            Intent Inicio = new Intent(Perfil_Activity.this, Inicio_Activity.class);
            startActivity(Inicio);
        } else if (id == R.id.itperfil) {
            Intent Perfil = new Intent(Perfil_Activity.this, Perfil_Activity.class);
            startActivity(Perfil);
        } else if (id == R.id.itSalir) {
            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }

} //Cierre de la clase