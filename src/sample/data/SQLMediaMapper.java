package sample.data;

import sample.logic.entities.Media;
import sample.logic.interfaces.MediaMapper;

import java.util.List;

public class SQLMediaMapper implements MediaMapper {
    @Override
    public List<Media> getAll() {
        return null;
    }

    @Override
    public List<Media> getAllMovies() {
        return null;
    }

    @Override
    public List<Media> getAllSeries() {
        return null;
    }

    @Override
    public List<Media> getAllWithRatingOver(double rating) {
        return null;
    }

    @Override
    public List<Media> getAllSeriesWithRatingOver(double rating) {
        return null;
    }

    @Override
    public List<Media> getAllMoviesWithRatingOver(double rating) {
        return null;
    }

    @Override
    public List<Media> getAllFromGenre(String genre) {
        return null;
    }

    @Override
    public List<Media> getAllMoviesFromGenre(String genre) {
        return null;
    }

    @Override
    public List<Media> getAllSeriesFromGenre(String genre) {
        return null;
    }


    @Override
    public Media get(int id) {
        return null;
    }
}
