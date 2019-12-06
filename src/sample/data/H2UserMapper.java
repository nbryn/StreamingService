package sample.data;

import sample.logic.entities.User;
import sample.logic.exceptions.NoSuchUserException;
import sample.logic.interfaces.UserMapper;

import java.util.List;

public class H2UserMapper implements UserMapper {
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getUser(String username, String password) throws NoSuchUserException {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(String username, String password) {

    }

    @Override
    public void deleteUser(String username, String password) {

    }
}
