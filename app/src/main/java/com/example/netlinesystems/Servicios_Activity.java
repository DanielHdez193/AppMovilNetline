package com.example.netlinesystems;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Servicios_Activity extends AppCompatActivity {

    //TableLayout tlRegistrosServ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios_);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opcionescrud, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.itMenu) {
            Intent Inicio = new Intent(this, Inicio_Activity.class);
            startActivity(Inicio);
        } else if (id == R.id.itperfil) {
            Intent Perfil = new Intent(this, Perfil_Activity.class);
            startActivity(Perfil);
        } else if (id == R.id.itSalir) {
            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }

    public void agregarServ(View view){
        Intent agregarServ = new Intent(this, AgregarServ.class);
        startActivity(agregarServ);
    }

}