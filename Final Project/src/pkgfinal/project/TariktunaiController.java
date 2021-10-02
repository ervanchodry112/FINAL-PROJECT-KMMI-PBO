/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.io.IOException;
import java.net.URL;
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
    void handledeposit(ActionEvent event) {

    }

    @FXML
    void handletarik(ActionEvent event) {

    }
    
    public void showInformation(String id_nasabah, String no_rekening){
        tfIDNasabah.setText(id_nasabah);
        txtrek.setText(no_rekening);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
