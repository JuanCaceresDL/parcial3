package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.parcial3.Adapter.MoviesAdapter;
import com.example.parcial3.View.IMovieView;
import com.example.parcial3.bean.Movie;
import com.example.parcial3.presenter.MoviePresenter;
import com.example.parcial3.presenter.IMoviePresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMovieView {

    private IMoviePresenter moviePresenter;
    private MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvMovies = (RecyclerView) findViewById(R.id.movie_list);
        this.adapter = new MoviesAdapter(new ArrayList<>());
        rvMovies.setAdapter(adapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        this.moviePresenter = new MoviePresenter(this);
        this.moviePresenter.getMovies();
    }

    @Override
    public void onMovieSuccess(List<Movie> movie) {
        adapter.reloadData(movie);
    }

    @Override
    public void onMovieError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG)
                .show();
    }
}