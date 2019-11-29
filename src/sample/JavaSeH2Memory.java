package sample;

import java.sql.*;
public class JavaSeH2Memory {
    public static void main(String[] a) throws SQLException {

            Connection conn = DriverManager.getConnection("jdbc:h2:mem");

            var stm = conn.createStatement();
            stm.executeUpdate("DROP TABLE IF EXISTS users;");
            stm.executeUpdate(
                         "CREATE TABLE users(" +
                            "user_id int PRIMARY KEY AUTO_INCREMENT,"+
                            "username varchar(50) NOT NULL ," +
                            "password varchar(50) NOT NULL);" +
                            "insert into users (username, password) "+
                            "VALUES ('username','password');"
            );

            var retur = stm.executeQuery("SELECT * FROM users WHERE username = 'username'");
            String test = null;
            while(retur.next()){
                System.out.println("");
                test = retur.getString("username");
            }if (test != null){
                System.out.println(test);

            }else System.out.println("Du dummede dig");
            conn.close();


    }
}