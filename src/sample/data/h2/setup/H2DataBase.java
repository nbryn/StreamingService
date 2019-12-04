package sample.data.h2.setup;



import sample.data.h2.DatabaseConnector;
import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;
import sample.logic.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class H2DataBase {

    DatabaseConnector SQL;

    public H2DataBase(String url) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.SQL = new DatabaseConnector();
        this.SQL.setConnection(connection);
    }
    public ResultSet sendStatement(String query){
        ResultSet resultSet = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = SQL.preparedStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public void  executeUpdate (String query){
            ResultSet resultSet = null;
            PreparedStatement preparedStatement;
            try {
                preparedStatement = SQL.preparedStatement(query);
                resultSet = preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public List<Media> getMovies(String query) throws SQLException{
        ResultSet results = sendStatement(query);
        String name;
        String genre;
        int release;
        double rating;
        List<Media> mediaList = new ArrayList<>();
        if (results != null){
            while(results.next()){
                name = results.getString("name");
                genre = results.getString("genre");
                release = results.getInt("release");
                rating = results.getDouble("rating");
                List<String> genres = Arrays.asList(toString().split("[\\s,]+"));
                mediaList.add(new Movie(name,release,genres,rating));
            }
        }else {throw new SQLException("Query yielded no results");}
        return mediaList;
    }
    public List<Media> getSeries(String query) throws SQLException{
        Map<Integer,Integer> series = new HashMap<>();
        ResultSet results = sendStatement(query);
        String name;
        String genre;
        int release;
        double rating;
        String season;
        List<Media> mediaList = new ArrayList<>();
        if (results != null){
            while(results.next()){
                name = results.getString("name");
                genre = results.getString("genre");
                release = results.getInt("release");
                rating = results.getDouble("rating");
                season = results.getString("seasons");
                List<String> genres = Arrays.asList(genre.split("[\\s,]+"));
                List<String> seasons = Arrays.asList(season.split("[\\s,]+"));
                for (int i = 0; i > seasons.size();i++){
                    List<String> seasonsInt = Arrays.asList(seasons.get(i).split("[\\s-]+"));
                    series.put(Integer.parseInt(seasonsInt.get(0)),Integer.parseInt(seasonsInt.get(1)));

                }
                mediaList.add(new Series(name,release,genres,rating,series));
            }
        }else {throw new SQLException("Query yielded no results");}
        return mediaList;
    }
    public List<User> getUsers(String query) throws SQLException{
        ResultSet results = sendStatement(query);
        String username;
        String password;
        String name;
        String birthdate;
        List<User> userList = new ArrayList<>();
        if (results != null){
            while(results.next()){
            username = results.getString("username");
            password = results.getString("password");
            name = results.getString("name");
            birthdate = results.getString("birthdate");
            userList.add(new User(name,birthdate,username,password));
            }
        }else {throw new SQLException("Query yielded no results");}
        return userList;
    }

}

