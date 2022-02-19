package com.example.proyectofinalard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Piano extends AppCompatActivity {
    SoundPool sp;
    int sonido_de_Reproduccion ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getSupportActionBar().setDisplayShowHomeEnabled( true);
        getSupportActionBar().setIcon(R.mipmap. ic_launcher);
        sp = new SoundPool(1, AudioManager. STREAM_MUSIC, 1);
        sonido_de_Reproduccion = sp.load(this, R.raw.do_song, 1);
        sonido_de_Reproduccion = sp.load(this, R.raw.re, 2);
        sonido_de_Reproduccion = sp.load(this, R.raw.mi, 3);
        sonido_de_Reproduccion = sp.load(this, R.raw.fa, 4);
        sonido_de_Reproduccion = sp.load(this, R.raw.sol, 5);
        sonido_de_Reproduccion = sp.load(this, R.raw.la, 6);
        sonido_de_Reproduccion = sp.load(this, R.raw.si, 7);
        sonido_de_Reproduccion = sp.load(this, R.raw.do_bajo, 8);

    }
    public void btnDoBajo (View view){
        MediaPlayer mp = MediaPlayer. create(this, R.raw.do_bajo);
        mp.start() ;
    }
    public void btnRe (View view){
        MediaPlayer mp = MediaPlayer. create(this, R.raw.re);
        mp.start() ;
    }
    public void btnMi (View view){
        MediaPlayer mp = MediaPlayer. create(this, R.raw.mi);
        mp.start() ;
    }
    public void btnFa (View view){
        MediaPlayer mp = MediaPlayer. create(this, R.raw.fa);
        mp.start() ;
    }
    public void btnSol (View view){
        MediaPlayer mp = MediaPlayer. create(this, R.raw.sol);
        mp.start() ;
    }
    public void btnLa (View view){
        MediaPlayer mp = MediaPlayer. create(this, R.raw.la);
        mp.start() ;
    }
    public void btnSi (View view){
        MediaPlayer mp = MediaPlayer. create(this, R.raw.si);
        mp.start() ;
    }
    public void btnDo (View view){
        MediaPlayer mp = MediaPlayer. create(this, R.raw.do_song);
        mp.start() ;
    }
    public void btnVolver(View view) {
        Intent siguiente = new Intent(this, MainActivity.class);
        startActivity(siguiente);
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