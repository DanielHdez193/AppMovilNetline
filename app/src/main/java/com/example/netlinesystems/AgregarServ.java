package com.example.netlinesystems;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AgregarServ extends AppCompatActivity {

    RequestQueue requestQueue;
    ArrayList clienteslist, empleadoslist;
    Spinner spClientes, spEstatus, spEmpleados;

    String URLServer = "http://192.168.100.8:8010/api/client";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_serv);

        spClientes = findViewById(R.id.spClientes);
        spEstatus = findViewById(R.id.spEstatus);
        spEmpleados = findViewById(R.id.spEmpleado);

        clienteslist = new ArrayList();
        clienteslist.add("01 / Andres Castro");
        clienteslist.add("02 / Juan Lopez");
        clienteslist.add("03 / Jorge Sanchez");
        //obtenerClientes(URLServer);
        ArrayAdapter adaptadorClientes = new ArrayAdapter(this, android.R.layout.simple_spinner_item, clienteslist);
        spClientes.setAdapter(adaptadorClientes);

        empleadoslist = new ArrayList();
        empleadoslist.add("01 / Carlos Garcia");
        empleadoslist.add("02 / Karina Villaseñor");
        empleadoslist.add("03 / Raul Perez");
        ArrayAdapter adaptadorEmpleados = new ArrayAdapter(this, android.R.layout.simple_spinner_item, empleadoslist);
        spEmpleados.setAdapter(adaptadorEmpleados);

        String[] STOrden = new String[4];
        STOrden[0] = "Recibida";
        STOrden[1] = "Activa";
        STOrden[2] = "Cerrada";
        STOrden[3] = "Eliminada";
        ArrayAdapter adaptadorEstatus = new ArrayAdapter(this, android.R.layout.simple_spinner_item, STOrden);
        spEstatus.setAdapter(adaptadorEstatus);


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

    public void agregarMaterialServ(View view){
        Intent agregarMaterialServ = new Intent(this, AgregarMaterialServ.class);
        startActivity(agregarMaterialServ);
    }

    ////////////////////
    private void obtenerClientes(String url) {
        JsonArrayRequest jsonarrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    //respuesta exitosa por parte del servidor
                    @Override
                    public void onResponse(JSONArray response) {
                        int contadorClientes = response.length();
                        //Cliente[] listaClientes = new Cliente[contadorClientes];

                        String id;
                        String nombre, tipo, responsable, telefono, email, direcion, rfc, nota, foto, estatus;

                        for (int i = 0; i < response.length(); i++) {
                            try {//extrayendo el objecto json de cada una de las posiciones del arreglo
                                JSONObject jsonObject = new JSONObject(response.get(i).toString());
                                id = jsonObject.getString("id");
                                nombre = jsonObject.getString("name");
                                     /*tipo=jsonObject.getString("type");
                                    responsable=jsonObject.getString("responsable_name" + "responsable_surname");
                                    telefono=jsonObject.getString("phone_1");
                                    email=jsonObject.getString("email");
                                    direcion=jsonObject.getString("address");
                                    rfc=jsonObject.getString("rfc");
                                    nota=jsonObject.getString("notes");
                                    foto=jsonObject.getString("photo");
                                    estatus=jsonObject.getString("status");

                                    listaClientes[i]=new Cliente(id,nombre,tipo,responsable,telefono,email,direcion,rfc,nota,foto,estatus);*/
                                //clienteslist.add(id + "/" + nombre);

                                System.out.println("No se encontro nada");
                                Toast.makeText(getApplicationContext(), "no se encontro nada", Toast.LENGTH_LONG).show();

                                System.out.println("try");
                            }//cierre del try
                            catch (JSONException e) {
                                e.printStackTrace();
                                System.out.println("Ex");
                                Toast.makeText(getApplicationContext(), "ex", Toast.LENGTH_LONG).show();
                            }
                        }//cierre del for
                        Toast.makeText(getApplicationContext(), "otrp", Toast.LENGTH_LONG).show();

                    }//cierre del onResponse

                }, //en caso de respuesta de error por parte del servidor
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                                /*System.out.println(error);
                                System.out.println("error volley");
                                Toast.makeText(getApplicationContext(), "Error volley", Toast.LENGTH_LONG).show();*/
                        if (error instanceof ServerError) {
                            Log.i("TAG", "Server Error");
                        }
                        if (error instanceof NoConnectionError) {
                            Log.i("TAG", "No conection");
                        }

                    }
                });
        requestQueue.add(jsonarrayRequest);

    }//cierre del método iniciSesion

    //////
}