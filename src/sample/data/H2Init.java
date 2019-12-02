package sample.data;

public class H2Init {
    public static void initialize(){
        H2DataBase sql = new H2DataBase("jdbc:H2:mem");
        String tableInitQuery = SQLDataScript.buildTables();
        String movieInitQuery = SQLDataScript.buildMovies();
        String seriesInitQuery = SQLDataScript.buildSeries();
        String usersInitQuery = SQLDataScript.buildUsers();
        sql.executeUpdate(tableInitQuery);
        sql.executeUpdate(movieInitQuery);
        sql.executeUpdate(seriesInitQuery);
        sql.executeUpdate(usersInitQuery);

    }

}
