package sample.logic.interfaces;

import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;

import java.util.List;

public interface MediaMapper {

    public List<Media> getAll();

    public List<Media> getAllMovies();

    public List<Media> getAllSeries();

    public List<Media> getAllFromCategory(String category);

    public Media get(int id);
}
