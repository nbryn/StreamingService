package streaming.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streaming.data.SQLMediaMapper;
import streaming.data.SQLUserMapper;
import streaming.data.setup.H2Init;
import streaming.logic.entities.Media;
import streaming.logic.entities.Movie;
import streaming.logic.entities.Series;
import streaming.logic.entities.User;
import streaming.logic.exceptions.NoSuchUserException;
import streaming.logic.exceptions.UserListException;
import streaming.logic.interfaces.MediaMapper;
import streaming.logic.interfaces.UserMapper;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {

    private static AppController appController;
    private static MediaMapper mediaMapper;
    private static UserMapper userMapper;


    @BeforeEach
    void setUp() {
        H2Init.initialize();
        mediaMapper = new SQLMediaMapper();
        userMapper = new SQLUserMapper();
        appController = new AppController(userMapper, mediaMapper);
    }

    @Test
    void registerUser() throws SQLException, NoSuchUserException {
        User userFromTest = new User("Niklas", "10.03.1992", "hej@hej.com", "123456");

        appController.registerUser(userFromTest);

        List<User> users = userMapper.getAll();
        User userFromDB = userMapper.getUser("hej@hej.com");

        assertEquals(2, users.size());
        assertEquals("hej@hej.com", userFromDB.getUsername());
        assertEquals("10.03.1992", userFromDB.getBirthday());
        assertEquals("123456", userFromDB.getPassword());
        assertEquals("Niklas", userFromDB.getName());
    }

    @Test
    void validateLogin() {
        boolean test = appController.validateLogin("Kris", "Suppe");

        assertEquals(true, test);
    }

    @Test
    void fetchAll() {
        List<Media> result;

        result = appController.fetchAll("All");
        assertEquals(199, result.size());
        result.clear();

        result = appController.fetchAll("Movie");
        assertEquals(100, result.size());
        result.clear();

        result = appController.fetchAll("Series");
        assertEquals(100, result.size());
    }

    @Test
    void fetchAllFromGenre() {
        List<Media> result;

        result = appController.fetchAllFromGenre("Horror", "All");
        assertEquals(7, result.size());
        result.clear();

        result = appController.fetchAllFromGenre("Drama", "Movie");
        assertEquals(146, result.size());
        result.clear();

        result = appController.fetchAllFromGenre("Action", "Series");
        assertEquals(21, result.size());
    }

    @Test
    void fetchRatingOver() {
        List<Media> result;

        result = appController.fetchRatingOver(8.0, "All");
        assertEquals(152, result.size());
        result.clear();

        result = appController.fetchRatingOver(8.6, "Movie");
        assertEquals(59, result.size());
        result.clear();

        result = appController.fetchRatingOver(7.0, "Series");
        assertEquals(98, result.size());

    }

    @Test
    void fetchByName() {
        List<Media> result;
        Movie movie;
        Series series;

        result = appController.fetchByName("The Simpsons", "All");
        series = (Series) result.get(0);
        result.clear();

        assertEquals("The Simpsons", series.getTitle());
        assertEquals(1989, series.getRelease());
        assertEquals(29, series.getSeasons().size());
        assertEquals(8.7, series.getRating());


        result = appController.fetchByName("Rain Man", "Movie");
        movie = (Movie) result.get(0);
        result.clear();

        assertEquals("Rain Man", movie.getTitle());
        assertEquals(1988, movie.getRelease());
        assertEquals(8.0, movie.getRating());
    }

    @Test
    void fetchReleaseAfter() {
        List<Media> result;

        result = appController.fetchReleaseAfter(2000, "All");
        assertEquals(65, result.size());
        result.clear();

        result = appController.fetchReleaseAfter(2015, "Movie");
        assertEquals(17, result.size());
        result.clear();

        result = appController.fetchReleaseAfter(1980, "Series");
        assertEquals(89, result.size());

    }

    @Test
    void fetchUserList() throws UserListException {
        List<Media> result;
        Series series;

        userMapper.addToUserList("Kris", "Series", "Lost");
        result = appController.fetchUserList("Kris");
        series = (Series) result.get(0);

        assertEquals(1, result.size());
        assertEquals("Lost", series.getTitle());
        assertEquals(8.4, series.getRating());

    }

    @Test
    void addToUserList() throws UserListException {
        List<Media> result;

        userMapper.addToUserList("Kris", "Movie", "Giant");
        result = appController.fetchUserList("Kris");

        assertEquals(1, result.size());
    }

    @Test
    void removeFromUserList() throws UserListException {
        List<Media> result;

        userMapper.addToUserList("Kris", "Movie", "Giant");
        userMapper.addToUserList("Kris", "Series", "Twin Peaks");
        userMapper.addToUserList("Kris", "Series", "Breaking Bad");

        userMapper.removeFromUserList("Kris", "Movie", "Giant");

        result = appController.fetchUserList("Kris");

        assertEquals(2, result.size());
    }
}