package sample.data;

import sample.data.setup.H2DataBase;
import sample.logic.entities.Media;
import sample.logic.interfaces.MediaMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLMediaMapper implements MediaMapper {
    private H2DataBase dataBase;

    public SQLMediaMapper() {
        dataBase = new H2DataBase("jdbc:h2:mem");
    }

    @Override
    public List<Media> getAll() {
        List<Media> allMedia = new ArrayList<>();
        List<Media> allMovies, allSeries = null;

        allMovies = dataBase.getMovies("SELECT * FROM movies");
        allSeries = dataBase.getSeries("SELECT * FROM series");

        allMedia.addAll(allMovies);
        allMedia.addAll(allSeries);
        return allMedia;
    }

    @Override
    public List<Media> getMovies() {
        return dataBase.getMovies("SELECT * FROM movies");
    }

    @Override
    public List<Media> getSeries() {
        return dataBase.getSeries("SELECT * FROM series");
    }

    @Override
    public List<Media> getByName(String name, String media) {
        return sendQuery("SELECT * FROM movies WHERE name  LIKE '%" + name + "%'", "SELECT * FROM series WHERE name LIKE '%" + name + "%'", media);
    }

    @Override

    public List<Media> getByRating(double rating, String media) {
        List<Media> allMedia = getAccordingToMedia(media);
        List<Media> mediaByRating = new ArrayList<>();

        for (Media mediaInternal: allMedia) if (mediaInternal.getRating() >= rating) mediaByRating.add(mediaInternal);

        return mediaByRating;

    }

    @Override
    public List<Media> getAllFromGenre(String genre, String media) {
        return sendQuery("SELECT * FROM movies WHERE genre LIKE '%" + genre + "%'", "SELECT * FROM series WHERE genre LIKE '%" + genre + "%'", media);

    }

    @Override
    public List<Media> getByRelease(int year, String media) {
        List<Media> allMedia = getAccordingToMedia(media);
        List<Media> mediaByRelease = new ArrayList<>();
        for (Media mediaInternal : allMedia) {
            if (mediaInternal.getRelease() >= year) mediaByRelease.add(mediaInternal);
        }
        return mediaByRelease;

    }

    private List<Media> sendQuery(String movieQuery, String seriesQuery, String media) {
        List<Media> allMedia = new ArrayList<>();
        List<Media> allMovies, allSeries = null;

        if (media.equalsIgnoreCase("movies")) {
            allMedia = dataBase.getMovies(movieQuery);

            if (allMedia != null) return allMedia;

        } else if (media.equalsIgnoreCase("series")) {
            allMedia = dataBase.getSeries(seriesQuery);

            if (allMedia != null) return allMedia;

        } else {
            allMovies = dataBase.getMovies(movieQuery);
            allSeries = dataBase.getSeries(seriesQuery);

            allMedia.addAll(allMovies);
            allMedia.addAll(allSeries);

            if (allMedia != null) return allMedia;
        }
        return null;
    }
    private List<Media> getAccordingToMedia (String media){
        if (media.equalsIgnoreCase("series")) {
            return getSeries();
        } else if (media.equalsIgnoreCase("movies")) {
            return getMovies();
        } else return getAll();
    }
}


