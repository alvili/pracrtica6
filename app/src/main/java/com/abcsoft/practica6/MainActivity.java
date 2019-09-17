package com.abcsoft.practica6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos datos
        List<Registro> registros = new ArrayList<>();

        registros.add(new Registro("Barcelona", 29));
        registros.add(new Registro("Madrid", 31));
        registros.add(new Registro("Valencia", 27));
        registros.add(new Registro("Murcia", 26));
        registros.add(new Registro("Sevilla", 33));
        registros.add(new Registro("Oviedo", 25));
        registros.add(new Registro("Salamanca", 26.9));

        ListViewAdapter miAdapter = new ListViewAdapter(this, registros);

        ListView listView = (ListView) findViewById(R.id.idListView);

        listView.setAdapter(miAdapter);


    }
}
