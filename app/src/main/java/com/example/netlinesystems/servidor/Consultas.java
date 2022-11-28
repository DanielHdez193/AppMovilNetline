package com.example.netlinesystems.servidor;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Consultas {

    RequestQueue requestQueue;

    Variables var = new Variables();

    String URLServer = var.getURLAPI() + "/api/client";

    private void obClientes() {
        StringRequest request = new StringRequest(
                Request.Method.GET, URLServer, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );

        requestQueue.add(request);
    }

    private void obtenerClientes(String url) {
        JsonArrayRequest jsonarrayRequest = new JsonArrayRequest
                (url, new Response.Listener<JSONArray>() {
                    //respuesta exitosa por parte del servidor
                    @Override
                    public void onResponse(JSONArray response) {
                        int contadorClientes = response.length();
                        Cliente[] listaClientes = new Cliente[contadorClientes];
                        String id;
                        String nombre, tipo, responsable, telefono, email, direcion, rfc, nota, foto, estatus;
                        JSONObject jsonObject = null;
                        for (int i = 0; i < response.length(); i++) {
                            try {//extrayendo el objecto json de cada una de las posiciones del arreglo
                                jsonObject = response.getJSONObject(i);

                                if (jsonObject.getString("status")=="Activo"){
                                    id=jsonObject.getString("id");
                                    nombre=jsonObject.getString("name");
                                    tipo=jsonObject.getString("type");
                                    responsable=jsonObject.getString("responsable_name" + "responsable_surname");
                                    telefono=jsonObject.getString("phone_1");
                                    email=jsonObject.getString("email");
                                    direcion=jsonObject.getString("address");
                                    rfc=jsonObject.getString("rfc");
                                    nota=jsonObject.getString("notes");
                                    foto=jsonObject.getString("photo");
                                    estatus=jsonObject.getString("status");

                                    listaClientes[i]=new Cliente(id,nombre,tipo,responsable,telefono,email,direcion,rfc,nota,foto,estatus);
                                }

                            }//cierre del try
                            catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }//cierre del for
                        //ArrayAdapter adaptadorClientes = new ArrayAdapter()

                    }//cierre del onResponse

                }, //en caso de respuesta de error por parte del servidor
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {

                                System.out.println(error);
                                Cliente[] listaClientes = new Cliente[0];

                            }
                        });
        requestQueue.add(jsonarrayRequest);

    }//cierre del método iniciSesion



}
