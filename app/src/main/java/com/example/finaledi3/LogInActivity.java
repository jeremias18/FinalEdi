package com.example.finaledi3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    private EditText et_nombre, et_clave;
    private String edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        et_nombre = findViewById(R.id.txt_usuarioIngresar);
        et_clave = findViewById(R.id.txt_claveIngresar);
    }

    public void buscarUsuario(View view){
        String nombre = et_nombre.getText().toString();
        String clave = et_clave.getText().toString();

        AdminSQLLite admin = new AdminSQLLite(this, "usuarios", null, 1);
        try {
            SQLiteDatabase BdD = admin.getWritableDatabase();
            Cursor fila = BdD.rawQuery("SELECT usuario, edad FROM usuarios WHERE usuario = '" + nombre + "' AND clave = " + clave + "", null);
            if (fila.moveToFirst()) {
                edad = fila.getString(1);
                Toast.makeText(this, nombre + " ingresó correctamente.", Toast.LENGTH_SHORT).show();
                this.IngresarUsuario();
            } else {
                Toast.makeText(this, "No existe ese usuario", Toast.LENGTH_SHORT).show();
            }
            fila.close();
        }catch (Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void IngresarUsuario(){
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("Nombre", et_nombre.getText().toString());
        intent.putExtra("Edad", edad);
        startActivity(intent);
    }
}