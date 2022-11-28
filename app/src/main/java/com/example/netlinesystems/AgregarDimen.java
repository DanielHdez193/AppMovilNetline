package com.example.netlinesystems;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AgregarDimen extends AppCompatActivity {

    Spinner spClientes;
    ArrayList clienteslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_dimen);

        spClientes = findViewById(R.id.spClientes);

        clienteslist = new ArrayList();
        clienteslist.add("01 / Andres Castro");
        clienteslist.add("02 / Juan Lopez");
        clienteslist.add("03 / Jorge Sanchez");

        ArrayAdapter adaptadorClientes = new ArrayAdapter(this, android.R.layout.simple_spinner_item, clienteslist);
        spClientes.setAdapter(adaptadorClientes);
    }

    //Action-bar Overflow
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

    public void agregarMatDim(View view){
        Intent agregarMatDim = new Intent(this, AgregarMaterialDim.class);
        startActivity(agregarMatDim);
    }
}