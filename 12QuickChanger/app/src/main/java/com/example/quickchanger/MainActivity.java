package com.example.quickchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

     RelativeLayout layout;
     RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        radioGroup = findViewById(R.id.rgroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                switch (checkedID) {
                    case R.id.bbtnblue:
                    layout.setBackgroundColor(Color.parseColor("#74B9FF"));
                    break;
                    case R.id.gbtnblue:
                    layout.setBackgroundColor(Color.parseColor("#45CE30"));
                    break;
                    case R.id.rbtnblue:
                    layout.setBackgroundColor(Color.parseColor("#FF3E4D"));
                    break;

                }
            }
        });



    }
}
