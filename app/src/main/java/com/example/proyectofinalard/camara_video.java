package com.example.proyectofinalard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class camara_video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_camara_video);
        if (ContextCompat. checkSelfPermission(camara_video. this,
                Manifest.permission. WRITE_EXTERNAL_STORAGE) !=
                PackageManager. PERMISSION_GRANTED &&
                ActivityCompat. checkSelfPermission(camara_video. this,
                        Manifest.permission. CAMERA) != PackageManager. PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(camara_video.this, new
                    String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA}, 1000);
        }
    }
    static final int REQUEST_VIDEO_CAPTURE = 1;
     public void TomarVideo(View view) {
        Intent takeVideoIntent = new
                Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) !=
                null) {
            startActivityForResult(takeVideoIntent,
                    REQUEST_VIDEO_CAPTURE);
        }
    }

    public void back(View view) {
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