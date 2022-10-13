package com.example.parcial3.presenter;

import com.example.parcial3.bean.Movie;

import java.util.List;

public interface IMoviePresenter {

    void getMovies();
    void onMovieSuccess(List<Movie> movies);
    void onMovieError(String msg);
}
