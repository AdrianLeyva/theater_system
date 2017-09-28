package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToPost {

    protected Connection connection;

    private final String JDBC_DRIVER = "";
    private final String DB_URL = "";

    private final String USER = "postgres";
    private final String PASS = "";

    public void connect(){
    try {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Class.forName(JDBC_DRIVER);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public void close() throws SQLException{
        if (connection != null){
            if (!connection.isClosed()){
                connection.close();
            }
        }
    }


}
