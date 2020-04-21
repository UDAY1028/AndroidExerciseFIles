package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewDicy;
    private ImageView imageViewDicer;
    private ImageView btn;
    private Random myRandomNumber = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageViewDicy = findViewById(R.id.imageView);
        imageViewDicer = findViewById(R.id.imageView2);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollOurDIcer();
                   rollOurDIce();

            }
        });



    }


    private void rollOurDIce() {
        int myRanNumber = (myRandomNumber.nextInt(6) + 1);
        switch (myRanNumber) {
            case 1:
                imageViewDicy.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageViewDicy.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageViewDicy.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageViewDicy.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageViewDicy.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageViewDicy.setImageResource(R.drawable.dice6);


        }
    }
            private void rollOurDIcer () {
                int myRandNumber = (myRandomNumber.nextInt(6) + 1);
                switch (myRandNumber) {
                    case 1:
                        imageViewDicer.setImageResource(R.drawable.dicer1);
                        break;
                    case 2:
                        imageViewDicer.setImageResource(R.drawable.dicer2);
                        break;
                    case 3:
                        imageViewDicer.setImageResource(R.drawable.dicer3);
                        break;
                    case 4:
                        imageViewDicer.setImageResource(R.drawable.dicer4);
                        break;
                    case 5:
                        imageViewDicer.setImageResource(R.drawable.dicer5);
                        break;
                    case 6:
                        imageViewDicer.setImageResource(R.drawable.dicer6);
                        break;
                    default:

                        break;
                }
            }
        }

