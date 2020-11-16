package com.example.aplicacioncontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView Enombres ;
    TextView Efecha ; TextView Etel ;
    TextView Email ;
    TextView Edes ;
    String dia;
    String mes;
    String ano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Enombres = (TextView) findViewById(R.id.Enombres);
        Efecha = (TextView) findViewById(R.id.Efecha);
        Etel = (TextView) findViewById(R.id.Etel);
        Email = (TextView) findViewById(R.id.Email);
        Edes = (TextView) findViewById(R.id.Edes);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){

            Enombres.setText( parametros.getString("nom"));
            dia=parametros.getString("dia");
            mes=parametros.getString("mes");
           ano=parametros.getString("año");

            Efecha.setText(parametros.getString("fecha"));
            Etel.setText( parametros.getString("tel"));
            Email.setText( parametros.getString("mail"));
            Edes.setText( parametros.getString("des"));

        }
        //  String nombres;
        //nombres = getIntent().getExtras().getString("nom");

       // Enombres.setText( parametros.getString("Nombres"));

    }

    public void ClickEdi(View view) {
      //  Enombres = (TextView) findViewById(R.id.Enombres);
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        intent.putExtra("Nombres", Enombres.getText());


        intent.putExtra("fecha", Efecha.getText());
        intent.putExtra("tel", Etel.getText());
        intent.putExtra("mail", Email.getText());
        intent.putExtra("des", Edes.getText());





        startActivity(intent);


    }
}