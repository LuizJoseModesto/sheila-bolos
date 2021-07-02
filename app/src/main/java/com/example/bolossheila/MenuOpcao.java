package com.example.bolossheila;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Objects;

public class MenuOpcao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opcao);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    public void entraCardapio(View view){
        Intent it = new Intent(this, Cardapio.class);
        startActivity(it);
    }

    public void entraGaleria(View view){
        Intent it = new Intent(this, FoodList.class);
        startActivity(it);
    }

    public void entraInserir(View view){
        Intent it = new Intent(this, Login.class);
        startActivity(it);
    }



    public void entraInstagram(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/bolosdecoradossheila?utm_medium=copy_link")));
    }
    public void entraWhatsapp(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://api.whatsapp.com/send?1=pt_BR&phone=5567992630980")));
    }
    public void entraFacebook(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/sheila.campozano.7")));
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