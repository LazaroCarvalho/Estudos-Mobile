package com.example.a19180118.myapplication;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText txtPeso;
    EditText txtAltura;
    TextInputLayout layoutPeso;
    TextInputLayout layoutAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btn_calcular);
        txtPeso = findViewById(R.id.txt_peso);
        txtAltura = findViewById(R.id.txt_altura);
        layoutPeso = findViewById(R.id.layout_peso);
        layoutAltura = findViewById(R.id.layout_altura);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            DecimalFormat df = new DecimalFormat("#00.00");

            @Override
            public void onClick(View view) {

                if (txtPeso.getText().toString().isEmpty()) {   // Caso algum campo não tenha preenchido, estas mensagens de erro aparecerão.
                    layoutPeso.setErrorEnabled(true);
                    layoutPeso.setError("Peso é obrigatório");
                } else if (txtAltura.getText().toString().isEmpty()) {
                    layoutAltura.setErrorEnabled(true);
                    layoutAltura.setError("Altura é obrigatória");
                } else {    // Se campos foram preenchidos corretamente, este else é executado.

                    double valueTxtPeso = Double.parseDouble(txtPeso.getText().toString());
                    double valueTxtAltura = Double.parseDouble(txtAltura.getText().toString());
                    double resultadoImc = Double.parseDouble(df.format(valueTxtPeso / Math.pow(valueTxtAltura, 2)));

                    String estadoCorporal;

                    // Verificando estado corporal.
                    if(resultadoImc < 17)
                        estadoCorporal = "Muito abaixo do peso";
                    else if(resultadoImc >= 17 && resultadoImc <= 18.49)
                        estadoCorporal = "Abaixo do peso";
                    else if(resultadoImc >= 18.5 && resultadoImc <= 24.99)
                        estadoCorporal = "Peso normal";
                    else if(resultadoImc >= 25 && resultadoImc <= 29.99)
                        estadoCorporal = "Acima do peso";
                    else if(resultadoImc >= 30 && resultadoImc <= 34.99)
                        estadoCorporal = "Obesidade I";
                    else if(resultadoImc >= 35 && resultadoImc <= 39.99)
                        estadoCorporal = "Obesidade II";
                    else
                        estadoCorporal = "Obesidade III";

                    // Passando os resultados obtidos para a activity que se abrirá em seguida.
                    Bundle bundle = new Bundle();
                    bundle.putDouble("resultadoImc", resultadoImc);
                    bundle.putString("estadoCorporal", estadoCorporal);
                    Intent abrirActivityResultadoImc = new Intent(MainActivity.this, ActivityResultado.class);
                    abrirActivityResultadoImc.putExtras(bundle);
                    startActivity(abrirActivityResultadoImc);
                }

            }
        });

    }

}
