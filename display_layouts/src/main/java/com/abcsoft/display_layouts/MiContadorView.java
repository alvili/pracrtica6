package com.abcsoft.display_layouts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MiContadorView  extends LinearLayout {

    private int valor = 0;

    private TextView textView;
    private Button incrButton;
    private Button decrButton;


    public MiContadorView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //Inflar el layout
        LayoutInflater inflater = ((Activity) context).getLayoutInflater(); //Downcasting
        inflater.inflate(R.layout.mi_contador_view_layout,this);

        //Obtener la referencia a las views
        textView = (TextView) findViewById(R.id.idValor);
        incrButton = (Button) findViewById(R.id.idIncrButton);
        decrButton = (Button) findViewById(R.id.idDecrButton);

//        valor=0;
//        textView.setText(String.valueOf(valor));

        //Añadimos listener en incrementar
        incrButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementar();
            }
        });

        //Añadimos listener en decrementar
        decrButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementar();
            }
        });

    }

    public void setValor(int valor){
        this.valor = valor;
        pintar();
    }

    void incrementar(){
        valor++;
        pintar();
    }

    void decrementar(){
        valor--;
        pintar();
    }

    void pintar(){
        textView.setTextColor( (valor < 0 ) ? Color.RED : Color.BLACK);
        textView.setText(String.valueOf(valor));

//        Or if you have defined color code in resource's color.xml file than
//
//        (From API >= 23)
//        mTextView.setTextColor(ContextCompat.getColor(context, R.color.<name_of_color>));
//
//        (For API < 23)
//        mTextView.setTextColor(getResources().getColor(R.color.<name_of_color>));
//        Definir los colores en values/colors.xml
    }

}
