package com.example.basededatoslocal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class sql {
    SQLite2 conn;

    public sql(Context context){
        conn = new SQLite2(context, "agenda", null, 1);
    }

    public String select(String linea, Context C){
        String cadena = "";

        SQLiteDatabase db = conn.getWritableDatabase();
        try{
            Cursor cur = db.rawQuery(linea, null);
            while(cur.moveToNext()){
                cadena += cur.getInt(0)+" " ;
                cadena += cur.getInt(1)+" " ;
                cadena += cur.getInt(2)+"\n" ;
            }
            db.close();
        }
        catch (Exception ex){
            Toast.makeText(C, ex.getMessage(), Toast.LENGTH_SHORT).show();
            db.close();
        }
        return cadena;
    }

    public String insert(int id, String nom, String tel, Context C){
        SQLiteDatabase db = conn.getWritableDatabase();
        try{
            String cadena = "insert into usuario values ('"+ id+"','"+ nom +"','"+tel+"')";
            db.execSQL(cadena);
        }
        catch (Exception e){
            Toast.makeText(C, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return "1";
    }
}
