package model.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionToPost {

    protected Connection connection;

    private final String JDBC_DRIVER = "org.postgresql.Driver";
    private final String DB_URL = "jdbc:postgresql://localhost:5432/theaterv1";

    private final String USER = "developer";
    private final String PASS = "developer123";

    public void connect(){
    try {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Class.forName(JDBC_DRIVER);
        System.out.println("Exito!");
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

    public static void main(String[] args) throws SQLException {
        new ConnectionToPost().connect();
        ConnectionToPost conn = new ConnectionToPost();

        try {
            conn.connect();
            String query = "INSERT into users (user_id, typeuser_id, email, password) VALUES (?, ?, ?,?)";
            PreparedStatement ps = conn.connection.prepareStatement(query);

            ps.setInt(1, 20);
            ps.setInt(2, 1);
            ps.setString(3, "correo@gmail.com");
            ps.setString(4, "password");
            ps.executeUpdate();

        }catch (Exception e){
            throw e;
        }finally {
            conn.close();
        }
    }


}
