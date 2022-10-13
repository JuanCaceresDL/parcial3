package com.example.parcial3.model;

import com.example.parcial3.api.ApiClient;
import com.example.parcial3.api.MoviesApi;
import com.example.parcial3.bean.Movie;
import com.example.parcial3.bean.json;
import com.example.parcial3.presenter.IMoviePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieModel implements IMovieModel {

    private IMoviePresenter presenter;
    private MoviesApi api;

    public MovieModel(IMoviePresenter presenter) {
        this.presenter = presenter;
        api = ApiClient.getInstance().create(MoviesApi.class);
    }

    @Override
    public void getMovies() {
        Call<json> bookCall = api.getMovies();
        bookCall.enqueue(new Callback<json>() {
            @Override
            public void onResponse(Call<json> call, Response<json> response) {
                presenter.onMovieSuccess(response.body().movies);
            }

            @Override
            public void onFailure(Call<json> call, Throwable t) {
                presenter.onMovieError("Error el obtener las peliculas");
            }
        });
    }
}
