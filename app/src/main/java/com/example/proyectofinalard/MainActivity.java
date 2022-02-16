package com.example.proyectofinalard;

import      androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp[] = new MediaPlayer[1];
    int time = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mp[0] = MediaPlayer.create(this, R.raw.lordoftherings);
        getSupportActionBar().setDisplayShowHomeEnabled( true);
        getSupportActionBar().setIcon(R.mipmap. ic_launcher);

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
    public void goPiano(View view) {
        Intent siguiente = new Intent(this, Piano.class);
        startActivity(siguiente);
        mp[time].pause();
    }
    public void goJuegos(View view) {
        Intent siguiente = new Intent(this, listajuegos.class);
        startActivity(siguiente);
        mp[time].pause();
    }
    public void goCharacter(View view) {
        Intent siguiente = new Intent(this, character.class);
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
            Toast. makeText(this, "Opción 2" , Toast.LENGTH_SHORT).show() ;
        }else if(id == R.id.grabadora){
            Toast. makeText(this, "Opción 3" , Toast.LENGTH_SHORT).show() ;
        }else if(id == R.id.recorder){
            Toast. makeText(this, "Opción 4" , Toast.LENGTH_SHORT).show() ;
        }else if(id == R.id.fotos){
            Toast. makeText(this, "Opción 5" , Toast.LENGTH_SHORT).show() ;
        }else if(id == R.id.videos){
            Toast. makeText(this, "Opción 6" , Toast.LENGTH_SHORT).show() ;
        }
        return super .onOptionsItemSelected(item) ;
    }

}