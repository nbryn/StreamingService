package sample.data.mock;

import sample.logic.entities.User;
import sample.logic.exceptions.EmailAlreadyExistException;
import sample.logic.exceptions.NoSuchUserException;
import sample.logic.interfaces.UserMapper;

import java.util.ArrayList;
import java.util.List;

public class MockUserMapper implements UserMapper {

    List<User> users;

    public MockUserMapper()
    {
        users = new ArrayList<>();
        users.add(new User("Kristian", "10.03.1996", "KR", "Hejsa"));
        users.add(new User("Niklas", "12.02.1992", "NBRYN", "Suppe"));
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getUser(String username) throws NoSuchUserException {
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
    public void saveUser(User user) throws EmailAlreadyExistException {
        users.forEach(us -> {
            if(us.getUsername().equalsIgnoreCase(user.getUsername())) {
                throw new EmailAlreadyExistException();
            }
        });

        users.add(user);
    }

    @Override
    public void addToUserList(String userID, String media, int mediaID) {

    }

    @Override
    public void removeFromUserList(String userID, String media, int mediaID) {

    }

    @Override
    public void updateUserInfo(String username, String password) {

    }


    @Override
    public void deleteUser(String username, String password) {

    }
}