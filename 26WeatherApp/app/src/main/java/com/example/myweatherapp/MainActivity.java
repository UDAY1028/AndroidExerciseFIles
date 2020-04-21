package com.example.myweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText city;
    TextView result;
    private RequestQueue requestQueue;


    //http://api.openweathermap.org/data/2.5/weather?q=new%20york&APPID=6efd246670c9df52968a552b9270b851

    String baseURL = "http://api.openweathermap.org/data/2.5/weather?q=";
    String API = "&APPID=6efd246670c9df52968a552b9270b851";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);
        city = findViewById(R.id.getCity);
        result = findViewById(R.id.result);

        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendAPIRequest();
            }
        });

    }

    private void sendAPIRequest() {
        String myURL = baseURL + city.getText().toString() + API;
//                Log.i("URL", "URL: " + myURL);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, myURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                     String info = jsonObject.getString("weather");
//                     Log.i("INFO", "JSON: " + jsonObject);
                         JSONArray ar = new JSONArray(info);
                    for (int i = 0; i < ar.length(); i++) {
                        JSONObject parObj = ar.getJSONObject(i);
                        String myWeather = parObj.getString("main");
                        result.setText(myWeather);
//                        Log.i("ID", "INFO: " + info);
//                        Log.i("MAIN", "MAIN: " + parObj.getString("main"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    String coor = jsonObject.getString("coord");
                    JSONObject co = new JSONObject(coor);

                    String lon = co.getString("lon");
                    String lat = co.getString("lat");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(request);

    }
}
