package sample.data.mock;

import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;
import sample.logic.interfaces.MediaMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MockMediaMapper implements MediaMapper {

    private List<Media> media;

    public MockMediaMapper() {
        media = new ArrayList<>();
        List<String> sawGenre = new ArrayList<>();
        sawGenre.add("Horror");
        media.add(new Movie("Saw", 1992, sawGenre, 9.2));
        List<String> hoodGenre = new ArrayList<>();
        hoodGenre.add("Adventure");
        media.add(new Movie("Robin Hood", 1994, hoodGenre, 8.2));
        List<String> anneGenre = new ArrayList<>();
        anneGenre.add("Crime");
        media.add(new Movie("Anna", 1991, anneGenre, 6.2));


        Map<Integer, Integer> gotSeasons = new HashMap<>();
        gotSeasons.put(1, 10);
        gotSeasons.put(2, 5);
        List<String> gotGenre = new ArrayList<>();
        gotGenre.add("History");

        Map<Integer, Integer> mafiaSeasons = new HashMap<>();
        gotSeasons.put(1, 8);
        gotSeasons.put(2, 7);
        List<String> mafiaGenre = new ArrayList<>();
        mafiaGenre.add("Crime");

        Map<Integer, Integer> blueCollarSeasons = new HashMap<>();
        blueCollarSeasons.put(1, 6);
        blueCollarSeasons.put(2, 9);
        List<String> collarGenre = new ArrayList<>();
        collarGenre.add("Thriller");


        media.add(new Series("GoT", 2011, gotGenre, 9.2, gotSeasons));
        media.add(new Series("Mafia", 1991, mafiaGenre, 7.2, mafiaSeasons));
        media.add(new Series("Blue Collar", 1991, collarGenre, 2.2, blueCollarSeasons));
    }


    @Override
    public List<Media> getAll() {
        return media;
    }

    @Override
    public List<Media> getMovies() {
        return null;
    }

    @Override
    public List<Media> getSeries() {
        return null;
    }

    @Override
    public List<Media> getByName(String name, String media) {
        return null;
    }

    @Override
    public List<Media> getByRating(double rating, String media) {
        return null;
    }

    @Override
    public List<Media> getAllFromGenre(String genre, String media) {
        return null;
    }

    @Override
    public List<Media> getByRelease(int year, String media) {
        return null;
    }

}
