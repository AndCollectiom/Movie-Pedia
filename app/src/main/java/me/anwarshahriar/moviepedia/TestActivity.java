package me.anwarshahriar.moviepedia;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.List;
import me.anwarshahriar.moviepedia.adapters.MovieAdapter;
import me.anwarshahriar.moviepedia.databinding.ActivityTestBinding;
import me.anwarshahriar.moviepedia.rest.MovieService;
import me.anwarshahriar.moviepedia.models.Movie;
import me.anwarshahriar.moviepedia.models.MoviesByDate;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TestActivity extends AppCompatActivity {
    RecyclerView rvMovie;
    ObservableArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_test);

        init();

        binding.setMovies(movies);
    }

    private void init() {
        movies = new ObservableArrayList<Movie>();

        Picasso.with(getApplicationContext()).setIndicatorsEnabled(true);

        rvMovie = (RecyclerView) findViewById(R.id.rvMovie);
        rvMovie.setLayoutManager(new LinearLayoutManager(this));

        fetchComingSoonMovies();
    }

    private void fetchComingSoonMovies() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://www.myapifilms.com/imdb").build();
        MovieService movieService = restAdapter.create(MovieService.class);
        movieService.getComingSoonMovies(new Callback<List<MoviesByDate>>() {
            @Override
            public void success(List<MoviesByDate> moviesByDates, Response response) {
                for (MoviesByDate item : moviesByDates) {
                    movies.addAll(item.getMovies());
                }
                MovieAdapter adapter = new MovieAdapter(movies);
                rvMovie.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "Unexpected error occured", Toast.LENGTH_LONG).show();
            }
        });
    }
}