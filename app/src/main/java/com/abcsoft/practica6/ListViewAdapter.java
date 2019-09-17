package com.abcsoft.practica6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    //Necesitamos datos
    private List<Registro> datos;
//    private Context context;
    private LayoutInflater inflater;

    public ListViewAdapter(Context context, List<Registro> datos) {
        this.datos = datos;
//        this.context = context;
        //Esto se llama solo una vez. por eso lo pongo en el constructor
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Si lo dejo aqui, se llamara cada vez que dibuje una row
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_layout, null);

        MiDisplayView miDisplayView = (MiDisplayView) view.findViewById(R.id.idMiDisplayLayout);
        Button button = (Button) view.findViewById(R.id.idButton);
        TextView textView = (TextView) view.findViewById(R.id.idTextView);

        Registro registro = datos.get(position);

        miDisplayView.setCity(registro.getCity());
        miDisplayView.setCelsius(registro.getCelsius());

        button.setText("boton_" + position);
        textView.setText("texto_" + position);

        return view;
    }
}
