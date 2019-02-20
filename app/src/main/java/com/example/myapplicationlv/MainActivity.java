package com.example.myapplicationlv;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button btnMostrar, btnGuardar;
    ArrayList<Persona> personas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        personas.addAll(cargarShared(personas,"datos",this));
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        btnMostrar=(Button) findViewById(R.id.btnMostrar);
        btnGuardar=(Button)findViewById(R.id.btnGuardar);

        SharedPreferences preferences=this.getSharedPreferences("datos", Context.MODE_PRIVATE);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et1.getText().toString().isEmpty() && et2.getText().toString().isEmpty()){

                    Toast.makeText(getApplicationContext(), "Error campos vacios",Toast.LENGTH_LONG).show();
                }
                else {
                    Persona p1 = new Persona(et1.getText().toString(), et2.getText().toString(), personas.size());//creamos persona
                    personas.add(p1);//añadimos al arraylist
                    et1.setText("");
                    et2.setText("");
                }
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent paso = new Intent(getApplicationContext(), SegubdaActivity.class);
                Bundle b=new Bundle();
                b.putSerializable("lista",personas);//importante
                paso.putExtras(b);
                startActivity(paso);

            }
        });


    }
    private ArrayList cargarShared(ArrayList<Persona> personitas,String nombreShared, Context context){

        SharedPreferences preferences=this.getSharedPreferences(nombreShared, Context.MODE_PRIVATE);
       for(int i = 0; true; i++){
           String nombre = preferences.getString("a" + i,"");
           String numero = preferences.getString("b"+ i, "");
           String codigo = preferences.getString("c"+ i, "");
           if(nombre.equals("")){
               break;
           }
           else{
               Persona p = new Persona(nombre,numero,Integer.parseInt(codigo));
               personitas.add(p);
           }
       }return personitas;
    }
}
