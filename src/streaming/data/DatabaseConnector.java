package streaming.data;

import java.sql.*;
public class DatabaseConnector {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void setConnection(Connection connection){
        this.connection = connection;
    }

    public Connection getConnection () throws SQLException{
        if (connection == null && connection.isClosed()){
            System.out.println("No connection made");
        }
        return connection;
    }
    public void terminateConnection () throws  SQLException{
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }
    public PreparedStatement preparedStatement (String sql) throws SQLException{
        return connection.prepareStatement(sql);
    }
}
