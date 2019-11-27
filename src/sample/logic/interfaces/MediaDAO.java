package sample.logic.interfaces;

import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;

import java.util.List;

public interface MediaDAO {

    public List<Media> getAll();

    public List<Movie> getAllMovies();

    public List<Series> getAllSeries();

    public Media get(int id);
}
