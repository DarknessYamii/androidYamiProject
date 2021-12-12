package com.example.proyectofinalard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
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
}