package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.Bundle;

import com.example.parcial3.Adapter.MovieAdapter;
import com.example.parcial3.api.MoviesApi;
import com.example.parcial3.presenter.MoviePresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter adapter;
    private MoviesApi api;
    private MoviePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.movie_list);
        this.adapter = new MovieAdapter(new ArrayList<>());
        rvBooks.setAdapter(adapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
    }
    Call<List<Movie>> bookCall = api.getMovies();
        bookCall.enqueue(new Callback<List<Movie>>() {
        @Override
        public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
            presenter.onBooksSuccess(response.body());
        }

        @Override
        public void onFailure(Call<List<Movie>> call, Throwable t) {
            presenter.onBooksError("Error el obtener los libros");
        }
    });

}