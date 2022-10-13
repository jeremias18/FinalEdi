package com.example.finaledi3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Evento click para siguiente activity
    public void ingresarClick(View view){
        Intent ingresar = new Intent(this, LogInActivity.class);
        startActivity(ingresar);
    }

    public void registrarClick(View view){
        Intent registrar = new Intent(this, RegistrarActivity.class);
        startActivity(registrar);
    }
}