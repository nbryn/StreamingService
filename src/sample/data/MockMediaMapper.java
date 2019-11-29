package sample.data;

import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;
import sample.logic.interfaces.MediaMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MockMediaMapper implements MediaMapper {

    private List<Media> media;

    public MockMediaMapper() {
        media = new ArrayList<>();
        media.add(new Movie("God", 1992, "Horror", 9.2));
        media.add(new Movie("Hejsa", 1994, "Horror", 8.2));
        media.add(new Movie("Luppe", 1991, "Horror", 6.2));
        media.add(new Movie("Tab", 2011, "Drama", 4.2));
        media.add(new Movie("SQL", 1991, "HLTV", 7.2));
        media.add(new Movie("DTW", 1991, "Comedy", 2.2));
    }


    @Override
    public List<Media> getAll() {
        return media;
    }

    @Override
    public List<Media> getAllMovies() {

        List<Media> movies = media.stream()
                .filter(media -> media instanceof Movie)
                .collect(Collectors.toList());


        return movies;
    }

    @Override
    public List<Media> getAllSeries() {
        return null;
    }

    @Override
    public List<Media> getAllFromCategory(String category) {
        return null;
    }

    @Override
    public Media get(int id) {
        return null;
    }
}
