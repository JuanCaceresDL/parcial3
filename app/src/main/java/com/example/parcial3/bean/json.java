package com.example.parcial3.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class json {
    @SerializedName("movies")
    public List<Movie> movies;
}
