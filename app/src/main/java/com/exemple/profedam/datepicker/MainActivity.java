package com.exemple.profedam.datepicker;





    import java.text.SimpleDateFormat;
    import java.util.Calendar;
    import java.util.Locale;

    import android.app.Activity;
    import android.app.DatePickerDialog;
    import android.app.DatePickerDialog.OnDateSetListener;
    import android.content.Intent;
    import android.os.Bundle;
    import android.text.InputType;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.DatePicker;
    import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener, OnDateSetListener {



        //UI References
        private EditText fromDateEtxt;
        private DatePickerDialog fromDatePickerDialog;
        public final int REQUEST_CODE = 560;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            /* Inicializamos el EditText y pedimos el focus */
            fromDateEtxt = (EditText) findViewById(R.id.etxt_fromdate);
            fromDateEtxt.setInputType(InputType.TYPE_NULL);
            fromDateEtxt.requestFocus();

            /* Ponemos el Listener al EditText */
            fromDateEtxt.setOnClickListener(this);
            /* Creamos el DatePickerDialog a partir de la fechaActual */
            Calendar newCalendar = Calendar.getInstance();
            fromDatePickerDialog = new DatePickerDialog(this, this, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
            /* El constructor del DatePickerDialog accepta per paràmetres
               1. El context (o l'Activity on és llençat)
               2. L'objecte que el "vigila" i que implementa la interfície onDateSetListener
               3. Any, mes i dia del calendar que es mostren per defecte
             */
            Button Calcularbtn = (Button) findViewById(R.id.button2);
            Calcularbtn.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {
            if(view == fromDateEtxt) {
                fromDatePickerDialog.show();
            }else{
                EditText text1 = (EditText) findViewById(R.id.etxt_fromdate);

                Intent intent = new Intent (this, Main2Activity.class);
                EditText text = (EditText) findViewById(R.id.editText);
                String string = text.getText().toString();
                intent.putExtra("nombre", string);
                EditText text2 = (EditText) findViewById(R.id.etxt_fromdate);
                String string2 = text2.getText().toString();
                intent.putExtra("fecha", string2);


                // startActivity(intent);

                startActivityForResult(intent, REQUEST_CODE);
            }
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


            Calendar newDate = Calendar.getInstance();
            newDate.set(year, month, dayOfMonth);
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

            fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));

        }
    }