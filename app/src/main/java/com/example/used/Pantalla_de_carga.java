package com.example.used;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.used.Activity.MainActivity;

public class Pantalla_de_carga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_carga);

        int Tiempo = 3000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Pantalla_de_carga.this, MainActivity.class));
                finish();
            }
        },Tiempo);
    }
}