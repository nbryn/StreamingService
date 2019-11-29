package sample.logic.interfaces;

import sample.logic.entities.User;
import sample.logic.exceptions.NoSuchUserException;

import java.util.List;

public interface UserMapper {

    public List<User> getAllUsers();

    public User getUser(String username, String password) throws NoSuchUserException;

    public User getUser(int id) throws NoSuchUserException;

    public void saveUser(User user);

    public void updateUser(int id);

    public void deleteUser(int id);



}
