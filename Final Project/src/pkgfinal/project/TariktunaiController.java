/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TariktunaiController implements Initializable {

    @FXML
    private Button btndeposit;

    @FXML
    private Button btntunai;

    @FXML
    private Label failed;

    @FXML
    private Label succes;

    @FXML
    private TextField tfIDNasabah;

    @FXML
    private TextField txtnominal;

    @FXML
    private TextField txtrek;
    
    @FXML
    private TextField tfSaldo;
    
    private nasabahDataModel ndm;
    private Rekening globRek;
    
    public void setGlobRek(Rekening rek){
        this.globRek = rek;
    }

    @FXML
    void handledeposit(ActionEvent event) {
        double saldoAwal = globRek.getSaldo();
        double nominal = Double.parseDouble(txtnominal.getText());
        double temp = saldoAwal + nominal;
        try{
            String sql = " UPDATE rekening SET saldo = " + temp
                + " WHERE no_rekening = " + globRek.getNoRekening();
            
            PreparedStatement stmtUpdate = ndm.conn.prepareStatement(sql);
            stmtUpdate.execute();
            stmtUpdate.close();
            failed.setText("");
            succes.setText("Saldo Berhasil Di Update");
                
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    @FXML
    void handletarik(ActionEvent event) {
        double saldoAwal = Double.parseDouble(tfSaldo.getText());
        double nominal = Double.parseDouble(txtnominal.getText());
        double temp = saldoAwal - nominal;
        if(saldoAwal < nominal){
            failed.setText("Saldo anda tidak mencukupi!");
            succes.setText("");
        }else{
            try{
                String sql = "UPDATE rekening SET saldo = " + temp
                    + " WHERE no_rekening = " + txtrek.getText();
            
                PreparedStatement stmtUpdate = ndm.conn.prepareStatement(sql);
                stmtUpdate.execute();
                failed.setText("");
                succes.setText("Saldo Berhasil Di Update");
                
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            
        }
    }
    
    public void showInformation(String id_nasabah, Rekening rekening){
        tfIDNasabah.setText(id_nasabah);
        txtrek.setText(""+rekening.getNoRekening());
        tfSaldo.setText(""+rekening.getSaldo());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
