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

public class Cadastro extends AppCompatActivity {

    private SQLiteHelperContato helper=new SQLiteHelperContato(this);
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtUsuario;
    private EditText edtSenha;
    private EditText edtConfSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        edtNome=findViewById(R.id.edtNome);
        edtEmail=findViewById(R.id.edtEmail);
        edtUsuario=findViewById(R.id.edtUsuario);
        edtSenha=findViewById(R.id.edtSenha);
        edtConfSenha=findViewById(R.id.edtConfSenha);


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
    public void cadastrar(View view) {

        String nome=edtNome.getText().toString();
        String email=edtEmail.getText().toString();
        String usr=edtUsuario.getText().toString();
        String senha=edtSenha.getText().toString();
        String confSenha=edtConfSenha.getText().toString();

        if(nome.equals("") || email.equals("") || usr.equals("")) {
            Toast toast = Toast.makeText(Cadastro.this,
                    "Nome, e-mail, usuário e senha são obrigatórios!", Toast.LENGTH_SHORT);
            edtNome.setText("");
            edtEmail.setText("");
            edtUsuario.setText("");
            edtSenha.setText("");
            edtConfSenha.setText("");
        }else{
            if (!senha.equals(confSenha)) {

                Toast toast = Toast.makeText(Cadastro.this,
                        "Senha difere da confirmação de senha!", Toast.LENGTH_SHORT);
                toast.show();
                edtSenha.setText("");
                edtConfSenha.setText("");
            } else {
                Contato c = new Contato();
                c.setNome(nome);
                c.setEmail(email);
                c.setUsuario(usr);
                c.setSenha(senha);
                helper.inserirContato(c);
                Toast toast = Toast.makeText(Cadastro.this,
                        "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT);
                toast.show();
                limpar();
                Intent it = new Intent(this, Login.class);
                startActivity(it);

            }
        }
    }

    private void limpar() {
        edtNome.setText("");
        edtEmail.setText("");
        edtUsuario.setText("");
        edtSenha.setText("");
        edtConfSenha.setText("");
    }

    public void cancelar(View view) {
        finish();
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