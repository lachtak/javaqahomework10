package ru.netology.manager;

import ru.netology.poster.MoviePoster;

public class PosterManager {
    private MoviePoster[] movies = new MoviePoster[0];
    private int maxPosters;

    public PosterManager() {
        this.maxPosters = 5;
    }

    public PosterManager(int size) {
        this.maxPosters = size;
    }

    public void savePoster(MoviePoster movie) {
        MoviePoster[] tmp = new MoviePoster[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public MoviePoster[] findAll() {
        return movies;
    }

    public MoviePoster[] findLast() {
        int resultLength;
        if (movies.length < maxPosters) {
            resultLength = movies.length;
        } else {
            resultLength = maxPosters;
        }

        MoviePoster[] tmp = new MoviePoster[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - 1 - i];
        }
        return tmp;
    }

}