package sample.logic.entities;

import java.util.List;

public class Movie extends Media {

    public Movie(String name, int release, double rating) {
        super(name, release, rating);
    }

    @Override
    public String toString() {

        return "Movie: Name: " + super.getName() + " Year: " + super.getRelease() + " Genre: " + super.getGenre() + " Rating: " + super.getRating();
    }
}
