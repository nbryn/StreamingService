package sample.logic.interfaces;

import sample.logic.entities.Media;

import java.sql.SQLException;
import java.util.List;

public interface MediaMapper {

    public List<Media> getAll();

    public List<Media> getMovies();

    public List<Media> getSeries();

    public List<Media> getByName(String name, String media);

    public List<Media> getByRating(double rating, String media);

    public List<Media> getAllFromGenre(String genre, String media);

    public List<Media> getByRelease(int release, String media);


}
