package com.exemple.profedam.datepicker;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {


        private String[] myString;
    private static final Random rgenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String inputString = getIntent().getStringExtra("nombre");
        TextView view = (TextView) findViewById(R.id.textView);
        view.setText(inputString);


        Resources res = getResources();
        myString = res.getStringArray(R.array.muertes1);
        String q = myString[rgenerator.nextInt(myString.length)];
        TextView tex = (TextView) findViewById(R.id.textView6);
        tex.setText(q);

    }

   /* @Override
    public void finish() {

        Intent intent = new Intent();
        TextView tvTexto = (TextView) findViewById(R.id.textView5);
        intent.putExtra("saludo", tvTexto.getText().toString());
        setResult(this.RESULT_OK, intent);

        super.finish();
    }*/
}