package com.example.mybutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    Button button;
//    Button bluebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button = findViewById(R.id.mybtn);
//        bluebutton = findViewById(R.id.bluebutton);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                Log.d("TEST", "Clicked");

               // blue button
//        bluebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("BLUE", "blueClicked");
//            }
//        });

            }

//        });

//    }

    public void bluePressed(View view) {
//        Log.d("BLUE", "Clicked via method");

//        Context context = getApplicationContext();
//        String text = "Hello from blue";
//        int duration = Toast.LENGTH_SHORT;
//
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();

        Toast.makeText(getApplicationContext(), "Hello from blue.", Toast.LENGTH_SHORT).show();


    }

    public void redPressed(View v) {


    }




}
