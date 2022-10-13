package com.example.finaledi3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {
    private EditText et_nombre;
    private EditText et_clave;
    private EditText et_edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        //Recupero los datos usando el id. R.id es para asignarlos.
        et_nombre = findViewById(R.id.txt_usuarioRegistrar);
        et_clave = findViewById(R.id.txt_claveRegistrar);
        et_edad = findViewById(R.id.txt_edadRegistrar);
        //TextView tv_registrar = findViewById(R.id.tv_registrar);
    }

    public void guardarUsuario(View view){
        AdminSQLLite admin = new AdminSQLLite(this, "usuarios", null, 1);
        SQLiteDatabase BdD = admin.getWritableDatabase();

        String Usuario_String = et_nombre.getText().toString();
        String Clave_String = et_clave.getText().toString();
        String Edad_String = et_edad.getText().toString();
        int Edad_Number = Integer.parseInt(et_edad.getText().toString());

        if(!Usuario_String.isEmpty() && Usuario_String.length() > 244){
            Toast.makeText(this, "Ingrese nombre de usuario válido.", Toast.LENGTH_SHORT).show();
        }else if (Clave_String.length() < 4) {
            Toast.makeText(this, "Ingrese una clave correcta.", Toast.LENGTH_SHORT).show();
        }else if (Edad_Number > 0 && Edad_Number < 110){
            try {
                ContentValues registro = new ContentValues();
                registro.put("usuario", Usuario_String);
                registro.put("clave", Clave_String);
                registro.put("edad", Edad_String);
                BdD.insertOrThrow("usuarios", null, registro);
                BdD.close();
                limpiarCampos();
                Toast.makeText(this, "Se guardó correctamente el usuario", Toast.LENGTH_SHORT).show();
            }
            catch (SQLiteConstraintException e){
                Toast.makeText(this, "No pudo guardarse el usuario", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Ingrese una edad valida", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarCampos(){
        et_nombre.setText("");
        et_clave.setText("");
        et_edad.setText("");
    }
}