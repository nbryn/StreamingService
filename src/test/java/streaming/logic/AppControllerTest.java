package streaming.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streaming.data.SQLMediaMapper;
import streaming.data.SQLUserMapper;
import streaming.logic.entities.Media;
import streaming.logic.entities.User;
import streaming.logic.exceptions.NoSuchUserException;
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
        assertEquals(99, result.size());
        result.clear();

        result = appController.fetchAll("Series");
        assertEquals(100, result.size());

    }

    @Test
    void fetchAllFromGenre() {
    }

    @Test
    void fetchRatingOver() {
    }

    @Test
    void fetchByName() {
    }

    @Test
    void fetchReleaseAfter() {
    }

    @Test
    void fetchUserList() {
    }

    @Test
    void addToUserList() {
    }

    @Test
    void removeFromUserList() {
    }
}