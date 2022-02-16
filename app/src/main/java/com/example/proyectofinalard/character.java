package com.example.proyectofinalard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class character extends AppCompatActivity {
    MediaPlayer mp[] = new MediaPlayer[1];
    int time = 0;


    EditText edit_codigo;
    EditText edit_nombre;
    EditText edit_vida;
    EditText edit_mana;
    EditText edit_skillDmg;
    EditText edit_skillMana;
    EditText edit_skillUses;
    EditText edit_skill;
    EditText edit_clase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled( true);
        getSupportActionBar().setIcon(R.mipmap. ic_launcher);

        edit_codigo = (EditText) findViewById(R.id.edit_codigoPersonaje);
        edit_nombre = (EditText) findViewById(R.id.edit_namePersonaje);
        edit_vida = (EditText) findViewById(R.id.edit_vida);
        edit_mana = (EditText) findViewById(R.id.edit_mana);
        edit_skillDmg = (EditText) findViewById(R.id.edit_dmg);
        edit_skillMana = (EditText) findViewById(R.id.edit_costeMana);
        edit_skillUses = (EditText) findViewById(R.id.edit_numUsos);
        edit_clase = (EditText) findViewById(R.id.edit_clase);
        edit_skill = (EditText) findViewById(R.id.edit_skillName);
        mp[0] = MediaPlayer.create(this, R.raw.lordoftherings);
    }

    public void saveCharacter(View view) {
        AdminSqlLiteOpenHelper admin = new AdminSqlLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase bbdd = admin.getWritableDatabase();

        String codigo = edit_codigo.getText().toString();
        String nombre = edit_nombre.getText().toString();
        String vida = edit_vida.getText().toString();
        String mana = edit_mana.getText().toString();
        String clases = edit_clase.getText().toString();
        String skill = edit_skill.getText().toString();
        String skillDmg = edit_skillDmg.getText().toString();
        String skillMana = edit_skillMana.getText().toString();
        String skillUses = edit_skillUses.getText().toString();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !vida.isEmpty() && !mana.isEmpty() &&
                !clases.isEmpty() && !skill.isEmpty() && !skillDmg.isEmpty() &&
                !skillMana.isEmpty() && !skillUses.isEmpty()) {
            ContentValues save = new ContentValues();
            save.put("id_personaje", codigo);
            save.put("nombre", nombre);
            save.put("vida", vida);
            save.put("mana", mana);
            save.put("clase", clases);
            save.put("nombre_skill", skill);
            save.put("damage", skillDmg);
            save.put("coste_mana", skillMana);
            save.put("num_usos", skillUses);
            bbdd.insert("Character", null, save);
            bbdd.close();

            edit_codigo.setText("");
            edit_nombre.setText("");
            edit_vida.setText("");
            edit_mana.setText("");
            edit_clase.setText("");
            edit_skill.setText("");
            edit_skillDmg.setText("");
            edit_skillMana.setText("");
            edit_skillUses.setText("");
            Toast.makeText(this, "INSERCION EXITOSA", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
        }

    }

    public void searchCharacter(View view) {
        AdminSqlLiteOpenHelper admin = new AdminSqlLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase bbdd = admin.getWritableDatabase();
        String codigo = edit_codigo.getText().toString();
        if (!codigo.isEmpty()) {
            Cursor row = bbdd.rawQuery(
                    "SELECT * FROM Character WHERE id_personaje = " + codigo, null
            );
            if (row.moveToFirst()) {
                edit_codigo.setText(row.getString(0));
                edit_nombre.setText(row.getString(1));
                edit_vida.setText(row.getString(2));
                edit_mana.setText(row.getString(3));
                edit_clase.setText(row.getString(4));
                edit_skill.setText(row.getString(5));
                edit_skillDmg.setText(row.getString(6));
                edit_skillMana.setText(row.getString(7));
                edit_skillUses.setText(row.getString(8));
                bbdd.close();
            } else {
                Toast.makeText(this, "No existe este Character", Toast.LENGTH_SHORT).show();
                bbdd.close();
            }
        } else {
            Toast.makeText(this, "Rellene el campo de ID de Personaje", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteCharacter(View view) {
        AdminSqlLiteOpenHelper admin = new AdminSqlLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase bbdd = admin.getWritableDatabase();
        String codigo = edit_codigo.getText().toString();
        if (!codigo.isEmpty()) {
            int verify = bbdd.delete("Character", "id_personaje=" + codigo, null);
            edit_codigo.setText("");
            edit_nombre.setText("");
            edit_vida.setText("");
            edit_mana.setText("");
            edit_clase.setText("");
            edit_skill.setText("");
            edit_skillDmg.setText("");
            edit_skillMana.setText("");
            edit_skillUses.setText("");
            if (verify == 1) {
                Toast.makeText(this, "Personaje borrado exitosamente", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No existe esa ID de personaje", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Introduzca una ID de personaje", Toast.LENGTH_SHORT).show();
        }
    }

    public void modifyCharacter(View view) {
        AdminSqlLiteOpenHelper admin = new AdminSqlLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase bbdd = admin.getWritableDatabase();

        String codigo = edit_codigo.getText().toString();
        String nombre = edit_nombre.getText().toString();
        String vida = edit_vida.getText().toString();
        String mana = edit_mana.getText().toString();
        String clases = edit_clase.getText().toString();
        String skill = edit_skill.getText().toString();
        String skillDmg = edit_skillDmg.getText().toString();
        String skillMana = edit_skillMana.getText().toString();
        String skillUses = edit_skillUses.getText().toString();
        if (codigo.isEmpty()) {
            Toast.makeText(this, "Rellene la casilla CODIGO PERSONAJE", Toast.LENGTH_SHORT).show();
        } else {
            if (!codigo.isEmpty() && !nombre.isEmpty() && !vida.isEmpty() && !mana.isEmpty() && !clases.isEmpty() && !skill.isEmpty() && !skillDmg.isEmpty() && !skillMana.isEmpty() && !skillUses.isEmpty()) {
                ContentValues save = new ContentValues();
                save.put("id_personaje", codigo);
                save.put("nombre", nombre);
                save.put("vida", vida);
                save.put("mana", mana);
                save.put("clase", clases);
                save.put("nombre_skill", skill);
                save.put("damage", skillDmg);
                save.put("coste_mana", skillMana);
                save.put("num_usos", skillUses);
                int verify = bbdd.update("Character", save, "id_personaje=" + codigo, null);
                bbdd.close();
                edit_codigo.setText("");
                edit_nombre.setText("");
                edit_vida.setText("");
                edit_mana.setText("");
                edit_clase.setText("");
                edit_skill.setText("");
                edit_skillDmg.setText("");
                edit_skillMana.setText("");
                edit_skillUses.setText("");
                if (verify == 1) {
                    Toast.makeText(this, "Personaje modificado exitosamente", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "No existe esa ID de personaje", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void back(View view) {
        Intent siguiente = new Intent(this, MainActivity.class);
        startActivity(siguiente);
        mp[time].pause();
    }

    public void playStopMusic(View view) {
        if (mp[time].isPlaying()) {
            mp[time].pause();
            Toast.makeText(this, "Stoping Music!", Toast.LENGTH_SHORT).show();
        } else {
            mp[time].start();
            Toast.makeText(this, "Playing Music!", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu. overflow, menu);
        return true;
    }
}