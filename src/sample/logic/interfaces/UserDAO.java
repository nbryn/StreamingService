package sample.logic.interfaces;

import sample.logic.entities.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public User getUser(String username, String password);

    public User getUser(int id);

    public void saveUser(User user);

    public void updateUser(int id);

    public void deleteUser(int id);



}
