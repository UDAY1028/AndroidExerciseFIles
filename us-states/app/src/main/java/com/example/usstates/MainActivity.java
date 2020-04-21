package com.example.usstates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    String[] state = new String[] { "AK - Alaska",
            "AL - Alabama",
            "AR - Arkansas",
            "AS - American Samoa",
            "AZ - Arizona",
            "CA - California",
            "CO - Colorado",
            "CT - Connecticut",
            "DC - District of Columbia",
            "DE - Delaware",
            "FL - Florida",
            "GA - Georgia",
            "GU - Guam",
            "HI - Hawaii",
            "IA - Iowa",
            "ID - Idaho",
            "IL - Illinois",
            "IN - Indiana",
            "KS - Kansas",
            "KY - Kentucky",
            "LA - Louisiana",
            "MA - Massachusetts",
            "MD - Maryland",
            "ME - Maine",
            "MI - Michigan",
            "MN - Minnesota",
            "MO - Missouri",
            "MS - Mississippi",
            "MT - Montana",
            "NC - North Carolina",
            "ND - North Dakota",
            "NE - Nebraska",
            "NH - New Hampshire",
            "NJ - New Jersey",
            "NM - New Mexico",
            "NV - Nevada",
            "NY - New York",
            "OH - Ohio",
            "OK - Oklahoma",
            "OR - Oregon",
            "PA - Pennsylvania",
            "PR - Puerto Rico",
            "RI - Rhode Island",
            "SC - South Carolina",
            "SD - South Dakota",
            "TN - Tennessee",
            "TX - Texas",
            "UT - Utah",
            "VA - Virginia",
            "VI - Virgin Islands",
            "VT - Vermont",
            "WA - Washington",
            "WI - Wisconsin",
            "WV - West Virginia",
            "WY - Wyoming"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, state);

        autoCompleteTextView.setAdapter(adapter);
    }
}