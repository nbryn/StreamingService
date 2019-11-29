package sample.logic;

import sample.logic.entities.User;
import sample.logic.exceptions.NoSuchUserException;
import sample.logic.interfaces.MediaMapper;
import sample.logic.interfaces.UserMapper;

public class AppController {

    private UserMapper userMapper;
    private MediaMapper mediaMapper;

    public AppController(UserMapper userMapper, MediaMapper mediaMapper) {

        this.userMapper = userMapper;
        this.mediaMapper = mediaMapper;
    }

    public boolean validateUser(String username, String password) {

        try {
            User user = userMapper.getUser(username, password);

            if (user.getUsername().equals(user) && user.getPassword().equals(password)) {
                return true;
            }

        } catch (NoSuchUserException e) {
            return false;
        }

        return false;
    }
}

