package com.example.aplicacioncontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

 EditText nombres ;

     DatePicker fecha;
      EditText telefono ;
      EditText mail ;
      EditText descripcion ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres =  (EditText) findViewById(R.id.nombres);
        fecha = (DatePicker) findViewById(R.id.fecha);


        telefono = (EditText) findViewById(R.id.telefono);
        mail = (EditText) findViewById(R.id.mail);
        descripcion = (EditText) findViewById(R.id.descripcion);
        String  fech;
        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            nombres.setText( parametros.getString("Nombres"));
            fech=parametros.getString("fecha");
            String[] separated = fech.split("/");
            fecha.init(Integer.parseInt(separated[2]), Integer.parseInt(separated[1])-1, Integer.parseInt(separated[0]), null);
              //  fecha.init(1989,10,6,null);

          //  fecha.setText( parametros.getString("Nombres"));
            telefono.setText( parametros.getString("tel"));
            mail.setText( parametros.getString("mail"));
            descripcion.setText( parametros.getString("des"));


        }

    }
    public static String getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(calendar.getTime());
    }

    public void Click(View view) {

        //Toast.makeText(getApplicationContext(), (fecha.getYear()), Toast.LENGTH_SHORT).show();
        Log.e("la fecha", ":"+getDateFromDatePicker(fecha));
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("nom",  nombres.getText().toString());
        intent.putExtra("dia", fecha.getDayOfMonth() );
        intent.putExtra("mes", fecha.getMonth() );
        intent.putExtra("año", fecha.getYear() );
        intent.putExtra("fecha",getDateFromDatePicker(fecha)  );
        intent.putExtra("tel",  telefono.getText().toString());
        intent.putExtra("mail",  mail.getText().toString());
        intent.putExtra("des",  descripcion.getText().toString());
        startActivity(intent);

    }
}