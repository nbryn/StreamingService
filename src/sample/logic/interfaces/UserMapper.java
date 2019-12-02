package sample.logic.interfaces;

import sample.logic.entities.User;
import sample.logic.exceptions.NoSuchUserException;

import java.util.List;

public interface UserMapper {

    public List<User> getAll();

    public User getUser(String username, String password) throws NoSuchUserException;

    public void saveUser(User user);

    public void updateUser(String username, String password);

    public void deleteUser(String username, String password);

}
