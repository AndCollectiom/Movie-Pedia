package me.anwarshahriar.moviepedia.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by U on 6/3/2015.
 */
public class Movie {
    @SerializedName("urlPoster")
    private String poster;

    @SerializedName("title")
    private String title;

    @SerializedName("year")
    private String year;

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPoster() {
        return poster;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }
}