package sample.data.mock;

import sample.logic.entities.User;
import sample.logic.exceptions.NoSuchUserException;
import sample.logic.interfaces.UserMapper;

import java.util.ArrayList;
import java.util.List;

public class MockUserMapper implements UserMapper {

    List<User> users;

    public MockUserMapper() {
        users = new ArrayList<>();
        users.add(new User("Kristian", 1996, "KR", "Hejsa"));
        users.add(new User("Niklas", 1992, "NBRYN", "Suppe"));
    }

    @Override
    public List<User> getAllUsers() {

        return users;
    }

    @Override
    public User getUser(String username, String password) throws NoSuchUserException {
        User matchingUser = users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny()
                .orElse(null);

        if (matchingUser == null) {
            throw new NoSuchUserException();
        }

        return matchingUser;
    }

    @Override
    public User getUser(int id) throws NoSuchUserException {
        User matchingUser = users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);

        if (matchingUser == null) {
            throw new NoSuchUserException();
        }

        return matchingUser;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);

    }

    @Override
    public void updateUser(int id) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
