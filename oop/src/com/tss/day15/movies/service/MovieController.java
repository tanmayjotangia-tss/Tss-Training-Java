package com.tss.day15.movies.service;

import com.tss.day15.movies.exception.CapacityFullException;
import com.tss.day15.movies.model.Movie;
import com.tss.utils.InputUtil;

public class MovieController {


    public void start() {

        while (true) {
            displayMenu();
            int choice = InputUtil.readInt("Enter your choice: ");

            switch (choice) {
                case 0 -> displayMovieList();
                case 1 -> displayMoviesFromFile();
                case 2 -> addMovies();
                case 3 -> deleteAllMovies();
                case 4 -> viewMovieById();
                case 5 -> updateMovieById();
                case 6 -> deleteMovieById();
                case 7 -> clearMovieList();
                case 8 -> loadMovieFromList();
                case 9 -> saveMovieOnFile();
                case 10 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Enter valid choice");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMovie Management System");
        System.out.println("0. Display MovieList");
        System.out.println("1. Display Movies from File");
        System.out.println("2. Add Movie");
        System.out.println("3. Delete All Movies");
        System.out.println("4. View Movie By ID");
        System.out.println("5. Update Movie By ID");
        System.out.println("6. Delete Movie By ID");
        System.out.println("7. Clear List");
        System.out.println("8. Load Movies from File");
        System.out.println("9. Save Movie to File");
        System.out.println("10. Exit");
    }

    private void addMovies() {
        try {
            while (true) {
                String movieName = InputUtil.readString("Enter movie name: ");
                int movieYear = InputUtil.readInt("Enter movie release year: ");
                String movieGenre = InputUtil.readString("Enter movie genre: ");

                MovieManager.addMovie(movieName, movieYear, movieGenre);
                System.out.println("Movie added successfully!!");

                if(!InputUtil.createNext()) return;
            }
        } catch (CapacityFullException e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayMoviesFromFile() {
        loadMovieFromList();
        if (MovieManager.getMovies() == null || MovieManager.getMovies().isEmpty()) {
            System.out.println("No movies found");
            return;
        }
        System.out.println("---- Movie List Present in File ----");
        for (Movie movie : MovieManager.getMovies()) {
            System.out.println(movie);
            System.out.println("--------------------");
        }
    }

    private void displayMovieList() {
        if (MovieManager.getMovies() == null || MovieManager.getMovies().isEmpty()) {
            System.out.println("No movies found");
            return;
        }
        System.out.println("---- Movie List ----");
        for (Movie movie : MovieManager.getMovies()) {
            System.out.println(movie);
            System.out.println("--------------------");
        }
    }

    private void deleteAllMovies() {
        MovieManager.deleteAll();
    }

    private void viewMovieById() {
        try {
            MovieManager.displayAllMovieIds();
            int id = InputUtil.readInt("Enter movie ID to view: ");

            Movie movie = MovieManager.findMovieById(id);
            System.out.println("---- Movie Details ----");
            System.out.println(movie);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateMovieById() {
        try {
            MovieManager.displayAllMovieIds();
            int id = InputUtil.readInt("Enter movie ID to update: ");

            String newName = InputUtil.readString("Enter new movie name: ");
            int newYear = InputUtil.readInt("Enter new release year: ");
            String newGenre = InputUtil.readString("Enter new genre: ");

            MovieManager.setMovieDetail(id, newName, newYear, newGenre);
            System.out.println("Movie updated successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteMovieById() {
        try {
            MovieManager.displayAllMovieIds();
            int id = InputUtil.readInt("Enter movie ID to delete: ");

            MovieManager.deleteMovieById(id);
            System.out.println("Movie deleted successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void saveMovieOnFile() {
        MovieManager.saveMovies();
        System.out.println("File Updated successfully");
    }

    private void  clearMovieList() {
        MovieManager.clearMovies();
        System.out.println("Movie List cleared successfully");
    }

    private void loadMovieFromList(){
        MovieManager.loadMovies();
        System.out.println("Movie List loaded successfully");
    }
}
