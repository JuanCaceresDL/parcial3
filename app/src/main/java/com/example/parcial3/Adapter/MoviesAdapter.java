package com.example.parcial3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.parcial3.R;
import com.example.parcial3.bean.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<Movie> mMovies;
    private Context context;

    public MoviesAdapter(List<Movie> mMovies) {
        this.mMovies = mMovies;
    }

    public void reloadData(List<Movie> books) {
        this.mMovies = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(this.context);

        View contactView = inflater.inflate(R.layout.item_movie, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
        Movie movie = mMovies.get(position);

        // Set item views based on your views and data model
        holder.mMovieName.setText(movie.mTitle);
        holder.mMovieDirector.setText(movie.mDirector);
        holder.mMovieActors.setText(movie.mActors);
        holder.mMovieYear.setText(movie.mDirector);
        holder.mMoviePlot.setText(movie.mPlot);
        Glide.with(this.context).load(movie.mImageUrl).into(holder.mMovieImage);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mMovieImage;
        private TextView mMovieName;
        private TextView mMovieDirector;
        private TextView mMovieYear;
        private TextView mMovieActors;
        private TextView mMoviePlot;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mMovieImage = itemView.findViewById(R.id.movie_image);
            mMovieName = itemView.findViewById(R.id.movie_name);
            mMovieDirector = itemView.findViewById(R.id.movie_director);
            mMovieYear = itemView.findViewById(R.id.movie_year);
            mMovieActors = itemView.findViewById(R.id.movie_actors);
            mMoviePlot = itemView.findViewById(R.id.movie_plot);

            // itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}

