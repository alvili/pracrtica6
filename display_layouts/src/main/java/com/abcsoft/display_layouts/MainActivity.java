package com.abcsoft.display_layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MiContadorView miContador = (MiContadorView) findViewById(R.id.idContador);
        miContador.setValor(3);

        MiContadorLetrasView miContadorLetras = (MiContadorLetrasView) findViewById(R.id.idContadorLetras);

        MiComprovadorPassword miComprovadorPassword = (MiComprovadorPassword) findViewById(R.id.idComprobadorPassword);

    }
}
