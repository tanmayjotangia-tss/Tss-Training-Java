package com.tss.day15.movies.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private int id,year;
    private String name,genre;

    public Movie(int id, String name, int year, String genre){
        this.id = id;
        this.name=name;
        this.year = year;
        this.genre=genre;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
        String result = ("Id: " + id + "\nName: " + name + "\nYear: " + year + "\nGenre: " + genre);
        return result;
    }
}
