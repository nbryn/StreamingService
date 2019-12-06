package sample.data;

import sample.logic.entities.Media;
import sample.logic.interfaces.MediaMapper;

import java.util.List;

public class H2MediaMapper implements MediaMapper {
    @Override
    public List<Media> getAll() {
        return null;
    }

    @Override
    public List<Media> getMovies() {
        return null;
    }

    @Override
    public List<Media> getSeries() {
        return null;
    }

    @Override
    public List<Media> getByName(String name, String media) {
        return null;
    }

    @Override
    public List<Media> getByRating(double rating, String media) {
        return null;
    }

    @Override
    public List<Media> getAllFromGenre(String genre, String media) {
        return null;
    }

    @Override
    public List<Media> getByRelease(int year, String media) {
        return null;
    }
}
