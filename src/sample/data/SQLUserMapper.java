package sample.data;

import sample.logic.entities.User;
import sample.logic.exceptions.NoSuchUserException;
import sample.logic.interfaces.UserMapper;

import java.util.List;

public class SQLUserMapper implements UserMapper {
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUser(String username, String password) throws NoSuchUserException {
        return null;
    }

    @Override
    public User getUser(int id) throws NoSuchUserException {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(int id) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
