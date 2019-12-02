package sample.data.mock;

import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;
import sample.logic.interfaces.MediaMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MockMediaMapper implements MediaMapper {

    private List<Media> media;

    public MockMediaMapper() {
        media = new ArrayList<>();
        media.add(new Movie("God", 1992, "Horror", 9.2));
        media.add(new Movie("Hejsa", 1994, "Adventure", 8.2));
        media.add(new Movie("Luppe", 1991, "Crime", 6.2));
        media.add(new Movie("Tab", 2011,"Documentary", 4.2));
        media.add(new Movie("SQL", 1991, "Family", 7.2));
        media.add(new Movie("DTW", 1991, "Biography", 2.2));

        Map<Integer, Integer> gotSeasons = new HashMap<>();
        gotSeasons.put(1, 10);
        gotSeasons.put(2, 5);

        Map<Integer, Integer> mafiaSeasons = new HashMap<>();
        gotSeasons.put(1, 8);
        gotSeasons.put(2, 7);

        Map<Integer, Integer> blueCollarSeasons = new HashMap<>();
        blueCollarSeasons.put(1, 6);
        blueCollarSeasons.put(2, 9);

        media.add(new Series("GoT", 2011, "History", 9.2, gotSeasons));
        media.add(new Series("Mafia", 1991, "Talkshow", 7.2, mafiaSeasons));
        media.add(new Series("Blue Collar", 1991, "Thriller", 2.2, blueCollarSeasons));
    }

    @Override
    public Media get(int id) {
        return null;
    }

    @Override
    public List<Media> getAll() {
        return media;
    }

    @Override
    public List<Media> getAllMovies( ) {
        List<Media> movies = media.stream()
                .filter(media -> media instanceof Movie)
                .collect(Collectors.toList());


        return movies;
    }

    @Override
    public List<Media> getAllSeries() {
        List<Media> series = media.stream()
                .filter(media -> media instanceof Series)
                .collect(Collectors.toList());

        return series;

    }

    @Override
    public List<Media> getAllWithRatingOver(double rating) {
        List<Media> result = media.stream()
                .filter(media -> media.getRating() > rating)
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Media> getAllSeriesWithRatingOver(double rating) {
        List<Media> temp = media.stream()
                .filter(media -> media.getRating() > rating)
                .collect(Collectors.toList());

        List<Media> result = temp.stream()
                .filter(media -> media instanceof Series)
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Media> getAllMoviesWithRatingOver(double rating) {
        List<Media> temp = media.stream()
                .filter(media -> media.getRating() > rating)
                .collect(Collectors.toList());

        List<Media> result = temp.stream()
                .filter(media -> media instanceof Movie)
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Media> getAllFromGenre(String genre) {
        List<Media> result = media.stream()
                .filter(media -> media.getGenre() == genre)
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Media> getAllMoviesFromGenre(String genre) {
        List<Media> temp = media.stream()
                .filter(media -> media.getGenre() == genre)
                .collect(Collectors.toList());

        List<Media> result = temp.stream()
                .filter(media -> media instanceof Movie)
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Media> getAllSeriesFromGenre(String genre) {
        List<Media> temp = media.stream()
                .filter(media -> media.getGenre() == genre)
                .collect(Collectors.toList());

        List<Media> result = temp.stream()
                .filter(media -> media instanceof Series)
                .collect(Collectors.toList());

        return result;
    }


}
