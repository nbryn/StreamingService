package sample.data.setup;


import sample.data.DatabaseConnector;
import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;
import sample.logic.entities.User;
import sample.logic.exceptions.NoSuchUserException;

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

    public ResultSet sendStatement(String query) {
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

    public void executeUpdate(String query) {
        PreparedStatement preparedStatement;

        try {
            preparedStatement = SQL.preparedStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Media> getMovies(String query) {
        ResultSet results = sendStatement(query);
        List<Media> mediaList = new ArrayList<>();
        String name, genre;
        int release;
        double rating;


        if (results != null) {
            try {
                while (results.next()) {
                    name = results.getString("name");
                    genre = results.getString("genre");
                    release = results.getInt("release");
                    rating = results.getDouble("rating");
                    List<String> genres = Arrays.asList(genre.split("[\\s,]+"));
                    Movie movie = new Movie(name, release, rating);
                    for (String g : genres) movie.addGenre(g);
                    mediaList.add(movie);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return mediaList;
    }

    public List<Media> getSeries(String query) {
        ResultSet results = sendStatement(query);
        List<Media> mediaList = new ArrayList<>();
        String name, genre, span, seasons, spanInternal;
        int release;
        double rating;

        try {
            if (results != null) {
                while (results.next()) {
                    name = results.getString("name");
                    genre = results.getString("genre");
                    span = results.getString("span");
                    rating = results.getDouble("rating");
                    seasons = results.getString("seasons");

                    /*Set year of release*/
                    spanInternal = span.replaceAll("\\s+", "");
                    release = Integer.parseInt(spanInternal.substring(0, 4));

                    /*Initialize series*/
                    Series series = new Series(name, release, span, rating);

                    /* Set genre */
                    genre = genre.replaceAll("\\s+", "");
                    List<String> genres = Arrays.asList(genre.split("[\\s,]+"));
                    for (String g : genres) series.addGenre(g);

                    /* Set seasons*/
                    seasons = seasons.replaceAll("\\s+", "");
                    List<String> seasonList = Arrays.asList(seasons.split("[\\s,]+"));
                    for (String s : seasonList) {
                        String[] season = s.split("-");
                        series.addSeason(Integer.parseInt(season[0]), Integer.parseInt(season[1]));
                    }
                    mediaList.add(series);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mediaList;
    }

    public List<User> getUsers(String query) throws NoSuchUserException {
        ResultSet results = sendStatement(query);
        String username, password, name, birthdate;

        List<User> userList = new ArrayList<>();
        try {
            if (results != null) {
                while (results.next()) {
                    username = results.getString("username");
                    password = results.getString("password");
                    name = results.getString("name");
                    birthdate = results.getString("birthdate");
                    userList.add(new User(name, birthdate, username, password));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new NoSuchUserException();
        }
        return userList;
    }

}

