package me.anwarshahriar.moviepedia.rest;

import java.util.List;
import me.anwarshahriar.moviepedia.models.MoviesByDate;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by U on 6/5/2015.
 */
public interface MovieService {
    @GET("/comingSoon")
    public void getComingSoonMovies(Callback<List<MoviesByDate>> movies);
}