package com.example.proyectofinalard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class listajuegos extends AppCompatActivity {
    MediaPlayer mp[] = new MediaPlayer[1];
    int time = 0;
    RadioButton rbAccion;
    RadioButton rbRol;
    RadioButton rbPlataforma;
    RadioButton rbPuzzle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listajuegos);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        rbAccion = (RadioButton) findViewById(R.id.rbAccion);
        rbRol = (RadioButton) findViewById(R.id.rbRol);
        rbPlataforma = (RadioButton) findViewById(R.id.rbPlataforma);
        rbPuzzle = (RadioButton) findViewById(R.id.rbPuzzle);
        mp[0] = MediaPlayer.create(this, R.raw.lordoftherings);
        getSupportActionBar().setDisplayShowHomeEnabled( true);
        getSupportActionBar().setIcon(R.mipmap. ic_launcher);

    }
    public void sendInformation(View view) {
        if (rbAccion.isChecked()) {
            mp[time].pause();
            Intent i = new Intent(this, buscador_listajuegos.class);
            i.putExtra("juego","vandal.elespanol.com/juegos/0/videojuegos/2/"+ rbAccion.getText().toString());
            startActivity(i);
        } else if (rbRol.isChecked()) {
            mp[time].pause();
            Intent i = new Intent(this, buscador_listajuegos.class);
            i.putExtra("juego","vandal.elespanol.com/juegos/0/videojuegos/31/" +rbRol.getText().toString());
            startActivity(i);
        } else if (rbPlataforma.isChecked()) {
            mp[time].pause();
            Intent i = new Intent(this, buscador_listajuegos.class);
            i.putExtra("juego", "vandal.elespanol.com/juegos/0/videojuegos/23/" + rbPlataforma.getText().toString());
            startActivity(i);
        } else if (rbPuzzle.isChecked()) {
            mp[time].pause();
            Intent i = new Intent(this, buscador_listajuegos.class);
            i.putExtra("juego","vandal.elespanol.com/juegos/0/videojuegos/29/" + rbPuzzle.getText().toString());
            startActivity(i);
        }
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
    public void back(View view){
        Intent siguiente = new Intent(this, MainActivity.class);
        startActivity(siguiente);
        mp[time].pause();
    }
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu. overflow, menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId() ;
        if(id == R.id.camaraFotos){
            Intent siguiente = new Intent(this, camara_fotos.class);
            startActivity(siguiente);
        } else if(id == R.id.camaraVideos){
            Intent siguiente = new Intent(this, camara_video.class);
            startActivity(siguiente);
        }else if(id == R.id.grabadora){
            Intent siguiente = new Intent(this, grabadora.class);
            startActivity(siguiente);
        }else if(id == R.id.recorder){
            Intent siguiente = new Intent(this, grabadora.class);
            startActivity(siguiente);
        }else if(id == R.id.fotos){
            Intent siguiente = new Intent(this, camara_fotos.class);
            startActivity(siguiente);
        }else if(id == R.id.videos){
            Intent siguiente = new Intent(this, camara_video.class);
            startActivity(siguiente);
        }
        return super .onOptionsItemSelected(item) ;
    }
}