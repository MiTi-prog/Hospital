package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection databaseLink;

    public Connection getConnection(){
/*
        String databaseName = "hospital_assistant";
        String databaseUser = "root";
        String databasePassword = "admin";
*/
/*
        String url = "jdbc:mysql://localhost/" + databaseName;
*/

        String databaseName = "sql11412420";
        String databaseUser = "sql11412420";
        String databasePassword = "zWKSuzqeFj";


        String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/" + databaseName;

     /*   // auto close connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/test", "root", "password")) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}