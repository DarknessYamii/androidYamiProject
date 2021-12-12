package com.example.proyectofinalard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSqlLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSqlLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bbdd) {
        bbdd.execSQL("create table Character(id_personaje int primary key, nombre text, vida real, mana real, clase text, nombre_skill text, damage real , coste_mana real, num_usos real )");
    }


    @Override
    public void onUpgrade(SQLiteDatabase bbdd, int i, int i1) {
    bbdd.execSQL("DROP TABLE IF EXISTS Character");
    onCreate(bbdd);
    }
}
