package com.example.a19180118.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityResultado extends AppCompatActivity {

    TextView txtResultado;
    TextView txtEstadoCorporal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Recebendo os valores da Intent.
        // Passando-os para variáveis.
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String resultado = String.valueOf(bundle.getDouble("resultadoImc"));
        String estadoCorporal = bundle.getString("estadoCorporal");

        txtResultado = findViewById(R.id.txt_resultado);
        txtEstadoCorporal = findViewById(R.id.txt_estado_corporal);
        txtResultado.setText(resultado);
        txtEstadoCorporal.setText(estadoCorporal);

    }
}
