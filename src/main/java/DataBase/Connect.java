package DataBase;

import java.sql.*;

public class Connect {

    private  Connection connection;

    public Connect() {
        this.connection = connect();
    }
    public Connection getConnection() {
        return connection;
    }


    public Connection connect() {


        Connection connection = null;
        try {
            String url = "jdbc:sqlite:C:\\Users\\maria\\Desktop\\DACD\\actvspotify\\database.db";
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
