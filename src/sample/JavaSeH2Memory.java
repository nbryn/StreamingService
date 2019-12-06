package sample;

import sample.data.SQLMediaMapper;
import sample.data.setup.H2Init;
import sample.logic.entities.Media;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JavaSeH2Memory {
    /**public static void test() throws SQLException {

            Connection conn = DriverManager.getConnection("jdbc:h2:mem");
            Connection conn2 = DriverManager.getConnection("jdbc:h2:mem");
            var stm = conn.createStatement();
            var stm2 = conn2.createStatement();
            stm2.executeUpdate("DROP TABLE IF EXISTS users;");
            stm2.executeUpdate("DROP TABLE IF EXISTS users;");
            stm2.executeUpdate(
                         "CREATE TABLE users(" +
                            "user_id int PRIMARY KEY AUTO_INCREMENT,"+
                            "username varchar(50) NOT NULL ," +
                            "password varchar(50) NOT NULL);" +
                            "insert into users (username, password) "+
                            "VALUES ('Kris','Suppe');"
            );

            var retur = stm.executeQuery("SELECT * FROM users WHERE username = 'Kris' ");
            String test = null;
            String test2 = null;
            while(retur.next()){
                System.out.println("");
                test = retur.getString("username");
                test2 = retur.getString("password");
            }if (test != null){
                System.out.println(test + test2);

            }else System.out.println("Du dummede dig");
            conn.close();


    }
**/

    public static void main(String[] args) throws SQLException {
        H2Init.initialize(false);
        SQLMediaMapper test = new SQLMediaMapper();
        List<Media> test2 = new ArrayList<>();
        test2 = test.getAll();
        for(Media media: test2){
            System.out.println(media.getName());
        }
    }
}
