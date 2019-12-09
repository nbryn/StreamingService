package sample.data.setup;
import java.sql.*;

public class H2Init {
    public static void initialize(Boolean test){
        H2DataBase sql = new H2DataBase("jdbc:h2:mem");
        sql.executeUpdate("DROP TABLE IF EXISTS USERS;");
        sql.executeUpdate("DROP TABLE IF EXISTS MOVIES;");
        sql.executeUpdate("DROP TABLE IF EXISTS SERIES;");
        sql.executeUpdate("DROP TABLE IF EXISTS MYMOVIELIST");
        sql.executeUpdate("DROP TABLE IF EXISTS MYSERIESLIST");
        if (!test) {
            String tableInitQuery = SQLDataScript.buildTables();
            String movieInitQuery = SQLDataScript.buildMOVIES();
            String seriesInitQuery = SQLDataScript.buildSERIES();
            String usersInitQuery = SQLDataScript.buildUSERS();
            sql.executeUpdate(tableInitQuery);
            sql.executeUpdate(movieInitQuery);
            sql.executeUpdate(seriesInitQuery);
            sql.executeUpdate(usersInitQuery);
        }else{
            String testInitQuery = SQLDataScript.testQueries();
            sql.executeUpdate(testInitQuery);
        }

    }

}
