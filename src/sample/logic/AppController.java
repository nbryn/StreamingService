package sample.logic;

import sample.logic.entities.Genre;
import sample.logic.entities.Media;
import sample.logic.entities.User;
import sample.logic.exceptions.NoSuchUserException;
import sample.logic.interfaces.MediaMapper;
import sample.logic.interfaces.UserMapper;

import java.util.List;

public class AppController {

    private UserMapper userMapper;
    private MediaMapper mediaMapper;

    public AppController(UserMapper userMapper, MediaMapper mediaMapper)
    {
        this.userMapper = userMapper;
        this.mediaMapper = mediaMapper;
    }

    public boolean validateUser(String username, String password) {
        try {
            User user = userMapper.getUser(username, password);

            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }

        } catch (NoSuchUserException e)
        {
            return false;
        }

        return false;
    }

    public List<Media> fetchAllMedia() {
        List<Media> medias = mediaMapper.getAll();

        return medias;
    }

    public List<Media> fetchAllSeries() {
        List<Media> series = mediaMapper.getAllSeries();

        return series;
    }

    public List<Media> fetchAllMovies() {
        List<Media> movies = mediaMapper.getAllMovies();

        return movies;
    }

    public List<Media> fetchAllFromGenre(String genre, String mediaToFetch) {
        List<Media> result;
        Genre gen = Genre.valueOf(genre.toUpperCase());

        if (mediaToFetch.equals("all")) {
            result = mediaMapper.getAllFromGenre(gen);
        } else if (mediaToFetch.equals("series")) {
            result = mediaMapper.getAllSeriesFromGenre(gen);
        } else {
            result = mediaMapper.getAllMoviesFromGenre(gen);
        }
        return result;
    }

    public List<Media> fetchAllWithRatingOver(double rating, String mediaToFetch) {
        List<Media> result;

        if (mediaToFetch.equals("all")) {
            result = mediaMapper.getAllWithRatingOver(rating);
        } else if (mediaToFetch.equals("series")) {
            result = mediaMapper.getAllSeriesWithRatingOver(rating);
        } else {
            result = mediaMapper.getAllMoviesWithRatingOver(rating);
        }
        return result;
    }

}

