package com.example.parcial3.api;

import com.example.parcial3.bean.Movie;
import com.example.parcial3.bean.json;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApi {
    @GET("/erik-sytnyk/movies-list/master/db.json")
    Call<json> getMovies();
}
