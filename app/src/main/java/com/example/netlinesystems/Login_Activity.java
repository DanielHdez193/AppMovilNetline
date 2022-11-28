package com.example.netlinesystems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login_Activity extends AppCompatActivity {

    private EditText etUsuario, etContra;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        etUsuario = findViewById(R.id.etNombreLogin);
        etContra = findViewById(R.id.etContraLogin);
        btnEntrar = findViewById(R.id.btnEntrarLogin);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IniSesion = new Intent(Login_Activity.this, Inicio_Activity.class);
                startActivity(IniSesion);
            }
        });

    }
}