package sample.logic.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Media {

    private String name;
    private List<String> genres;
    private int release;
    private double rating;


    public Media(String name, int release, double rating) {
        this.name = name;
        this.release = release;
        this.rating = rating;

        genres = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<String> getGenre() {
        return this.genres;
    }

    public int getRelease() {
        return this.release;
    }

    public double getRating() {
        return this.rating;
    }

    public void addGenre(String genre) {
        genres.add(genre);
    }
}
