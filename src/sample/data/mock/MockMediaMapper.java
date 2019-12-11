package sample.data.mock;

import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;
import sample.logic.interfaces.MediaMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MockMediaMapper implements MediaMapper {

    private List<Media> allMedia;

    public MockMediaMapper() {
        allMedia = new ArrayList<>();
        Movie saw = new Movie("Saw", 1992, 9.2);
        saw.addGenre("Horror");

        allMedia.add(saw);

        Movie hood = new Movie("Robin Hood", 1994, 8.2);
        hood.addGenre("Adventure");
        allMedia.add(hood);

        Movie anna = new Movie("Anna", 1991, 6.2);
        anna.addGenre("Crime");
        allMedia.add(anna);

        Series got = new Series("GoT", 2011, "2011-2019", 9.2);
        got.addGenre("History");
        got.addSeason(1, 10);
        got.addSeason(2, 5);

        Series mafia = new Series("Mafia", 1991, "1991-2002", 7.2);
        mafia.addGenre("Crime");
        mafia.addSeason(1, 8);
        mafia.addSeason(2, 7);

        Series collar = new Series("Blue Collar", 1991, "2000-2010", 2.2);
        collar.addGenre("Thriller");
        collar.addSeason(1, 6);
        collar.addSeason(2, 9);

        allMedia.add(got);
        allMedia.add(mafia);
        allMedia.add(collar);
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
                    .filter(ms -> name.equalsIgnoreCase(ms.getTitle()))
                    .collect(Collectors.toList());
        } else {
            result = allMedia.stream()
                    .filter(ms -> media.equalsIgnoreCase(ms.getTitle()))
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
    public List<Media> getByRelease(int release, String media) {
        List<Media> result;
        if (media.equalsIgnoreCase("all")) {
            result = allMedia.stream()
                    .filter(ms -> ms.getRelease() == release)
                    .collect(Collectors.toList());
        } else {
            result = allMedia.stream()
                    .filter(ms -> ms.getRating() == release)
                    .filter(ms -> ms.getClass().getName().equalsIgnoreCase(media))
                    .collect(Collectors.toList());
        }
        return result;
    }

    @Override
    public List<Media> getUserList(String username) {
        return null;
    }

}
