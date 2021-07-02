package com.example.bolossheila;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SQLiteHelper extends SQLiteOpenHelper{
    //Parte relacionada com as imagens
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String useradd, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO foodimage VALUES (NULL, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindBlob(1, image);
        statement.bindString(2, useradd);
        statement.executeInsert();
    }

    public void updateData(byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE foodimage SET image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindBlob(1, image);
        statement.bindDouble(0, (double)id);

        statement.execute();
        database.close();
    }

    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM foodimage WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(0, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getWritableDatabase();

        return database.rawQuery(sql, null);
    }

    public Bitmap getImage(int i){
        SQLiteDatabase db = getWritableDatabase();
        String qu = "select IMAGE  from foodimage where id=" + i ;
        Cursor cur = db.rawQuery(qu, null);

        if (cur.moveToFirst()){
            byte[] imgByte = cur.getBlob(0);
            cur.close();
            return BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
        }
        if (cur != null && !cur.isClosed()) {
            cur.close();
        }

        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}