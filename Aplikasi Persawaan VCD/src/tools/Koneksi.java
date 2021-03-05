package tools;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                MysqlDataSource dataSource = new MysqlDataSource();
                dataSource.setUser("root");
                dataSource.setPassword("");
                dataSource.setServerName("localhost");
                dataSource.setPort(3306);
                dataSource.setDatabaseName("db_vcd");
                connection = dataSource.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("koneksi gagal");
            }
        }
        return connection;
    }
    public static void main(String[] args) {

    }
}