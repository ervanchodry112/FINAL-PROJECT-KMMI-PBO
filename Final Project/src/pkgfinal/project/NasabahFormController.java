package pkgfinal.project;

import java.awt.MenuItem;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class NasabahFormController implements Initializable{

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClear1;

    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnRefresh1;

    @FXML
    private Button btnTambahAkun;

    @FXML
    private Button btnTambahAkun1;

    @FXML
    private Button btnTambahRekening;

    @FXML
    private Button btnTambahRekening1;

    @FXML
    private TableColumn<Individu, String> kolomAlamat;

    @FXML
    private TableColumn<Perusahaan, String> kolomAlamat1;

    @FXML
    private TableColumn<Individu, Integer> kolomID;

    @FXML
    private TableColumn<Perusahaan, Integer> kolomID1;

    @FXML
    private TableColumn<Individu, Integer> kolomJumlahRekening;

    @FXML
    private TableColumn<Perusahaan, Integer> kolomJumlahRekening1;

    @FXML
    private TableColumn<Perusahaan, String> kolomNIB;

    @FXML
    private TableColumn<Individu, Long> kolomNIK;

    @FXML
    private TableColumn<Individu, Long> kolomNPWP;

    @FXML
    private TableColumn<Individu, String> kolomNama;

    @FXML
    private TableColumn<Perusahaan, String> kolomNama1;

    @FXML
    private TableColumn<Rekening, Integer> kolomNoRekening;

    @FXML
    private TableColumn<Rekening, Integer> kolomNoRekening1;

    @FXML
    private TableColumn<Rekening, Double> kolomSaldo;

    @FXML
    private TableColumn<Rekening, Double> kolomSaldo1;

    @FXML
    private Label labelSaveStatus;

    @FXML
    private Label labelSaveStatus1;

    @FXML
    private Label statusDatabase;

    @FXML
    private TableView<Individu> tabelNasabahIndividu;

    @FXML
    private TableView<Perusahaan> tabelNasabahPerusahaan;

    @FXML
    private TableView<Rekening> tabelRekening;

    @FXML
    private TableView<Rekening> tabelRekening1;

    @FXML
    private TextField tfAlamat;

    @FXML
    private TextField tfAlamat1;

    @FXML
    private TextField tfIDNasabah;

    @FXML
    private TextField tfIDNasabah1;

    @FXML
    private TextField tfIDNasabahBaru;

    @FXML
    private TextField tfIDNasabahBaru1;

    @FXML
    private TextField tfNIB;

    @FXML
    private TextField tfNIK;

    @FXML
    private TextField tfNPWP;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfNama1;

    @FXML
    private TextField tfNoRekening;

    @FXML
    private TextField tfNoRekening1;

    @FXML
    private TextField tfNoRekeningBaru;

    @FXML
    private TextField tfNoRekeningBaru1;

    @FXML
    private TextField tfSaldoRekening;

    @FXML
    private TextField tfSaldoRekening1;

    @FXML
    private TextField tfSaldoRekeningBaru;

    @FXML
    private TextField tfSaldoRekeningBaru1;
    
    private nasabahDataModel ndm;

    @FXML
    void HandleButtonClear(ActionEvent event) {
        try {
            tfIDNasabah.setText("" + ndm.nextIdNasabah());
            tfNoRekening.setText("" + tfIDNasabah.getText() + "01");
            tfNama.setText("");
            tfAlamat.setText("");
            tfNIK.setText("");
            tfNPWP.setText("");
            tfSaldoRekening.setText("");
            labelSaveStatus.setText("");
        } catch (SQLException ex) {
            System.out.println(ex); 
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void HandleButtonRefresh(ActionEvent event){
        try {
            ObservableList<Individu> data = ndm.getIndividu();
            kolomID.setCellValueFactory(new PropertyValueFactory<>("id_nasabah"));
            kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
            kolomAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
            kolomNIK.setCellValueFactory(new PropertyValueFactory<>("nik"));
            kolomNPWP.setCellValueFactory(new PropertyValueFactory<>("npwp"));
            tabelNasabahIndividu.setItems(null);
            tabelNasabahIndividu.setItems(data);
            btnTambahRekening.setDisable(true);
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void HandleButtonTambahAkun(ActionEvent event) {
        Individu nasIndividu = new Individu(Long.parseLong(tfNIK.getText()), Long.parseLong(tfNPWP.getText()),
               Integer.parseInt(tfIDNasabah.getText()), tfNama.getText(), tfAlamat.getText(),
               new Rekening(Integer.parseInt(tfNoRekening.getText()), Double.parseDouble(tfSaldoRekening.getText())));
        try{
            ndm.addNasabah(nasIndividu);
            labelSaveStatus.setText("Data Berhasil ditambahkan");
            btnRefresh.fire();
            btnClear.fire();
        }
        catch(Exception ex){
            labelSaveStatus.setText("Gagal menambahkan akun");
        }
    }

    @FXML
    void HandleButtonTambahRekening(ActionEvent event) {
        try {
            ndm.addRekening(Integer.parseInt(tfIDNasabahBaru.getText()),
                    new Rekening(Integer.parseInt(tfNoRekeningBaru.getText()),
                            Double.parseDouble(tfSaldoRekeningBaru.getText())));
            
            viewDataRekening(Integer.parseInt(tfIDNasabahBaru.getText()));
            btnRefresh.fire();
            tfSaldoRekeningBaru.setText("");
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void HandleButtonTambahAkunPerusahaan(ActionEvent event) {
        Perusahaan nasPerusahaan = new Perusahaan(tfNIB.getText(),
               Integer.parseInt(tfIDNasabah1.getText()), tfNama1.getText(), tfAlamat1.getText(),
               new Rekening(Integer.parseInt(tfNoRekening1.getText()), Double.parseDouble(tfSaldoRekening1.getText())));
        try{
            ndm.addNasabah(nasPerusahaan);
            labelSaveStatus1.setText("Data Berhasil ditambahkan");
            btnRefresh1.fire();
            btnClear1.fire();
        }
        catch(Exception ex){
            labelSaveStatus1.setText("Gagal menambahkan akun");
        }
    }
    
    @FXML
    void HandleButtonRefreshPerusahaan(ActionEvent event){
        try {
            ObservableList<Perusahaan> data = ndm.getPerusahaan();
            kolomID1.setCellValueFactory(new PropertyValueFactory<>("id_nasabah"));
            kolomNama1.setCellValueFactory(new PropertyValueFactory<>("nama"));
            kolomAlamat1.setCellValueFactory(new PropertyValueFactory<>("alamat"));
            kolomNIB.setCellValueFactory(new PropertyValueFactory<>("nib"));
            tabelNasabahPerusahaan.setItems(null);
            tabelNasabahPerusahaan.setItems(data);
            btnTambahRekening1.setDisable(true);
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void HandleButtonClearPerusahaan(ActionEvent event) {
        try {
            tfIDNasabah1.setText("" + ndm.nextIdNasabah());
            tfNoRekening1.setText("" + tfIDNasabah1.getText() + "01");
            tfNama1.setText("");
            tfAlamat1.setText("");
            tfNIB.setText("");
            tfSaldoRekening1.setText("");
            labelSaveStatus1.setText("");
        } catch (SQLException ex) {
            System.out.println(ex); 
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void HandleButtonTambahRekeningPerusahaan(ActionEvent event) {
        try {
            ndm.addRekening(Integer.parseInt(tfIDNasabahBaru1.getText()),
                    new Rekening(Integer.parseInt(tfNoRekeningBaru1.getText()),
                            Double.parseDouble(tfSaldoRekeningBaru1.getText())));
            
            viewDataRekeningPerusahaan(Integer.parseInt(tfIDNasabahBaru1.getText()));
            btnRefresh1.fire();
            tfSaldoRekeningBaru1.setText("");
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ndm = new nasabahDataModel("SQLITE");
            statusDatabase.setText(ndm.conn==null?"Not Connected":"Connected");
            btnClear.fire();
            btnClear1.fire();
            btnRefresh.fire();
            btnRefresh1.fire();
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tabelNasabahIndividu.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if(tabelNasabahIndividu.getSelectionModel().getSelectedItem()!=null){
                Individu nasabah = tabelNasabahIndividu.getSelectionModel().getSelectedItem();
                viewDataRekening(nasabah.getId_nasabah());
                btnTambahRekening.setDisable(false);
                tfIDNasabahBaru.setText(""+nasabah.getId_nasabah());
                try {
                    tfNoRekeningBaru.setText(""+ndm.nextNoRekening(nasabah.getId_nasabah()));
                } catch (SQLException ex) {
                    Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        tabelNasabahPerusahaan.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if(tabelNasabahPerusahaan.getSelectionModel().getSelectedItem()!=null){
                Perusahaan nasabah = tabelNasabahPerusahaan.getSelectionModel().getSelectedItem();
                viewDataRekeningPerusahaan(nasabah.getId_nasabah());
                btnTambahRekening1.setDisable(false);
                tfIDNasabahBaru1.setText(""+nasabah.getId_nasabah());
                try {
                    tfNoRekeningBaru1.setText(""+ndm.nextNoRekening(nasabah.getId_nasabah()));
                } catch (SQLException ex) {
                    Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void viewDataRekening(int id_nasabah){
        try {
            ObservableList<Rekening> data = ndm.getRekening(id_nasabah);
            kolomNoRekening.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
            kolomSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
            tabelRekening.setItems(null);
            tabelRekening.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void viewDataRekeningPerusahaan(int id_nasabah){
        try {
            ObservableList<Rekening> data = ndm.getRekening(id_nasabah);
            kolomNoRekening1.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
            kolomSaldo1.setCellValueFactory(new PropertyValueFactory<>("saldo"));
            tabelRekening1.setItems(null);
            tabelRekening1.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
