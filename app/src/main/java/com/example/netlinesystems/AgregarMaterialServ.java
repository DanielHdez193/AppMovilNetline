package com.example.netlinesystems;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.netlinesystems.listamaterialserv.ListaMatServ;
import com.example.netlinesystems.listamaterialserv.MaterialServ;

public class AgregarMaterialServ extends AppCompatActivity {

    EditText etNombreMat, etDescMat, etCantMat, etIdMatElim;
    TextView tvListaMat;
    ListaMatServ listaMateriales = new ListaMatServ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_material_serv);

        etNombreMat = findViewById(R.id.etMarcaEqui);
        etDescMat = findViewById(R.id.etModeloEqui);
        etCantMat = findViewById(R.id.etNSerieEqui);
        etIdMatElim = findViewById(R.id.etIdEqui);
        tvListaMat = findViewById(R.id.tvListaEqui);

    }

    public void agregarMat(View view) {
        MaterialServ nMat = new MaterialServ();
        nMat.setId(listaMateriales.getContador() + 1);
        nMat.setNombre(etNombreMat.getText().toString());
        nMat.setDescripcion(etDescMat.getText().toString());
        nMat.setCantidad(Integer.parseInt(etCantMat.getText().toString()));
        listaMateriales.agregar(nMat);

    }

    public void  modificarMat(View view){
        int pos = Integer.parseInt(etIdMatElim.getText().toString());
        int cant = Integer.parseInt(etCantMat.getText().toString());
        listaMateriales.modificar(pos, cant);
    }

    public void eliminarMat(View view){
        listaMateriales.eliminar(Integer.parseInt(etIdMatElim.getText().toString()));
        etIdMatElim.setText(" ");
    }

    public void verLista(View view){
        tvListaMat.setText(listaMateriales.mostrar());
    }
}