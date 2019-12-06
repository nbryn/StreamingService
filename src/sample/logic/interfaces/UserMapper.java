package sample.logic.interfaces;

import sample.logic.entities.User;
import sample.logic.exceptions.NoSuchUserException;
import sample.logic.exceptions.EmailAlreadyExistException;

import java.sql.SQLException;
import java.util.List;

public interface UserMapper {

    public List<User> getAll() throws SQLException, NoSuchUserException;

    public User getUser(String username) throws NoSuchUserException;

    public void saveUser(User user) throws EmailAlreadyExistException;

    public void addToUserList(int userID, int mediaID);

    public void removeFromUserList(int userID, int mediaID);

    public void updateUserInfo(String username, String password);

    public void deleteUser(String username, String password);

}
