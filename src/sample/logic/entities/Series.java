package sample.logic.entities;

import java.util.Map;

public class Series extends Media {

    private Map<Integer, Integer> seasons;

    public Series(String name, int year, String genre, double rating, Map seasons) {
        super(name, year, genre, rating);

        this.seasons = seasons;
    }

    public Map<Integer, Integer> getSeasons() {
        return this.seasons;
    }
}
