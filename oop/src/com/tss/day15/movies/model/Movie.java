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

    @Override
    public String toString() {
        String result = ("Id: " + id + "\nName: " + name + "\nYear: " + year + "\nGenre: " + genre);
        return result;
    }
}
