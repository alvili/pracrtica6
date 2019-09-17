package com.abcsoft.practica6;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MiDisplayView extends LinearLayout {

    private TextView celsiusTextView;
    private TextView fahrenheitTextView;
    private TextView cityTextView;

//    public MiDisplayView(Context context) {
//        super(context);
//    }

//    public MiDisplayView(Context context, @androidx.annotation.Nullable AttributeSet attrs) {
    public MiDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //Inflar el layout
        LayoutInflater inflater = ((Activity) context).getLayoutInflater(); //Downcasting
        inflater.inflate(R.layout.mi_display_layout,this);

        //Obtener la referencia a las views
        celsiusTextView = (TextView) findViewById(R.id.idCelsiusTextView);
        fahrenheitTextView = (TextView) findViewById(R.id.idFahrenheitTextView);
        cityTextView = (TextView) findViewById(R.id.idCityTextView);

        //Añadimos listener en el city
        cityTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void setCity(String city){
        cityTextView.setText(city);
    }

    public void setCelsius(double celsius){
        celsiusTextView.setText(String.valueOf(celsius));
        double fahrenheit = ( celsius * 9 / 5 ) + 32;
        fahrenheitTextView.setText(String.valueOf(fahrenheit));
    }

    public void setFahrenheit(double fahrenheit){
        fahrenheitTextView.setText(String.valueOf(fahrenheit));
        double celsius = fahrenheit - 32 * ( 5 / 9 );
        celsiusTextView.setText(String.valueOf(celsius));
    }



}
