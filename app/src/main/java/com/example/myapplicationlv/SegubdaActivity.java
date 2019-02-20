package com.example.myapplicationlv;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SegubdaActivity extends AppCompatActivity {

    ListView lv1;
    Adaptador adaptador;
    ArrayList<Persona> personas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segubda);


        lv1=(ListView)findViewById(R.id.lv1);
        recibirDatos();//llamada al metodo de recibir

       guardarDatos(personas,"datos");

        //String nombre = getIntent().getStringExtra("lista");
        //SHARED PREFERENCES

        adaptador=new Adaptador(this, personas);
        lv1.setAdapter(adaptador);



    }

    private void  recibirDatos(){
        Bundle objetoEnviado=getIntent().getExtras();//importante
        if(objetoEnviado!=null){

            personas= (ArrayList<Persona>) objetoEnviado.getSerializable("lista");


        }

    }
    private void guardarDatos(ArrayList<Persona> personita,String nombreShared){

        if(nombreShared!="") {
            SharedPreferences preferences = getSharedPreferences(nombreShared, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
           for(int i = 0; i< personita.size(); i++ ) {
                editor.putString("a" + i, personita.get(i).getNombre());
                editor.putString("b" + i, personita.get(i).getNumero());
                editor.putString("c" + i, personita.get(i).getCodigo() + "");
            }
            editor.commit();

            Toast.makeText(getApplicationContext(), "clave creada", Toast.LENGTH_SHORT).show();


        }
    }
}
