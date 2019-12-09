package sample.logic;

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

    public List<Media> fetchAll(String media) {
        List<Media> result;
        if (media.equalsIgnoreCase("all")) {
            result = mediaMapper.getAll();
        } else if (media.equalsIgnoreCase("movies")) {
            result = mediaMapper.getMovies();
        } else {
            result = mediaMapper.getSeries();
        }

        return result;
    }

    public List<Media> fetchAllFromGenre(String genre, String media) {
        List<Media> result;

        result = mediaMapper.getAllFromGenre(genre, media);

        return result;
    }

    public List<Media> fetchRatingOver(double rating, String media) {
        List<Media> result;

        result = mediaMapper.getByRating(rating, media);

        return result;
    }
}

