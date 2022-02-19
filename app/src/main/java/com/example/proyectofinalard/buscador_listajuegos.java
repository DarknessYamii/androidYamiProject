package com.example.proyectofinalard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class buscador_listajuegos extends AppCompatActivity {

    WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador_listajuegos);
        wv1 = (WebView)findViewById(R.id.webJuegos);
        String URL = getIntent().getStringExtra("juego");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("https://" + URL);
        getSupportActionBar().setDisplayShowHomeEnabled( true);
        getSupportActionBar().setIcon(R.mipmap. ic_launcher);

}
    public void backJuegos(View view){
        Intent i = new Intent(this, listajuegos. class);
        startActivity(i) ;
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