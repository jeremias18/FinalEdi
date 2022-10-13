package com.example.finaledi3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.EditText;
import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    ArrayList<Pelicula> ListaPeliculas;
    private EditText et_nombre, et_edad, et_rangoEdad;
    RecyclerView recyclerPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        et_nombre = findViewById(R.id.txt_nombreUsuario);
        et_edad = findViewById(R.id.txt_edadUsuario);
        et_rangoEdad = findViewById(R.id.txt_rangoEdad);
        et_nombre.setFocusable(false);
        et_edad.setFocusable(false);
        et_rangoEdad.setFocusable(false);

        et_nombre.setText(getIntent().getStringExtra("Nombre"));
        et_edad.setText(getIntent().getStringExtra("Edad"));
        Integer edad = Integer.parseInt(getIntent().getStringExtra("Edad"));
        Integer edadMax = Global.obtenerRangoEdad(edad);
        setRangoEdad(edadMax);

        ListaPeliculas = new ArrayList<>();
        recyclerPeliculas = findViewById(R.id.RecyclerPelicula);
        recyclerPeliculas.setLayoutManager(new LinearLayoutManager(this));

        CargarLista();

        AdaptadorPeliculas adapter = new AdaptadorPeliculas(ListaPeliculas, edadMax);
        recyclerPeliculas.setAdapter(adapter);

        //Filtrar lista de peliculas segun la edad
    }

    public void setRangoEdad(Integer i){
        if (i <= Global.MaxEdadNinio){
            et_rangoEdad.setText("0 - " + Global.MaxEdadNinio);
        }else if (i <= Global.MaxEdadAdolescente){
            et_rangoEdad.setText("0 - " + Global.MaxEdadAdolescente);
        }else{
            et_rangoEdad.setText("+" + (Global.MaxEdadAdolescente + 1));
        }
    }

    public void CargarLista(){
        ListaPeliculas.add(new Pelicula(13, "El padrino (1972)"));
        ListaPeliculas.add(new Pelicula(1, "El mago de Oz (1939)"));
        ListaPeliculas.add(new Pelicula(1, "Ciudadano Kane (1941)"));
        ListaPeliculas.add(new Pelicula(13, "Cadena perpetua (1994)"));
        ListaPeliculas.add(new Pelicula(18, "Pulp Fiction (1994)"));
        ListaPeliculas.add(new Pelicula(18, "Malditos Bastardos (2009)"));
        ListaPeliculas.add(new Pelicula(16, "Casablanca (1942)"));
        ListaPeliculas.add(new Pelicula(18, "El padrino: Parte II (1974)"));
        ListaPeliculas.add(new Pelicula(7, "E.T., el extraterrestre (1982)"));
        ListaPeliculas.add(new Pelicula(1, "2001: Una odisea del espacio (1968)"));
        ListaPeliculas.add(new Pelicula(13, "La lista de Schindler (1993)"));
        ListaPeliculas.add(new Pelicula(10, "Star Wars: Episodio IV - Una nueva esperanza (1977)"));
        ListaPeliculas.add(new Pelicula(1, "Regreso al futuro (1985)"));
        ListaPeliculas.add(new Pelicula(13, "En busca del arca perdida (1981)"));
        ListaPeliculas.add(new Pelicula(7, "Coco (2017)"));
        ListaPeliculas.add(new Pelicula(16, "El Lobo de Wall Street (2013)"));
        ListaPeliculas.add(new Pelicula(7, "Intocable (2011)"));
        ListaPeliculas.add(new Pelicula(12, "Origen (2010)"));
    }
}