package com.example.proyectofinalard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class camara_fotos extends AppCompatActivity {

    private ImageView img;
    private ImageButton imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_camara_fotos);
        img = (ImageView) findViewById(R.id.imagenPrevia);
        imgButton = (ImageButton) findViewById(R.id.camaraBoton);

        if(ContextCompat.checkSelfPermission(camara_fotos.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(camara_fotos.this, new String[]{Manifest.permission.CAMERA}, 101);
        }

        imgButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 101);
            }
        });

    }

    public void back(View view) {
        Intent siguiente = new Intent(this, MainActivity.class);
        startActivity(siguiente);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(imageBitmap);
        }
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
