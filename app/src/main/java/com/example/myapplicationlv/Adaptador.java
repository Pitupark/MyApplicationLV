package com.example.myapplicationlv;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adaptador extends BaseAdapter {

    private Context miContexto;
    private List<Persona> miArrayList;

    public Adaptador(Context miContexto, List<Persona> miArrayList){
        this.miContexto=miContexto;
        this.miArrayList=miArrayList;

    }



    public int getCount() {
        return miArrayList.size();
    }


    public Object getItem(int position) {
        return miArrayList.get(position);
    }

    public long getItemId(int position) {
        return miArrayList.get(position).getCodigo();
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(miContexto);
        convertView = layoutInflater.inflate(R.layout.item, null);


        TextView nombre=(TextView)convertView.findViewById(R.id.tvNom);
        TextView descripcion=(TextView)convertView.findViewById(R.id.tvDes);
        ImageView foto=(ImageView)convertView.findViewById(R.id.imgFot);




        nombre.setText(miArrayList.get(position).getNombre());
        descripcion.setText(miArrayList.get(position).getNumero());
        //foto.setImageResource(miArrayList.get(position).getFoto());


        return convertView;
    }
}
