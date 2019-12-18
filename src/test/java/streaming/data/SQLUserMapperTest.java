package streaming.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streaming.data.setup.H2Init;
import streaming.logic.entities.Media;
import streaming.logic.entities.User;
import streaming.logic.exceptions.NoSuchUserException;
import streaming.logic.exceptions.UserListException;
import streaming.logic.interfaces.MediaMapper;
import streaming.logic.interfaces.UserMapper;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SQLUserMapperTest {

    private static UserMapper userMapper;
    private static MediaMapper mediaMapper;

    @BeforeEach
    void setUp() {
        H2Init.initialize();
        userMapper = new SQLUserMapper();
        mediaMapper = new SQLMediaMapper();
    }

    @Test
    void getAll() throws NoSuchUserException, SQLException {
        List<User> allUsers = userMapper.getAll();

        assertEquals(1, allUsers.size());

    }

    @Test
    void getUser() throws NoSuchUserException {
        User user = userMapper.getUser("Kris");

        assertEquals(user.getUsername(), "Kris");
    }

    @Test
    void addToUserList() throws UserListException {
        userMapper.addToUserList("Kris", "Movie", "Braveheart" );

        List<Media> userList = mediaMapper.getUserList("Kris");

        assertEquals(1, userList.size());

        Media media = userList.get(0);

        assertEquals("Braveheart", media.getTitle());
        assertEquals(1995, media.getRelease());
        assertEquals(8.4, media.getRating());
    }

    @Test
    void removeFromUserList() throws UserListException {
        List<Media> userList;
        userMapper.addToUserList("Kris", "Movie", "Rocky" );
        userMapper.addToUserList("Kris", "Movie", "Braveheart" );

        userList = mediaMapper.getUserList("Kris");

        assertEquals(2, userList.size());

        userMapper.removeFromUserList("Kris", "Movie", "Rocky");

        userList = mediaMapper.getUserList("Kris");

        assertEquals(1, userList.size());
    }
}