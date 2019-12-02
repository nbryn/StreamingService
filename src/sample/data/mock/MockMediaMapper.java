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

    private List<Media> allMedia;

    public MockMediaMapper() {
        allMedia = new ArrayList<>();
        List<String> sawGenre = new ArrayList<>();
        sawGenre.add("Horror");
        allMedia.add(new Movie("Saw", 1992, sawGenre, 9.2));
        List<String> hoodGenre = new ArrayList<>();
        hoodGenre.add("Adventure");
        allMedia.add(new Movie("Robin Hood", 1994, hoodGenre, 8.2));
        List<String> anneGenre = new ArrayList<>();
        anneGenre.add("Crime");
        allMedia.add(new Movie("Anna", 1991, anneGenre, 6.2));


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


        allMedia.add(new Series("GoT", 2011, gotGenre, 9.2, gotSeasons));
        allMedia.add(new Series("Mafia", 1991, mafiaGenre, 7.2, mafiaSeasons));
        allMedia.add(new Series("Blue Collar", 1991, collarGenre, 2.2, blueCollarSeasons));
    }


    @Override
    public List<Media> getAll() {
        return allMedia;
    }

    @Override
    public List<Media> getMovies() {
        List<Media> movies = allMedia.stream()
                .filter(media -> media instanceof Movie)
                .collect(Collectors.toList());

        return movies;
    }

    @Override
    public List<Media> getSeries() {
        List<Media> series = allMedia.stream()
                .filter(media -> media instanceof Series)
                .collect(Collectors.toList());

        return series;
    }

    @Override
    public List<Media> getByName(String name, String media) {
        List<Media> result;
        if (media.equalsIgnoreCase("all")) {
            result = allMedia.stream()
                    .filter(ms -> media.equalsIgnoreCase(ms.getName()))
                    .collect(Collectors.toList());
        } else {
            result = allMedia.stream()
                    .filter(ms -> media.equalsIgnoreCase(ms.getName()))
                    .filter(ms -> ms.getClass().getName().equalsIgnoreCase(media))
                    .collect(Collectors.toList());
        }
        return result;
    }

    @Override
    public List<Media> getByRating(double rating, String media) {
        List<Media> result;
        if (media.equalsIgnoreCase("all")) {
            result = allMedia.stream()
                    .filter(ms -> ms.getRating() > rating)
                    .collect(Collectors.toList());
        } else {
            result = allMedia.stream()
                    .filter(ms -> ms.getRating() > rating)
                    .filter(ms -> ms.getClass().getName().equalsIgnoreCase(media))
                    .collect(Collectors.toList());
        }
        return result;
    }

    @Override
    public List<Media> getAllFromGenre(String genre, String media) {
        List<Media> result;
        if (media.equalsIgnoreCase("all")) {
            result = allMedia.stream()
                    .filter((ms) -> {
                        List<String> genres = ms.getGenre();
                        return genres.contains(genre);
                    })
                    .collect(Collectors.toList());
        } else {
            result = allMedia.stream()
                    .filter((ms) -> {
                        List<String> genres = ms.getGenre();
                        return genres.contains(genre);
                    })
                    .filter(ms -> ms.getClass().getName().equalsIgnoreCase(media))
                    .collect(Collectors.toList());
        }
        return result;
    }

    @Override
    public List<Media> getByRelease(int year, String media) {
        List<Media> result;
        if (media.equalsIgnoreCase("all")) {
            result = allMedia.stream()
                    .filter(ms -> ms.getYear() == year)
                    .collect(Collectors.toList());
        } else {
            result = allMedia.stream()
                    .filter(ms -> ms.getRating() == year)
                    .filter(ms -> ms.getClass().getName().equalsIgnoreCase(media))
                    .collect(Collectors.toList());
        }
        return result;
    }

}
