package com.example.proyectofinalard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class camara_fotos extends AppCompatActivity {

    private ImageView img;
    private ImageButton imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(imageBitmap);
        }
    }
    }
