package com.example.parcial3.View;

import com.example.parcial3.bean.Movie;

import java.util.List;

public interface IMovieView {

    void onMovieSuccess(List<Movie> books);
    void onMovieError(String msg);
}
