package com.example.finaledi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPeliculas extends RecyclerView.Adapter<AdaptadorPeliculas.ViewHolderPeliculas> {

    ArrayList<Pelicula> ListaPeliculas;

    public AdaptadorPeliculas(ArrayList<Pelicula> listaPeliculas, Integer edadMax){
        this.ListaPeliculas = new ArrayList<>();

        for(int i = 0; i < listaPeliculas.size(); i++){
            Integer edadMaximaPelicula = listaPeliculas.get(i).getEdadMaxima();
            if(edadMax >= edadMaximaPelicula){
                this.ListaPeliculas.add(listaPeliculas.get(i));
            }
        }
    }

    @Override
    public ViewHolderPeliculas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_peliculas, parent, false);
        return new ViewHolderPeliculas(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorPeliculas.ViewHolderPeliculas holder, int position) {
        String nombre = ListaPeliculas.get(position).getNombre();
        String edad = ListaPeliculas.get(position).getEdadMinima().toString();
        holder.etEdad.setText(edad);
        holder.etNombre.setText(nombre);
    }

    @Override
    public int getItemCount() {
        return ListaPeliculas.size();
    }

    public class ViewHolderPeliculas extends RecyclerView.ViewHolder {
        TextView etNombre, etEdad;

        public ViewHolderPeliculas(View itemView) {
            super(itemView);
            etNombre = itemView.findViewById(R.id.idNombre);
            etEdad = itemView.findViewById(R.id.idEdad);
        }
    }
}
