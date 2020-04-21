package com.example.jsonproject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student {

    private String name;
    @SerializedName("Course_count")
    private int Coursecount;
    private  String email;

    @SerializedName("course")
    private Course mCourse;

    @SerializedName("video")
    private List<Video> mVideo;

    public Student(String name, int course_count, String email, Course course, List<Video> Video) {
        this.name = name;
        this.Coursecount = course_count;
        this.email = email;
        mCourse = course;
        mVideo = Video;
    }

}
