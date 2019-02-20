package com.example.myapplicationlv;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleActivity extends AppCompatActivity {

    ImageView imagen;
    TextView titulo, descripcion;
    Button btn1;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        imagen = (ImageView) findViewById(R.id.iv1);
        titulo = (TextView) findViewById(R.id.tvTitulo);
        descripcion = (TextView) findViewById(R.id.tvTitulo2);
        btn1 = (Button) findViewById(R.id.btn1);


        Persona can = (Persona) getIntent().getExtras().getSerializable("objeto");
        titulo.setText(can.getNombre());
        descripcion.setText(can.getNumero());
        //imagen.setImageResource(can.getFoto());

        //mp=MediaPlayer.create(this, can.getSonido());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()) {
                    mp.pause();
                    btn1.setBackgroundResource(R.drawable.play);
                    Toast.makeText(DetalleActivity.this, "Pausa", Toast.LENGTH_SHORT).show();
                } else {
                    mp.start();
                    btn1.setBackgroundResource(R.drawable.pause);
                    Toast.makeText(DetalleActivity.this, "Play", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
