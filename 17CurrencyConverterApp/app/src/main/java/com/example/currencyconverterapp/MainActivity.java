package com.example.currencyconverterapp;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button euro, usdollar, pound, qatar, uae, bitcoin, swiss, ausdollar, candollar;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euro = findViewById(R.id.euro);
        usdollar = findViewById(R.id.usdollar);
        pound = findViewById(R.id.pound);
        qatar = findViewById(R.id.qatar);
        uae = findViewById(R.id.uae);
        bitcoin = findViewById(R.id.bitcoin);
        swiss = findViewById(R.id.swiss);
        ausdollar = findViewById(R.id.ausdollar);
        candollar = findViewById(R.id.candollar);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        euro.setOnClickListener(
                new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                 String z = editText.getText().toString();

                 if (TextUtils.isEmpty(z)) {
                     editText.setError("Empty User Input");
                 }
                else {
                    double n, k;

                     n = Double.parseDouble(z);
                     editText.setText(null);
//                   Formatter formatter = new Formatter();
                     k = n * 0.0012;
                     DecimalFormat numberFormat = new DecimalFormat("#.0000");
                     textView.setText(""+numberFormat.format(k));
//                   textView.setText(""+k);
                 }
            }
        });
        usdollar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                String usdollar = editText.getText().toString();

                if(TextUtils.isEmpty(usdollar)) {
                    editText.setError("Empty user input");
                } else {
                    double n, k;
                    n = Double.parseDouble(usdollar);
                    editText.setText(null);
                    k = n * 0.013;

                    DecimalFormat decimalFormat = new DecimalFormat("#0.0000");
                    textView.setText(""+ decimalFormat.format(k));
                }
            }
        });
       pound.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("SetTextI18n")
           @RequiresApi(api = Build.VERSION_CODES.N)
           @Override
           public void onClick(View v) {

               String z = editText.getText().toString();

               if (TextUtils.isEmpty(z)) {
                   editText.setError("Empty User Input");
               } else {
                   double n,k;

                   n = Double.parseDouble(z);
                   editText.setText(null);
                   k = n * 0.011;

                   DecimalFormat numberFormat = new DecimalFormat("#0.0000");
                       textView.setText(""+ numberFormat.format(k));
               }
           }
       });
       qatar.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.N)
           @Override
           public void onClick(View view) {
               String  qatar = editText.getText().toString();

               if (TextUtils.isEmpty(qatar)) {
                   editText.setError("Empty User Input");
               } else {
                    double n,k;

                    n = Double.parseDouble(qatar);
                    editText.setText(null);
                    k = n * 0.048;

                    DecimalFormat numberFormat = new DecimalFormat("#0.0000");
                    textView.setText(""+numberFormat.format(k));
               }
           }
       });
       uae.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.N)
           @Override
           public void onClick(View v) {
               String uae = editText.getText().toString();

               if (TextUtils.isEmpty(uae)) {
                   editText.setError("Empty User Input");
               } else {
                   double q, b;
                   q = Double.parseDouble(uae);
                   editText.setText(null);
                   b = q * 0.049;

                   DecimalFormat numberformat = new DecimalFormat("#0.0000");
                   textView.setText(""+numberformat.format(b));
               }
           }

       });
       bitcoin.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.N)
           @Override
           public void onClick(View v) {
               String money = editText.getText().toString();

               if (TextUtils.isEmpty(money)) {
                   editText.setError("Empty User Input");
               } else {
                   double i, k;
                   i = Double.parseDouble(money);
                   editText.setText(null);
                   k = i * 0.0000021;

                   DecimalFormat numberformat = new DecimalFormat("#0.0000");
                   textView.setText(""+numberformat.format(k));

               }
           }
       });

       swiss.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.N)
           @Override
           public void onClick(View v) {
               String c = editText.getText().toString();

               if (TextUtils.isEmpty(c)) {
                   editText.setError("Empty User Input");
               } else {
                   Double i, j;

                   i = Double.parseDouble(c);
                   editText.setText(null);
                   j = i * 0.013;

                   DecimalFormat numberformat = new DecimalFormat("#0.0000");
                   textView.setText(""+numberformat.format(j));


               }
           }
       });
       ausdollar.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.N)
           @Override
           public void onClick(View v) {
                  String q = editText.getText().toString();

                  if (TextUtils.isEmpty(q)) {
                      editText.setError("Empty User Input");
                  } else {
                      Double z, x;

                      z = Double.parseDouble(q);
                      editText.setText(null);
                      x = z * 0.022;

                      DecimalFormat numberformat = new DecimalFormat("#0.0000");
                          textView.setText(""+numberformat.format(x));
                  }
           }
       });
       candollar.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.N)
           @Override
           public void onClick(View v) {
               String t = editText.getText().toString();

               if(TextUtils.isEmpty(t)) {
                   editText.setError("Empty User Input");
               } else {
                   Double f, j;

                   f = Double.parseDouble(t);
                   editText.setText(null);
                   j = f * 0.019;

                   DecimalFormat numberformat = new DecimalFormat("#0.0000");
                        textView.setText(String.format("" + numberformat.format(j)));
               }
           }
       });
    }
}
