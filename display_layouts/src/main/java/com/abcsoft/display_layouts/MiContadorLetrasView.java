package com.abcsoft.display_layouts;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MiContadorLetrasView extends LinearLayout {

    public EditText editText;
    public TextView textView;

    public MiContadorLetrasView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //Inflar el layout
        LayoutInflater inflater = ((Activity) context).getLayoutInflater(); //Downcasting
        inflater.inflate(R.layout.mi_contador_letras_view_layout,this);

        //Obtener la referencia a las views
        textView = (TextView) findViewById(R.id.idTextView);
        editText = (EditText) findViewById(R.id.idEditText);

        textView.setText(String.valueOf(editText.getText().length()));

        editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    textView.setText(String.valueOf(s.length()));
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            }
        );

    }
}
