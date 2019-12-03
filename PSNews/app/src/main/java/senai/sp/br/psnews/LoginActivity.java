package senai.sp.br.psnews;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    Button btnLogin;
    EditText txtEmail;
    EditText txtSenha;
    TextInputLayout inputLayoutEmail;
    TextInputLayout inputLayoutSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnLogin = findViewById(R.id.btn_login);
        txtEmail = findViewById(R.id.txt_email);
        txtSenha = findViewById(R.id.txt_senha);
        inputLayoutEmail = findViewById(R.id.input_email);
        inputLayoutSenha = findViewById(R.id.input_senha);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String emailInserido = txtEmail.getText().toString();
                String senhaInserida = txtSenha.getText().toString();

                if (emailInserido.isEmpty()) {
                    inputLayoutEmail.setErrorEnabled(true);
                    inputLayoutEmail.setError("Digite um endereço de email!");
                }
                else if (senhaInserida.isEmpty()) {
                    inputLayoutSenha.setErrorEnabled(true);
                    inputLayoutSenha.setError("Insira uma senha!");
                }

                Intent abrirActivityCategorias = new Intent(LoginActivity.this, ActivityCategorias.class);
                startActivity(abrirActivityCategorias);

            }

        });


    }

}
