package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHelper {
    private static final String DB = "koperasi";
    private static final String SQCONN = "jdbc:sqlite:D:\\Github\\Java\\FINAL-PROJECT-KMMI-PBO\\koperasi.sqlite";
    
    public static Connection getConnection(String driver) throws SQLException{
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(SQCONN);
        } catch (ClassNotFoundException ex) {
            System.out.print("Library tidak ada");
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
}