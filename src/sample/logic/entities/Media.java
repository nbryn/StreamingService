package sample.logic.entities;

public abstract class Media {

    private String name;
    private Genre genre;
    private int year;
    private double rating;


    public Media(String name, int year, Genre genre, double rating) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getName() {
        return this.name;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public int getYear() {
        return this.year;
    }

    public double getRating() {
        return this.rating;
    }
}
