package com.example.netlinesystems;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Inicio_Activity extends AppCompatActivity {

    //private ListView lvMenu
    private ImageButton btnServivios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_);

        btnServivios = findViewById(R.id.ibServicio);

        //lvMenu = findViewById(R.id.lvMenuInicio);

        /*String[] OpMenu = new String[5];
        OpMenu[0]="Servicios";
        OpMenu[1]="Dimensionamientos";
        OpMenu[2]="Almacen";
        OpMenu[3]="Equipos Clientes";
        OpMenu[4]="Notas";

        ArrayAdapter adapMenu = new ArrayAdapter(Inicio_Activity.this, android.R.layout.simple_list_item_1, OpMenu);

        lvMenu.setAdapter(adapMenu);

        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion = lvMenu.getItemAtPosition(position).toString();
                Toast.makeText(Inicio_Activity.this, "Opcion Elegida " + opcion, Toast.LENGTH_LONG).show();
            }
        });*/


    } //Cierre del oncreate

    //Action-bar Overflow
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opcionescrud, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.itMenu) {
            Intent Inicio = new Intent(Inicio_Activity.this, Inicio_Activity.class);
            startActivity(Inicio);
        } else if (id == R.id.itperfil) {
            Intent Perfil = new Intent(Inicio_Activity.this, Perfil_Activity.class);
            startActivity(Perfil);
        } else if (id == R.id.itSalir) {
            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }

    //Metodo para el boton de servicios
    public void irServicios(View view){
        Intent irServicios = new Intent(Inicio_Activity.this, Servicios_Activity.class);
        startActivity(irServicios);
    }

    public void irDimension(View view){
        Intent irDimension = new Intent(Inicio_Activity.this, Dimensionamiento_Activity.class);
        startActivity(irDimension);
    }

    public void irEquipos(View view){
        Intent irEquipos = new Intent(Inicio_Activity.this, Equipos_Activity.class);
        startActivity(irEquipos);
    }

    public void irNotas(View view){
        Intent irNotas = new Intent(Inicio_Activity.this, Notas_Activity.class);
        startActivity(irNotas);
    }

    public void irAlmacen(View view){
        Intent irAlmacen = new Intent(Inicio_Activity.this, Almacen_Activity.class);
        startActivity(irAlmacen);
    }


} //Cierre de la clase