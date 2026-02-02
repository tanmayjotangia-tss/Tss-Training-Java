package com.tss.day15.movies.service;

import com.tss.day15.movies.exception.CapacityFullException;
import com.tss.day15.movies.model.Movie;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class MovieManager {
    protected static List<Movie> moviesList;
    protected static final int MAX_MOVIES=5;
    private static final String MOVIE_PATH="data.bin";

    public MovieManager() {
        loadMovies();
    }

    private static void loadMovies() {
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


    protected static void addMovie(Movie movie)throws CapacityFullException {
        if(moviesList == null){
            moviesList = new ArrayList<>();
        }
        if(moviesList.size() >= MAX_MOVIES){
            throw new CapacityFullException("Maximum number of movies acheived");
        }
        moviesList.add(movie);
        saveMovies();
    }
    private static void clearMovies(){
        moviesList.clear();
    }

    public static List<Movie> getMovies(){
        return moviesList;
    }

    private static void saveMovies(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(MOVIE_PATH))) {
            oos.writeObject(moviesList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void deleteAll(){
        clearMovies();
        saveMovies();
    }
    public static boolean isFull() {
        return moviesList != null && moviesList.size() >= MAX_MOVIES;
    }

}
