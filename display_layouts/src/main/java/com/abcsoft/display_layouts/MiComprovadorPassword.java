package com.abcsoft.display_layouts;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

public class MiComprovadorPassword extends LinearLayout {

    private String password;
    private EditText editText;
    private TextView textView;


    @RequiresApi(api = Build.VERSION_CODES.N)
    public MiComprovadorPassword(Context context, AttributeSet attrs) {
        super(context, attrs);

        //Inflar el layout
        LayoutInflater inflater = ((Activity) context).getLayoutInflater(); //Downcasting
        inflater.inflate(R.layout.mi_comprovador_password_layout,this);

        //Obtener la referencia a las views
        textView = (TextView) findViewById(R.id.idTextViewPwd);
        editText = (EditText) findViewById(R.id.idEditTextPwd);

        password=String.valueOf(editText.getText());
        textView.setText(password);
        evaluarPassword();

        editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    password = s.toString();
                    evaluarPassword();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            }
        );

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void evaluarPassword(){

        int puntuacion = 0 ;
        String[] caracteres_especiales = {" ","#","@","?"};


//        if (Arrays.stream(caracteres_especiales).anyMatch( "password"::equals)){
//            puntuacion++;
//        }

        if ((password != null)
                && (!password.equals(""))){
            puntuacion++;
        }

        //Longitud mínima
        if ((password != null)
                && (!password.equals(""))
                && (password.length() > 4 )) {
            puntuacion++;
        }

        //Caracteres raros
        if ((password != null)
                && (!password.equals(""))
                && (password.matches(".*[^0-9a-zA-Z].*"))){
            puntuacion++;
        }

        //TODO No repeticion
//        if ((password != null)
//                && (!password.equals(""))
//                && (password.matches("^(?!.*(\\w)\\1{3,}).+$"))){
//            puntuacion++;
//        }







        pintar(puntuacion);
    }

    private void pintar(int puntuacion){
        switch (puntuacion) {
            case 0: textView.setText("");
                break;
            case 1: textView.setText("weak");
                break;
            case 2: textView.setText("medium");
                break;
            case 3: textView.setText("strong");
                break;
        }
    }


}
