package me.anwarshahriar.moviepedia.models;

import java.util.List;

/**
 * Created by U on 6/5/2015.
 */
public class MoviesByDate {
    private String date;
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}