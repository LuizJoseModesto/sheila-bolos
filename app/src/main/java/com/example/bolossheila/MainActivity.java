package com.example.bolossheila;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sqLiteHelper = new SQLiteHelper(this, "FOOD.db", null, 1);


    }

    public void entrar(View view){
        Intent it = new Intent(this, MenuOpcao.class);
        startActivity(it);
    }
}