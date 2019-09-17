package com.abcsoft.customeventsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomObject customObject = new CustomObject();
        customObject.setMyCustomObjectListener(new CustomObject.MyCustomObjectListener() {
            @Override
            public void onDataLoaded(String data) {
                Log.d("**",data);

            }

            @Override
            public void onDataLoaded2(CustomObject customObject) {
                Log.d("**", customObject.getClass().getName());
            }
        });


        //Si la implementacion és la misma para todos, la puedo definir en una variable i pasarla luego por seteo
        CustomObject.MyCustomObjectListener listener = new CustomObject.MyCustomObjectListener() {
            @Override
            public void onDataLoaded(String data) {
                Log.d("**",data);
            }

            @Override
            public void onDataLoaded2(CustomObject customObject) {
                Log.d("**", customObject.getClass().getName());

            }
        };

        CustomObject co1 = new CustomObject("Pepín");
        CustomObject co2 = new CustomObject("Honorio");
        CustomObject co3 = new CustomObject("Carlota");

        co1.setMyCustomObjectListener(listener);
        co2.setMyCustomObjectListener(listener);
        co3.setMyCustomObjectListener(listener);


//        Button button = new Button(null);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Button causante = (Button) v;
//            }
//        });
    }
}
