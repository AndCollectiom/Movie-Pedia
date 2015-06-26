package me.anwarshahriar.moviepedia.adapters;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.anwarshahriar.moviepedia.BR;
import me.anwarshahriar.moviepedia.R;
import me.anwarshahriar.moviepedia.databinding.MovieItemBinding;
import me.anwarshahriar.moviepedia.models.Movie;

/**
 * Created by U on 6/4/2015.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.BindingHolder> {
    private List<Movie> movies;

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        BindingHolder holder = new BindingHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final Movie aMovie = movies.get(position);
        holder.getBinding().setVariable(BR.movie, aMovie);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}