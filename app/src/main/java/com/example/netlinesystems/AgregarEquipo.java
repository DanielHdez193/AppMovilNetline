package com.example.netlinesystems;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.netlinesystems.listaequipo.Equipo;
import com.example.netlinesystems.listaequipo.ListaEquipo;

public class AgregarEquipo extends AppCompatActivity {

    EditText etIdEqui, etMarcaEqui, etModeloEqui, etNSerieEqui, etFallaEqui;
    TextView tvListaEqui;

    ListaEquipo listaEquipos = new ListaEquipo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_equipo);

        etIdEqui = findViewById(R.id.etIdEqui);
        etMarcaEqui = findViewById(R.id.etMarcaEqui);
        etModeloEqui = findViewById(R.id.etModeloEqui);
        etNSerieEqui = findViewById(R.id.etNSerieEqui);
        etFallaEqui = findViewById(R.id.etFallaEqui);
        tvListaEqui = findViewById(R.id.tvListaEqui);

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

    public void agregarEqui(View view){
        Equipo nEquipo = new Equipo();
        nEquipo.setId(listaEquipos.getContador()+1);
        nEquipo.setMarca(etMarcaEqui.getText().toString());
        nEquipo.setModelo(etModeloEqui.getText().toString());
        nEquipo.setNoSerie(etNSerieEqui.getText().toString());
        nEquipo.setFalla(etFallaEqui.getText().toString());
        listaEquipos.agregar(nEquipo);

    }

    public void  modificarEqui(View view){
        listaEquipos.modificar(Integer.parseInt(etIdEqui.getText().toString()), etNSerieEqui.getText().toString(), etFallaEqui.getText().toString());

    }

    public void eliminarEqui(View view){
        listaEquipos.eliminar(Integer.parseInt(etIdEqui.getText().toString()));
    }

    public void verListaEqui(View view){
        tvListaEqui.setText(listaEquipos.mostrar());
    }
}