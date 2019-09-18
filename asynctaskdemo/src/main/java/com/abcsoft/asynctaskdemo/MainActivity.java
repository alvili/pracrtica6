package com.abcsoft.asynctaskdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText tiempo;
    private TextView resultadoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiempo = (EditText) findViewById(R.id.idTiempo);
        button = (Button) findViewById(R.id.idBotonIniciar);
        resultadoFinal = (TextView) findViewById(R.id.idResultadoFinal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MiAsynkTask miAsynkTask = new MiAsynkTask();
                String sleepTime = tiempo.getText().toString();
                miAsynkTask.execute(sleepTime);
            }
        });

    }

    //Clase interna para definir  la AsynkTask

        private class MiAsynkTask extends AsyncTask <String,String,String> {

            ProgressDialog progressDialog;
            String respuesta;

            @Override
            protected String doInBackground(String... parametros) {

                try{
                    //parsear el tiempo
                    int tiempo = Integer.parseInt(parametros[0]) * 1000;

                    publishProgress("1","2");
                    Thread.sleep(tiempo);
                    //publishProgress("Siesta 1 completada");
                    publishProgress("2","2");
                    Thread.sleep(tiempo);
                    //publishProgress("Siesta 2 completada");

                    respuesta = "Hemos dormido " + tiempo  + " segundos";

                } catch (Exception e){
                    respuesta = "Algo ha ido mal";
                }
                return respuesta;
            }


            //Metodo de inicialización. Se ejecuta antes de que la tarea se inicie
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog= ProgressDialog.show(
                        MainActivity.this,
                        "Toca esperar",
                        "Esperamos " + tiempo.getText() +" segundos"
                );
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //La s recoge el valor que devuelve doInBackground

                //quito el grogress dialog
                progressDialog.dismiss();

                //pongo el resultado en un textView de la main activity
                resultadoFinal.setText(s);
            }


            @Override
            protected void onProgressUpdate(String... values) {
                super.onProgressUpdate(values);

                //Este update lo podemos pintar en algun sitio
                Log.d("**update",values[0]);

                String mensaje = "Siesta " + values[0] + " de " + values[1];
                progressDialog.setMessage(mensaje);

            }
        }




}
