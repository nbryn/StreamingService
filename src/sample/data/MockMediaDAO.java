package sample.data;

import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;
import sample.logic.interfaces.MediaDAO;

import java.util.List;

public class MockMediaDAO implements MediaDAO {
    @Override
    public List<Media> getAll() {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public List<Series> getAllSeries() {
        return null;
    }

    @Override
    public Media get(int id) {
        return null;
    }
}
