package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void shouldReturnEmptyIfNoMovies() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneMovie() {
        MovieManager manager = new MovieManager();

        manager.add("Terminator");

        String[] expected = {"Terminator"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSeveralMovies() {
        MovieManager manager = new MovieManager();

        manager.add("Terminator");
        manager.add("Saw 2");
        manager.add("Saw 3");

        String[] expected = {"Terminator", "Saw 2", "Saw 3"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithDefaultLimit() {
        MovieManager manager = new MovieManager(); // лимит 5

        manager.add("M1");
        manager.add("M2");
        manager.add("M3");
        manager.add("M4");
        manager.add("M5");
        manager.add("M6");

        String[] expected = {"M6", "M5", "M4", "M3", "M2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenLessThanLimit() {
        MovieManager manager = new MovieManager(); // лимит 5

        manager.add("A");
        manager.add("B");
        manager.add("C");

        String[] expected = {"C", "B", "A"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithCustomLimit() {
        MovieManager manager = new MovieManager(3);

        manager.add("movie1");
        manager.add("movie2");
        manager.add("movie3");
        manager.add("movie4");

        String[] expected = {"movie4", "movie3", "movie2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenMoviesEqualLimit() {
        MovieManager manager = new MovieManager(4);

        manager.add("M1");
        manager.add("M2");
        manager.add("M3");
        manager.add("M4");

        String[] expected = {"M4", "M3", "M2", "M1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenLimitIsOne() {
        MovieManager manager = new MovieManager(1);

        manager.add("A");
        manager.add("B");
        manager.add("C");

        String[] expected = {"C"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
