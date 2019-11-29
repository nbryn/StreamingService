package sample.logic.interfaces;

import sample.logic.entities.Genre;
import sample.logic.entities.Media;

import java.util.List;

public interface MediaMapper {

    public Media get(int id);

    public List<Media> getAll();

    public List<Media> getAllMovies();

    public List<Media> getAllSeries();

    public List<Media> getAllWithRatingOver(double rating);

    public List<Media> getAllSeriesWithRatingOver(double rating);

    public List<Media> getAllMoviesWithRatingOver(double rating);

    public List<Media> getAllFromGenre(Genre genre);

    public List<Media> getAllMoviesFromGenre(Genre genre);

    public List<Media> getAllSeriesFromGenre(Genre genre);

}
