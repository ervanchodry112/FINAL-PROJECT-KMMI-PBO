
package pkgfinal.project;

import db.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class nasabahDataModel {
    public final Connection conn;

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
    
    public void addNasabah(Perusahaan nasabah) throws SQLException{
        String insertNasabah = "INSERT INTO nasabah (id_nasabah, nama, alamat)"
                + " VALUES (?,?,?)";
        String insertPerusahaan = "INSERT INTO perusahaan (id_nasabah, nib)"
                + " VALUES (?,?)";
        String insertRekening = "INSERT INTO rekening (no_rekening, saldo, id_nasabah)"
                + " VALUES (?,?,?)";
        
        PreparedStatement stmtNasabah = conn.prepareStatement(insertNasabah);
        stmtNasabah.setInt(1, nasabah.getId_nasabah());
        stmtNasabah.setString(2, nasabah.getNama());
        stmtNasabah.setString(3, nasabah.getAlamat());
        stmtNasabah.execute();
        
        PreparedStatement stmtPerusahaan = conn.prepareStatement(insertPerusahaan);
        stmtPerusahaan.setInt(1, nasabah.getId_nasabah());
        stmtPerusahaan.setString(2, nasabah.getNib());
        stmtPerusahaan.execute();
        
        PreparedStatement stmtRekening = conn.prepareStatement(insertRekening);
        stmtRekening.setInt(1, nasabah.getRekening().get(0).getNoRekening());
        stmtRekening.setDouble(2, nasabah.getRekening().get(0).getSaldo());
        stmtRekening.setInt(3, nasabah.getId_nasabah());
        stmtRekening.execute();
    }
    
    public ObservableList<Individu> getIndividu() throws SQLException{
        ObservableList<Individu> data = FXCollections.observableArrayList();
        String sql = "SELECT id_nasabah, nama, alamat, nik, npwp "
                + "FROM nasabah NATURAL JOIN individu "
                + "ORDER BY id_nasabah";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            String sqlRek = "SELECT no_rekening, saldo "
                    + "FROM rekening WHERE id_nasabah=" +rs.getInt(1);
            ResultSet rsRek = conn.createStatement().executeQuery(sqlRek);
            ArrayList <Rekening> dataRekening = new ArrayList<Rekening>();
            while(rsRek.next()){
                dataRekening.add(new Rekening(rsRek.getInt(1), rsRek.getDouble(2)));
            }
            data.add(new Individu(rs.getLong(4), rs.getLong(5) , rs.getInt(1),
                    rs.getString(2), rs.getString(3), dataRekening));
        }
        return data;
    }
    
    public ObservableList<Perusahaan> getPerusahaan() throws SQLException{
        ObservableList<Perusahaan> data = FXCollections.observableArrayList();
        String sql = "SELECT id_nasabah, nama, alamat, nib "
                + "FROM nasabah NATURAL JOIN perusahaan "
                + "ORDER BY id_nasabah";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            String sqlRek = "SELECT no_rekening, saldo "
                    + "FROM rekening WHERE id_nasabah=" +rs.getInt(1);
            ResultSet rsRek = conn.createStatement().executeQuery(sqlRek);
            ArrayList <Rekening> dataRekening = new ArrayList<Rekening>();
            while(rsRek.next()){
                dataRekening.add(new Rekening(rsRek.getInt(1), rsRek.getDouble(2)));
            }
            data.add(new Perusahaan(rs.getString(4), rs.getInt(1), rs.getString(2), rs.getString(3), dataRekening));
        }
        return data;
    }
    
    public ObservableList<Rekening> getRekening(int idNasabah) throws SQLException{
        ObservableList<Rekening> data = FXCollections.observableArrayList();
        String sql = "SELECT no_rekening, saldo "
                + "FROM rekening "
                + "WHERE id_nasabah="+idNasabah;
        
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            data.add(new Rekening(rs.getInt(1), rs.getDouble(2)));
        }
        return data;
    }
    
    public int nextIdNasabah() throws SQLException{
        String sql = "SELECT MAX (id_nasabah) FROM nasabah";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            return rs.getInt(1)==0?1000001:rs.getInt(1)+1;
        }
        return 1000001;
    }
    
    public int nextNoRekening(int idNasabah) throws SQLException{
        String sql = "SELECT MAX (no_rekening) FROM rekening WHERE id_nasabah="+idNasabah;
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            return rs.getInt(1)+1;
        }
        return 0;
    }
    
    public void addRekening(int id_nasabah, Rekening rekening) throws SQLException{
        String insertRekening = "INSERT INTO rekening (id_nasabah, no_rekening, saldo)"
                + " VALUES (?,?,?)";
        
        PreparedStatement stmtRekening = conn.prepareStatement(insertRekening);
        stmtRekening.setInt(1, id_nasabah);
        stmtRekening.setInt(2, rekening.getNoRekening());
        stmtRekening.setDouble(3, rekening.getSaldo());
        stmtRekening.execute();
    }
    
    public void updateSaldoTarikTunai(double saldo, int no_rekening){
        try {
            String sql = "UPDATE rekening SET saldo = " + saldo
                    + " WHERE no_rekening = " + no_rekening;
            
            PreparedStatement stmtUpdate = conn.prepareStatement(sql);
            stmtUpdate.execute();
        } catch (SQLException ex) {
            Logger.getLogger(nasabahDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
