
package pkgfinal.project;

import db.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class nasabahDataModel {
    private final Connection conn;

    public nasabahDataModel(String driver) throws SQLException {
        this.conn = DBHelper.getConnection(driver);
    }
    
    public void addNasabah(Individu nasabah) throws SQLException{
        String insertNasabah = "INSERT INTO nasabah (id_nasabah, nama, alamat)"
                + " VALUES (?,?,?)";
        String insertIndividu = "INSERT INTO individu (id_nasabah, nik, npwp)"
                + " VALUES (?,?,?)";
        String insertRekening = "INSERT INTO rekening (no_rekening, saldo, id_nasabah)"
                + " VALUES (?,?,?)";
        
        PreparedStatement stmtNasabah = conn.prepareStatement(insertNasabah);
        stmtNasabah.setInt(1, nasabah.getId_nasabah());
        stmtNasabah.setString(2, nasabah.getNama());
        stmtNasabah.setString(3, nasabah.getAlamat());
        stmtNasabah.execute();
        
        PreparedStatement stmtIndividu = conn.prepareStatement(insertIndividu);
        stmtIndividu.setInt(1, nasabah.getId_nasabah());
        stmtIndividu.setLong(2, nasabah.getNik());
        stmtIndividu.setLong(3, nasabah.getNpwp());
        stmtIndividu.execute();
        
        PreparedStatement stmtRekening = conn.prepareStatement(insertRekening);
        stmtRekening.setInt(1, nasabah.getRekening().get(0).getNoRekening());
        stmtRekening.setDouble(2, nasabah.getRekening().get(0).getSaldo());
        stmtRekening.setInt(3, nasabah.getId_nasabah());
        stmtRekening.execute();
    }
    
    
}
