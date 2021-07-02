package com.example.bolossheila;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Login extends AppCompatActivity {

    private SQLiteHelperContato helper=new SQLiteHelperContato(this);
    private EditText edtUsuario;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsuario=findViewById(R.id.edtUsuario);
        edtSenha=findViewById(R.id.edtSenha);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }
    public void conectar(View view) {
        String usr=edtUsuario.getText().toString();
        String senha=edtSenha.getText().toString();
        String pass=helper.buscarSenha(usr);
        if(senha.equals(pass)){
            Intent it=new Intent(this, AddGaleria.class);
            it.putExtra("ch_usuario",usr);
            startActivity(it);
        }else{
            Toast toast=Toast.makeText(Login.this,"Usuário ou senha não encontrado",
                    Toast.LENGTH_LONG);
            toast.show();
        }
    }
    public void cadastrar(View view) {
        Intent it=new Intent(this, Cadastro.class);
        startActivity(it);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}