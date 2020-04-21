package com.example.jsonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();
//        Student student = new Student("Uday",5,"uday@.com");
//        String json = gson.toJson(student);

//          List<Video> videos = new ArrayList<>();
//
//          videos.add(new Video("Intro", 4));
//          videos.add(new Video("Excercise files", 8));
//          videos.add(new Video("uday", 2));

//      Course course = new Course("Java", "BootCamp");
//      Student  student = new Student("Uday", 3,"Uday.in", course, videos);
//      String json = gson.toJson(student);

//        String json = "{\"Course_count\":3,\"email\":\"Uday.in\",\"course\":{\"description\":\"BootCamp\",\"name\":\"Java\"},\"name\":\"Uday\"}";
//        Student student = gson.fromJson(json, Student.class);

//      Log.d("TEST", student.toString());
//      Log.d("TEST", json);


        String json = "{\n" +
                "  \"Course_count\": 3,\n" +
                "  \"email\": \"Uday.in\",\n" +
                "  \"course\": {\n" +
                "    \"description\": \"BootCamp\",\n" +
                "    \"name\": \"Java\"\n" +
                "  },\n" +
                "  \"video\": [\n" +
                "    {\n" +
                "      \"duration\": 4,\n" +
                "      \"name\": \"Intro\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"duration\": 8,\n" +
                "      \"name\": \"Excercise files\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"duration\": 2,\n" +
                "      \"name\": \"uday\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": \"Uday\"\n" +
                "}";

         Student student = gson.fromJson(json, Student.class);

         Log.d("TEST", student.toString());


//
    }
}
