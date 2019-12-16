package streaming.logic.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Media {

    private String title;
    private List<String> genres;
    private int release;
    private double rating;


    public Media(String title, int release, double rating) {
        this.title = title;
        this.release = release;
        this.rating = rating;

        genres = new ArrayList<>();
    }

    public String getTitle() {
        return this.title;
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