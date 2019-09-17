package com.abcsoft.customeventsdemo;

import java.util.Timer;
import java.util.TimerTask;

public class CustomObject {

    //Definicion del listener (es una clase interna)
    public interface MyCustomObjectListener{
        public void onDataLoaded(String data); //Es comun que se llamen on...
        public void onDataLoaded2(CustomObject customObject);
    }

    private MyCustomObjectListener listener; //Variable de instancia que almacena la implementacion del listener
    private String nombre;
    private CustomObject customObject;

    //Constrructor
    public CustomObject(){
        this.listener = null; //innecesario

        //Ponemos en marcha la tarea asíncrona
        tareaAsincrona();
    }

    public CustomObject(String nombre){
        this.listener = null; //innecesario
        this.nombre = nombre;
        this.customObject = this;

        //Ponemos en marcha la tarea asíncrona
        tareaAsincrona();
    }

    public void setMyCustomObjectListener(MyCustomObjectListener listener){
        this.listener = listener;
    }

    private void tareaAsincrona(){
        //Provocamos la ejecución cíclica de código cada 3 segundos
        final int tiempoaleatorio = 1000 + (int) (Math.random() * 3000);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (listener != null) {
                    int numeroAleatorio = (int) (Math.random() * 1000);

                    //Disparamos
                    listener.onDataLoaded(nombre + ": (" +tiempoaleatorio + ")" + numeroAleatorio);
                    listener.onDataLoaded2(customObject);
                }
            }
        }, 0,tiempoaleatorio);
    }

}
