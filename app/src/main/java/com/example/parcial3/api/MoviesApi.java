package com.example.parcial3.api;

import android.graphics.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApi {
    @GET("/erik-sytnyk/movies-list/master/db.json")
    Call<List<Movie>> getMovies();
}
