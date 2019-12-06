package sample.logic.interfaces;

import sample.logic.entities.Media;

import java.sql.SQLException;
import java.util.List;

public interface MediaMapper {

    public List<Media> getAll() throws SQLException;

    public List<Media> getMovies() throws SQLException;

    public List<Media> getSeries() throws SQLException;

    public List<Media> getByName(String name, String media) throws SQLException;

    public List<Media> getByRating(double rating, String media) throws SQLException;

    public List<Media> getAllFromGenre(String genre, String media) throws SQLException;

    public List<Media> getByRelease(int release, String media) throws SQLException;


}
