package sample.logic.entities;

import java.util.List;

public class Movie extends Media {

    public Movie(String name, int year, List<String> genre, double rating) {
        super(name, year, genre, rating);
    }

    @Override
    public String toString()
    {
        return "Movie: Name: " + super.getName() + " Year: " + super.getYear() + " Genre: " + super.getGenre() + " Rating: " + super.getRating();
    }
}
