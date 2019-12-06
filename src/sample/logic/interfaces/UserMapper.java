package sample.logic.interfaces;

import sample.logic.entities.User;
import sample.logic.exceptions.NoSuchUserException;
import sample.logic.exceptions.EmailAlreadyExistException;

import java.sql.SQLException;
import java.util.List;

public interface UserMapper {

    public List<User> getAll() throws SQLException, NoSuchUserException;

<<<<<<< HEAD
    public User getUser(String username) throws NoSuchUserException;
=======
    public User getUser(String username) throws NoSuchUserException, SQLException;
>>>>>>> 08e69be8c5a24b8cc72739a743527276754dc854

    public void saveUser(User user) throws EmailAlreadyExistException;

    public void addToUserList(int userID, int mediaID);

    public void removeFromUserList(int userID, int mediaID);

    public void updateUserInfo(String username, String password);

    public void deleteUser(String username, String password);

}
