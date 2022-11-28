package com.example.netlinesystems;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.netlinesystems.listamaterialdimen.ListaMatDimen;
import com.example.netlinesystems.listamaterialdimen.MaterialDimen;

public class AgregarMaterialDim extends AppCompatActivity {

    EditText etIdDim, etCantDim, etUniDim, etDescDim;
    TextView tvListaDim;
    ListaMatDimen listaMaterialesDim = new ListaMatDimen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_material_dim);

        etIdDim = findViewById(R.id.etIdDim);
        etCantDim = findViewById(R.id.etCantDim);
        etUniDim = findViewById(R.id.etUniDim);
        etDescDim=findViewById(R.id.etDescDim);
        tvListaDim=findViewById(R.id.tvListaDim);

    }

    public void agregarMat(View view) {
        MaterialDimen nMat = new MaterialDimen();
        nMat.setId(listaMaterialesDim.getContador() + 1);
        nMat.setCantidad(Integer.parseInt(etCantDim.getText().toString()));
        nMat.setUnidad(etUniDim.getText().toString());
        nMat.setDescripcion(etDescDim.getText().toString());
        listaMaterialesDim.agregar(nMat);

    }

    public void  modificarMat(View view){
        int pos = Integer.parseInt(etIdDim.getText().toString());
        int cant = Integer.parseInt(etCantDim.getText().toString());
        listaMaterialesDim.modificar(pos, cant);
    }

    public void eliminarMat(View view){
        listaMaterialesDim.eliminar(Integer.parseInt(etIdDim.getText().toString()));

    }

    public void verLista(View view){
        tvListaDim.setText(listaMaterialesDim.mostrar());
    }
}