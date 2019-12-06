package sample.data;

import sample.data.setup.H2DataBase;
import sample.logic.entities.User;
import sample.logic.exceptions.EmailAlreadyExistException;
import sample.logic.exceptions.NoSuchUserException;
import sample.logic.interfaces.UserMapper;

import java.sql.SQLException;
import java.util.List;

public class SQLUserMapper implements UserMapper {
    private H2DataBase dataBase;


    public SQLUserMapper(){
        dataBase = new H2DataBase("jdbc:h2:mem");
    }


    @Override
    public List<User> getAll() throws NoSuchUserException {
        return dataBase.getUsers("SELECT * FROM users");
    }

    @Override
    public User getUser(String username) throws NoSuchUserException{
        List<User> users = dataBase.getUsers("SELECT * FROM users WHERE 'username' = " + username);
        if (users != null) return users.get(0);
        else throw new NoSuchUserException();
    }

    @Override
    public void saveUser(User user) {
        dataBase.executeUpdate("INSERT INTO users (username, password, name, birthdate) VALUES " +
                "('" + user.getUsername() + "'," +
                "'"+ user.getPassword() + "'," +
                "'"+ user.getName() + "'," +
                "'"+ user.getBirthday() + "');");
    }

    @Override
    public void addToUserList(int userID, int mediaID) {

    }

    @Override
    public void removeFromUserList(int userID, int mediaID) {

    }

    @Override
    public void updateUserInfo(String username, String password) {

    }

    @Override
    public void deleteUser(String username, String password) {

    }
}
