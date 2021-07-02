package com.example.bolossheila;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

public class SQLiteHelperContato extends SQLiteOpenHelper{

    //Parte relacionada com os Contatos
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME="FOOD.db";
    private static final String TABLE_NAME="contato";
    private static final String COLUMM_ID="id";
    private static final String COLUMM_NAME="nome";
    private static final String COLUMM_EMAIL="email";
    private static final String COLUMM_USER="usuario";
    private static final String COLUMM_PASS="senha";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contato " +
            "(id integer primary key autoincrement, nome text not null, " +
            "email text, usuario text not null, senha text not null);";

    public SQLiteHelperContato(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
    public void inserirContato(Contato c){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMM_NAME, c.getNome());
        values.put(COLUMM_EMAIL, c.getEmail());
        values.put(COLUMM_USER, c.getUsuario());
        values.put(COLUMM_PASS, c.getSenha());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public String buscarSenha(String usuario){
        db=this.getReadableDatabase();
        String query = "select usuario, senha from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="não encontrado";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                if(a.equals(usuario)){
                    b=cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }

}
