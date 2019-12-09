package sample.logic.entities;

import java.util.List;

public abstract class Media {

    private String name;
    private List<String> genre;
    private int year;
    private double rating;

    public Media(String name, int year, List<String> genre, double rating) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getGenre() {
        return this.genre;
    }

    public int getYear() {
        return this.year;
    }

    public double getRating() {
        return this.rating;
    }
}