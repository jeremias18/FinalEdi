package com.example.finaledi3;

public class Global {
    public static Integer MaxEdadNinio = 12;
    public static Integer MaxEdadAdolescente = 17;

    public static Integer obtenerRangoEdad(Integer i){
        Integer edadMax = 0;
        if (i < Global.MaxEdadNinio){
            edadMax = Global.MaxEdadNinio;
        }else if (i < Global.MaxEdadAdolescente){
            edadMax = Global.MaxEdadAdolescente;
        }else{
            edadMax = 200;
        }
        return edadMax;
    }
}

