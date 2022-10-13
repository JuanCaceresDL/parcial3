package com.example.parcial3.presenter;

import android.graphics.Movie;
import android.os.Message;

import java.util.List;

public interface iMoviePresenter {
    void getMovies();
    void getOnSuccess(List<Movie> movies);
    void getOnFailure(Message msg);
}
