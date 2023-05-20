package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.poster.MoviePoster;

public class PosterManagerTest {

    MoviePoster movie1 = new MoviePoster("A New Hope");
    MoviePoster movie2 = new MoviePoster("The Empire Strikes Back");
    MoviePoster movie3 = new MoviePoster("Return of the Jedi");
    MoviePoster movie4 = new MoviePoster("The Phantom Menace");
    MoviePoster movie5 = new MoviePoster("Attack of the Clones");
    MoviePoster movie6 = new MoviePoster("Revenge of the Sith");

    @Test
    public void shouldFindAllPosters() {
        PosterManager poster = new PosterManager();

        poster.savePoster(movie1);
        poster.savePoster(movie2);
        poster.savePoster(movie3);
        poster.savePoster(movie4);
        poster.savePoster(movie5);
        poster.savePoster(movie6);

        MoviePoster[] expected = {movie1, movie2, movie3, movie4, movie5, movie6};
        MoviePoster[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastPoster() {
        PosterManager poster = new PosterManager();

        poster.savePoster(movie1);
        poster.savePoster(movie2);
        poster.savePoster(movie3);
        poster.savePoster(movie4);
        poster.savePoster(movie5);
        poster.savePoster(movie6);


        MoviePoster[] expected = {movie6, movie5, movie4, movie3, movie2};
        MoviePoster[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastPosterWithCustomNumberOfPosters() {
        PosterManager poster = new PosterManager(3);

        poster.savePoster(movie1);
        poster.savePoster(movie2);
        poster.savePoster(movie3);
        poster.savePoster(movie4);
        poster.savePoster(movie5);
        poster.savePoster(movie6);

        MoviePoster[] expected = {movie6, movie5, movie4};
        MoviePoster[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMovieIfPostersLessThanMaxPoster() {
        PosterManager poster = new PosterManager(6);

        poster.savePoster(movie1);
        poster.savePoster(movie2);
        poster.savePoster(movie3);
        poster.savePoster(movie4);

        MoviePoster[] expected = {movie4, movie3, movie2, movie1};
        MoviePoster[] actual = poster.findLast();
    }
}