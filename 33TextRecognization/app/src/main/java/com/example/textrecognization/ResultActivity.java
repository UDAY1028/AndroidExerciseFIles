package com.example.textrecognization;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Button backbutton;
    private TextView resultTextView;
    private String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        backbutton = findViewById(R.id.back_button);
        resultTextView = findViewById(R.id.result_textview);
        resultText = getIntent().getStringExtra(TextRecognization.RESULT_TEXT);

        resultTextView.setText(resultText);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }
}
