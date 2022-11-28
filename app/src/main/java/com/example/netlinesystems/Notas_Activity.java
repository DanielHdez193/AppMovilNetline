package com.example.netlinesystems;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Notas_Activity extends AppCompatActivity {

    EditText etNotas, etPendientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_);

        etNotas = findViewById(R.id.etNotas);
        etPendientes = findViewById(R.id.etPendientes);

        String archivos[] = fileList();

        if (ArchivoExiste(archivos, "notas.txt")) {
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("notas.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String nota = br.readLine();
                String notaCompleta = "";

                while (nota != null) {
                    notaCompleta = notaCompleta + nota + "\n";
                    nota = br.readLine();
                }
                br.close();
                archivo.close();
                etNotas.setText(notaCompleta);
            } catch (IOException e) {

            }
        }

        if (ArchivoExiste(archivos, "pendientes.txt")) {
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("pendientes.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String pendiente = br.readLine();
                String pendienteCompleta = "";

                while (pendiente != null) {
                    pendienteCompleta = pendienteCompleta + pendiente + "\n";
                    pendiente = br.readLine();
                }
                br.close();
                archivo.close();
                etPendientes.setText(pendienteCompleta);
            } catch (IOException e) {

            }
        }
    }

    //Metodos para el Action-Bar Overflow
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

    //Metodo para notas
    private boolean ArchivoExiste(String archivos[], String NombreArchivo) {
        for (int i = 0; i < archivos.length; i++)
            if (NombreArchivo.equals(archivos[i]))
                return true;
        return false;
    }

    //Metodo para boton guardar
    public void Guardar(View view) {
        try {
            OutputStreamWriter archivo1 = new OutputStreamWriter(openFileOutput("notas.txt", Activity.MODE_PRIVATE));
            OutputStreamWriter archivo2 = new OutputStreamWriter(openFileOutput("pendientes.txt", Activity.MODE_PRIVATE));
            archivo1.write(etNotas.getText().toString());
            archivo2.write(etPendientes.getText().toString());
            archivo1.flush();
            archivo2.flush();
            archivo1.close();
            archivo2.close();
        } catch (IOException e) {

        }
        Toast.makeText(this, "Notas y Pendientes Guardadas correctamente", Toast.LENGTH_SHORT).show();
    }

}