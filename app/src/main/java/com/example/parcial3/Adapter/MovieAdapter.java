package com.example.parcial3.Adapter;

import android.content.Context;
import android.graphics.Movie;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> mMovie;
    private Context context;

    public MovieAdapter(List<Movie> mMovie) {
        this.mMovie= mMovie;
    }

    public void reloadData(List<Movie> movies) {
        this.mMovie = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(this.context);

        View contactView = inflater.inflate(R.layout.item_book, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Movie movie = mMovie.get(position);

        // Set item views based on your views and data model
        holder.mBookName.setText(movie.mTitle);
        holder.mBookAuthor.setText(movie.mAuthor);
        Glide.with(this.context).load(movie.mImageUrl).into(holder.mBookImage);
    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mBookImage;
        private TextView mBookName;
        private TextView mBookAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mBookImage = itemView.findViewById(R.id.book_image);
            mBookName = itemView.findViewById(R.id.book_name);
            mBookAuthor = itemView.findViewById(R.id.book_author);

            // itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

}
