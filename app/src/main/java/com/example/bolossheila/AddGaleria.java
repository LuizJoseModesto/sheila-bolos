package com.example.bolossheila;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;

import static com.example.bolossheila.MainActivity.sqLiteHelper;

public class AddGaleria extends AppCompatActivity {

    Button btnCarrega, btnAdd, btnGaleria;
    ImageView imageView;
    private TextView txtNome, user, userget;

    final int REQUEST_CODE_GALLERY = 999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_galeria);


        txtNome=findViewById(R.id.txtNome);
        Bundle args=getIntent().getExtras();
        String nome=args.getString("ch_usuario");
        //txtNome.setText("Bem vindo "+nome);
        txtNome.setHint("Bem vindo "+nome);
        //userget.setText(nome);


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        init();


        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS foodimage(Id INTEGER PRIMARY KEY AUTOINCREMENT, image BLOB, useradd VARCHAR)");

        btnCarrega.setOnClickListener(view -> ActivityCompat.requestPermissions(
                AddGaleria.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_CODE_GALLERY
        ));

        btnAdd.setOnClickListener(view -> {
            try{
                sqLiteHelper.insertData(
                        user.getText().toString().trim(),
                        imageViewToByte(imageView)
                );
                Toast.makeText(getApplicationContext(), "Adicionada com Sucesso!", Toast.LENGTH_SHORT).show();
                user.setText("");
                imageView.setImageResource(R.mipmap.ic_launcher);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });

        btnGaleria.setOnClickListener(view -> {
            Intent intent = new Intent(this, FoodList.class);
            startActivity(intent);
        });
    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(), "Você não tem permissão para accessar os arquivos do dispositivo!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void init(){

        user = (TextView) findViewById(R.id.txtNome);
        btnCarrega = (Button) findViewById(R.id.btnCarregar);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnGaleria = (Button) findViewById(R.id.btnGaleria);
        imageView = (ImageView) findViewById(R.id.imageView);
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