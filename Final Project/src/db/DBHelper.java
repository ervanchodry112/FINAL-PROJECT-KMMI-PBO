package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            createTable(conn);
        } catch (ClassNotFoundException ex) {
            System.out.print("Library tidak ada");
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
    public static void createTable(Connection conn) throws SQLException{
        String sqlCreate = "";
        sqlCreate = "CREATE TABLE IF NOT EXISTS  nasabah (" +
                "    id_nasabah INT (10)      PRIMARY KEY," +
                "    nama      VARCHAR (100)," +
                "    alamat   VARCHAR (300) " +
                ");" +
                "CREATE TABLE IF NOT EXISTS rekening (" +
                "    no_rekening INT (10)    PRIMARY KEY," +
                "    saldo    DOUBLE (16)," +
                "    id_nasabah  INT (10)    REFERENCES nasabah (id_nasabah) ON DELETE RESTRICT" +
                "                                                                 ON UPDATE CASCADE" +
                ");" +
                "CREATE TABLE IF NOT EXISTS perusahaan (" +
                "    id_nasabah INT (10)      PRIMARY KEY" +
                "                            REFERENCES nasabah (id_nasabah) ON DELETE RESTRICT" +
                "                                                                  ON UPDATE CASCADE," +
                "    nib   VARCHAR (50) " +
                ");" +
                "CREATE TABLE IF NOT EXISTS  individu (" +
                "    id_nasabah INT (10)     PRIMARY KEY" +
                "                           REFERENCES nasabah (id_nasabah) ON DELETE RESTRICT" +
                "                                                                 ON UPDATE CASCADE," +
                "    nik    INTEGER (16)," +
                "    npwp   INTEGER" +
                ");";
        
        String sqls[] = sqlCreate.split(";");
        for(String sql : sqls){
            PreparedStatement stmtNasabah = conn.prepareStatement(sql);
            stmtNasabah.execute();
        }
    }
}