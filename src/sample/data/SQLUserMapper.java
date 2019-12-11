package sample.data;

import sample.data.setup.H2DataBase;
import sample.logic.entities.User;
import sample.logic.exceptions.EmailAlreadyExistException;
import sample.logic.exceptions.NoSuchUserException;
import sample.logic.interfaces.UserMapper;

import java.sql.ResultSet;
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
        List<User> users = dataBase.getUsers("SELECT * FROM users WHERE username = '" + username + "';");
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
    public void addToUserList(String username, String media, String mediaTitle) {
            String userID = getUserID(username);

            if (media.equalsIgnoreCase("movie")){
                dataBase.executeUpdate("INSERT INTO myMovieList VALUES (user_id, movie_id) ('" + userID + "', '" + mediaTitle + "');");
            }
            if (media.equalsIgnoreCase("series")){
                dataBase.executeUpdate("INSERT INTO mySeriesList VALUES (user_id, series_id) ('" + userID + "', '" + mediaTitle +"');");
            }
    }

    @Override
    public void removeFromUserList(String username, String media, String mediaTitle) {
        String userID = getUserID(username);

        if (media.equalsIgnoreCase("movie")){
            dataBase.executeUpdate("DELETE FROM myMovieList WHERE user_id = '" + userID + "' AND WHERE movie_id = '" + mediaTitle +"';");
        }
        if (media.equalsIgnoreCase("series")){
            dataBase.executeUpdate("DELETE FROM mySeriesList WHERE user_id = '" + userID + "' AND WHERE series_id = '" + mediaTitle +"';");
        }

    }


    @Override
    public void updateUserInfo(String username, String password) {
        String userID = getUserID(username);
        if (username != "" && password != "") dataBase.executeUpdate("UPDATE users SET username = '" + username +"', password = '" + password +"' WHERE user_id = '" + userID+"';");
        if (username != "" && password == "") dataBase.executeUpdate("UPDATE users SET username = '" + username + "', WHERE user_id = '" + userID + "';");
        if (username == "" && password != "") dataBase.executeUpdate("UPDATE users SET password = '" + password + "', WHERE user_id = '" + userID + "';");

    }

    @Override
    public void deleteUser(String username, String password) {
        String userID = getUserID(username);
        dataBase.executeUpdate("DELETE FROM users WHERE user_ID = '" + userID +"';");

    }
    private String getUserID(String username){
        ResultSet results = dataBase.sendStatement("SELECT * FROM users WHERE username = '" + username +"';");
        if (results != null) {
            try {
                return results.getString("username");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
