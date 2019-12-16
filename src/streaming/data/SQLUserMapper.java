package streaming.data;

import streaming.data.setup.H2Database;
import streaming.logic.entities.User;
import streaming.logic.exceptions.EmailAlreadyExistException;
import streaming.logic.exceptions.NoSuchUserException;
import streaming.logic.exceptions.UserException;
import streaming.logic.exceptions.UserListException;
import streaming.logic.interfaces.UserMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SQLUserMapper implements UserMapper {
    private H2Database dataBase;


    public SQLUserMapper(){
        dataBase = new H2Database("jdbc:h2:mem");
    }


    @Override
    public List<User> getAll() throws NoSuchUserException {
        return dataBase.getUsers("SELECT * FROM users");
    }

    @Override
    public User getUser(String username) throws NoSuchUserException{
        List<User> users = dataBase.getUsers("SELECT * FROM users WHERE username = '" + username + "';");
        if (users.size() > 0) return users.get(0);
        else throw new NoSuchUserException();
    }

    @Override
    public void saveUser(User user) throws EmailAlreadyExistException {

        try {
            dataBase.executeUpdate("INSERT INTO users (username, password, name, birthdate) VALUES " +
                    "('" + user.getUsername() + "'," +
                    "'" + user.getPassword() + "'," +
                    "'" + user.getName() + "'," +
                    "'" + user.getBirthday() + "');");
        } catch (SQLException e) {
            throw new EmailAlreadyExistException();
        }
    }

    @Override
    public void addToUserList(String username, String media, String mediaTitle) throws UserListException {
                try {
                    if (media.equalsIgnoreCase("series")) dataBase.executeUpdate("INSERT INTO mySeriesList (user_id,series_id) VALUES " +
                            "((SELECT user_id FROM users WHERE username = '" + username + "'),(SELECT series_id FROM series WHERE name = '" + mediaTitle +"'));");
                    if (media.equalsIgnoreCase("movie")) dataBase.executeUpdate("INSERT INTO myMovieList (user_id,movie_id) VALUES " +
                            "((SELECT user_id FROM users WHERE username = '" + username + "'),(SELECT movie_id FROM movies WHERE name = '" + mediaTitle +"'));");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
    }

    @Override
    public void removeFromUserList(String username, String media, String mediaTitle) throws UserListException {

        try {

            if (media.equalsIgnoreCase("movie")) {
                dataBase.executeUpdate("DELETE FROM myMovieList WHERE user_id = (SELECT user_id FROM users WHERE username = '" + username + "') AND movie_id = (SELECT movie_id FROM movies WHERE name = '" + mediaTitle +"');");
            }
            if (media.equalsIgnoreCase("series")) {
                dataBase.executeUpdate("DELETE FROM mySeriesList WHERE user_id = (SELECT user_id FROM users WHERE username = '" + username + "') AND series_id = (SELECT series_id FROM series WHERE name = '" + mediaTitle +"');");
            }
        } catch (SQLException e) {
            throw new UserListException();
        }

    }


    @Override
    public void updateUserInfo(String username, String password) throws UserException {
        int userID = getUserID(username);

        try {
            if (username != "" && password != "")
                dataBase.executeUpdate("UPDATE users SET username = '" + username + "', password = '" + password + "' WHERE user_id = '" + userID + "';");
            if (username != "" && password == "")
                dataBase.executeUpdate("UPDATE users SET username = '" + username + "', WHERE user_id = '" + userID + "';");
            if (username == "" && password != "")
                dataBase.executeUpdate("UPDATE users SET password = '" + password + "', WHERE user_id = '" + userID + "';");
        } catch (SQLException e) {
            throw new UserException();
        }
    }

    @Override
    public void deleteUser(String username, String password) throws UserException {
        int userID = getUserID(username);

        try {
            dataBase.executeUpdate("DELETE FROM users WHERE user_ID = '" + userID + "';");
        } catch (SQLException e) {
            throw new UserException();
        }
    }
    private int getUserID(String username){
        ResultSet results = dataBase.sendStatement("SELECT * FROM users WHERE username = '" + username +"';");
        try {
            while (results.next()) {
                String usernameInternal = results.getString("username");
                int userID = results.getInt("user_id");
                return userID;
            }
        }catch (SQLException e) {
                    e.printStackTrace();
        }

        return -1;
    }
    private int getMediaID(String name, String media){
        ResultSet results = null;
        if (media.equalsIgnoreCase("movie")) results = dataBase.sendStatement("SELECT * FROM movies WHERE name = '" + name +"';");
        if (media.equalsIgnoreCase("series")) results = dataBase.sendStatement("SELECT * FROM series WHERE name = '" + name +"';");
        try {
            while (results.next()) {
                if (media.equalsIgnoreCase("movie")) return results.getInt("movie_id");
                if (media.equalsIgnoreCase("series")) return results.getInt("series_id");
            }
        }catch (Exception e) {
            e.printStackTrace();

        }
        return -1;
    }
}
