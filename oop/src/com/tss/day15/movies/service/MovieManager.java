package com.tss.day15.movies.service;

import com.tss.day15.movies.exception.CapacityFullException;
import com.tss.day15.movies.exception.NoSuchMovieFoundException;
import com.tss.day15.movies.model.Movie;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class MovieManager {
    protected static List<Movie> moviesList;
    protected static final int MAX_MOVIES=5;
    private static final String MOVIE_PATH="data.bin";


    static {
        loadMovies();
    }

    protected static void loadMovies() {
        File file = new File(MOVIE_PATH);
        if (!file.exists()) {
            moviesList = new ArrayList<>();
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            moviesList = (List<Movie>) ois.readObject();
        } catch (Exception e) {
            moviesList = new ArrayList<>();
        }
    }

    protected static void addMovie(String name, int year, String genre) {
        if (moviesList.size() >= MAX_MOVIES) {
            throw new CapacityFullException("Maximum number of movies achieved");
        }
        int id = generateUniqueMovieId();
        Movie movie = new Movie(id, name, year, genre);
        moviesList.add(movie);
//        saveMovies();
    }

    protected static void clearMovies(){
        moviesList.clear();
    }

    public static List<Movie> getMovies(){
        return moviesList;
    }

    protected static void saveMovies(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(MOVIE_PATH))) {
            oos.writeObject(moviesList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void deleteAll(){
        clearMovies();
        saveMovies();
    }
//    public static boolean isFull() {
//        return moviesList != null && moviesList.size() >= MAX_MOVIES;
//    }
    protected static Movie findMovieById(int movieId) {
        if (moviesList == null || moviesList.isEmpty()) {
            throw new NoSuchMovieFoundException("No movies available");
        }
        for (Movie movie : moviesList) {
            if (movie.getId() == movieId) {
                return movie;
            }
        }
        throw new NoSuchMovieFoundException("Movie with ID " + movieId + " not found");
    }

    protected static void displayAllMovieIds() {
        if (moviesList == null || moviesList.isEmpty()) {
            System.out.println("No movie IDs available");
            return;
        }
        System.out.println("Available Movie IDs:");
        for (Movie movie : moviesList) {
            System.out.println("• " + movie.getId());
        }
    }

    protected static void deleteMovieById(int movieId) {
        if (moviesList == null || moviesList.isEmpty()) {
            throw new NoSuchMovieFoundException("No movies available to delete");
        }
        for (int i = 0; i < moviesList.size(); i++) {
            if (moviesList.get(i).getId() == movieId) {
                moviesList.remove(i);
//                saveMovies();
                return;
            }
        }
        throw new NoSuchMovieFoundException("Movie with ID " + movieId + " not found");
    }

    protected static void setMovieDetail(int movieId, String newName, int newYear, String newGenre) {
        if (moviesList == null || moviesList.isEmpty()) {
            throw new NoSuchMovieFoundException("No movies available to update");
        }
        for (Movie movie : moviesList) {
            if (movie.getId() == movieId) {
                movie.setName(newName);
                movie.setYear(newYear);
                movie.setGenre(newGenre);
//                saveMovies();
                return;
            }
        }
        throw new NoSuchMovieFoundException("Movie with ID " + movieId + " not found");
    }

    private static int generateUniqueMovieId() {
        Random random = new Random();
        int id = 0;
        int finalId = id;
        do {
            id = 100 + random.nextInt(900);
        } while (moviesList.stream().anyMatch(m -> m.getId() == finalId));
        return id;
    }
}
