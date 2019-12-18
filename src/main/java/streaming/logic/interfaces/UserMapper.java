package streaming.logic.interfaces;

import streaming.logic.entities.User;
import streaming.logic.exceptions.NoSuchUserException;
import streaming.logic.exceptions.EmailAlreadyExistException;
import streaming.logic.exceptions.UserException;
import streaming.logic.exceptions.UserListException;

import java.sql.SQLException;
import java.util.List;

public interface UserMapper {

    public List<User> getAll() throws SQLException, NoSuchUserException;

    public User getUser(String username) throws NoSuchUserException;

    public void saveUser(User user) throws EmailAlreadyExistException;

    public void addToUserList(String username, String media, String mediaTitle) throws UserListException;

    public void removeFromUserList(String username, String media, String mediaTitle) throws UserListException;

    public void updateUserInfo(String username, String password) throws UserException;

    public void deleteUser(String username, String password) throws UserException;

}
