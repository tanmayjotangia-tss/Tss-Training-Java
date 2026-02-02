package com.tss.day15.movies.service;

import com.tss.day15.movies.exception.CapacityFullException;
import com.tss.day15.movies.model.Movie;
import com.tss.utils.InputUtil;

import static com.tss.day15.movies.service.MovieManager.*;

public class MovieController {
    private static MovieManager manager;

    public MovieController() {
        manager = new MovieManager();
    }

    public void start(){

        while(true){
            displayMenu();
            int choice = InputUtil.readInt("Enter your choice: ");
            switch(choice){
                case 1: displayMovies();
                    break;
                case 2: addMovies();
                    break;
                case 3: deleteAllMovies();
                    break;
                case 4:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Enter Valid choice");
            }
        }
    }

    private void deleteAllMovies() {
        manager.deleteAll();
    }

    private void addMovies() {
        if (MovieManager.isFull()) {
            System.out.println("Movie list is full. Please delete some movies first.");
            return;
        }

        int movieId = InputUtil.readInt("Enter movie id: ");
        String movieName = InputUtil.readString("Enter movie name: ");
        int movieYear = InputUtil.readInt("Enter movie release year: ");
        String movieGenre = InputUtil.readString("Enter movie genre: ");

        try {
            Movie movie = new Movie(movieId, movieName, movieYear, movieGenre);
            manager.addMovie(movie);
            System.out.println("Movie added successfully !!");
        } catch (CapacityFullException e) {
            // Safety net (rare race condition)
            System.out.println(e.getMessage());
        }
    }


    private void displayMovies() {
        if (manager.getMovies() == null || manager.getMovies().isEmpty()) {
            System.out.println("No movies found");
            return;
        }

        System.out.println("---- Movie List ----");
        for (Movie movie : manager.getMovies()) {
            System.out.println(movie);
            System.out.println("--------------------");
        }
    }


    private static void displayMenu(){
        System.out.println("Movie Management System");

        System.out.println("1. Display Movies");
        System.out.println("2. Add movies");
        System.out.println("3. Delete All Movies");
        System.out.println("4. Exit");
    }
}
