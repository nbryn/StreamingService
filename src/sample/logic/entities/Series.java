package sample.logic.entities;

import java.util.List;
import java.util.Map;

public class Series extends Media {

    private Map<Integer, Integer> seasons;

    public Series(String name, int year, List<String> genre, double rating, Map seasons) {
        super(name, year, genre, rating);

        this.seasons = seasons;
    }

    public Map<Integer, Integer> getSeasons() {
        return this.seasons;
    }

    @Override
    public String toString() {

        return "Series: Name: " + super.getName() + " Year: " + super.getYear() + " Genre: " + super.getGenre() + " Rating: " + super.getRating();
    }
}
