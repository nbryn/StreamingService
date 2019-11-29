package sample.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {

    DatabaseConnector SQL;

    public SQL(String url) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL = new DatabaseConnector();
        SQL.setConnection(connection);
    }
    public void sendStatement (String query){
        try {
            SQL.preparedStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void initializeH2(){
        String tableInitQuerry = SQLDataScript.buildTables();
        String movieInitQuerry = SQLDataScript.buildMovies();
        String seriesInitQuerry = SQLDataScript.buildSeries();
        String usersInitQuerry = SQLDataScript.buildUsers();
        sendStatement(tableInitQuerry);
        sendStatement(movieInitQuerry);
        sendStatement(seriesInitQuerry);
        sendStatement(usersInitQuerry);
    }

}

