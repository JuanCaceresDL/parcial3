package com.example.parcial3.presenter;

import com.example.parcial3.View.IMovieView;
import com.example.parcial3.bean.Movie;
import com.example.parcial3.model.MovieModel;
import com.example.parcial3.model.IMovieModel;

import java.util.List;

public class MoviePresenter implements IMoviePresenter {

    private IMovieView view;
    private IMovieModel model;

    public MoviePresenter(IMovieView view) {
        this.view = view;
        this.model = new MovieModel(this);
    }

    @Override
    public void getMovies() {
        this.model.getMovies();
    }

    @Override
    public void onMovieSuccess(List<Movie> movies) {
        if (view == null)
            return;

        this.view.onMovieSuccess(movies);
    }

    @Override
    public void onMovieError(String msg) {
        if (view == null)
            return;

        this.view.onMovieError(msg);

    }
}
