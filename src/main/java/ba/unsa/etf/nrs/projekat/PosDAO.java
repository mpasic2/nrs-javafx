package ba.unsa.etf.nrs.projekat;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PosDAO {
    private static PosDAO instance;
    private static Connection conn;
    private static final String bazaurl = "http://34.65.74.184:1000/";


    public static PosDAO getInstance() {
        if (instance == null) instance = new PosDAO();
        return instance;
    }

    public static Connection getConn() {
        return conn;
    }

    public static void removeInstance() {
        if (instance == null) return;
        instance.close();
        instance = null;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private PosDAO() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            int port = 1000;
            String dbUsername = "root";
            String dbPassword = "root";
            String sqlDialect = "mysql";
            String host = "localhost";
            String dbName = "bazakasa";
            String useSSL = "false";

            String url = "jdbc:" + sqlDialect + "://" + host + ":" + port + "/" + dbName + "?useSSL=" + useSSL;
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }





}
