package sample.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
    public static void init(){

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConnector SQL = new DatabaseConnector();
        SQL.setConnection(connection);


    }
}
