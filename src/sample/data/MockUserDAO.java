package sample.data;

import sample.logic.entities.User;
import sample.logic.interfaces.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class MockUserDAO implements UserDAO {

    List<User> users;

    public MockUserDAO() {
        users = new ArrayList<>();
        users.add(new User("Kristian", 1996, "KR", "Hejsa"));
        users.add(new User("Niklas", 1992, "NBRYN", "Suppe"));
    }

    @Override
    public List<User> getAllUsers() {

        return users;
    }

    @Override
    public User getUser(String username, String password) {
        User matchingUser = users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password))
                .findAny()
                .orElse(null);

        return matchingUser;
    }

    @Override
    public User getUser(int id) {
        User matchingUser = users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);

        return matchingUser;
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
