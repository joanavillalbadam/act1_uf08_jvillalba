package com.exemple.profedam.datepicker;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;
/*
* Aqui venimos de el otro activity junto con la variable del nombre que nos han introducido en la otra */
public class Main2Activity extends AppCompatActivity {


        private String[] myString;
         /*generamos un numero random*/
    private static final Random rgenerator = new Random();

        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       /*mostramos el nombre que nos han introducido por pantalla*/
        String inputString = getIntent().getStringExtra("nombre");
        TextView view = (TextView) findViewById(R.id.textView);
        view.setText(inputString);

/* mediante el numero random que hemos creado al principio de la clase
 * cojemos la posicion 'random' de el array muertes1 y lo mostramos por pantalla */
        Resources res = getResources();
        myString = res.getStringArray(R.array.muertes1);
        String q = myString[rgenerator.nextInt(myString.length)];
        TextView tex = (TextView) findViewById(R.id.textView6);
        tex.setText(q);

    }
}
