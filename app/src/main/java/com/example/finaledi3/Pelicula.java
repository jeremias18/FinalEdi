package com.example.finaledi3;

public class Pelicula {
    private String Nombre;
    private Integer EdadMinima;

    Pelicula(int edadMinima, String nombre){
        this.Nombre = nombre;
        this.EdadMinima = edadMinima;
    }

    public String getNombre(){
        return Nombre;
    }

    public Integer getEdadMinima(){
        return EdadMinima;
    }

    public Integer getEdadMaxima(){
        Integer edadMax = Global.obtenerRangoEdad(EdadMinima);
        return edadMax;
    }
}
