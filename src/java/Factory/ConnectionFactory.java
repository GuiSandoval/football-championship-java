package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws SQLException {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/brazuca",
                    "root",
                    "uniceub");
            System.out.println("Conectado!");

            return con;

        } catch (SQLException ex) {
            throw new SQLException("Não foi possível conectar ao servidor", ex);
        }
    }
}
