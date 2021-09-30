package pkgfinal.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
   @FXML
    private TextField tfIDNasabah;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfAlamat;

    @FXML
    private TextField tfNIK;

    @FXML
    private TextField tfNPWP;

    @FXML
    private TextField tfNoRekening;

    @FXML
    private TextField tfSaldoRekening;

    @FXML
    private Label labelSaveStatus;

    @FXML
    private Button btnTambahAkun;

    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnClear;

    @FXML
    private TableView<?> tabelNasabahIndividu;

    @FXML
    private TableColumn<?, ?> kolomID;

    @FXML
    private TableColumn<?, ?> kolomNama;

    @FXML
    private TableColumn<?, ?> kolomAlamat;

    @FXML
    private TableColumn<?, ?> kolomNIK;

    @FXML
    private TableColumn<?, ?> kolomNPWP;

    @FXML
    private TableColumn<?, ?> kolomJumlahRekening;

    @FXML
    private TableView<?> tabelRekening;

    @FXML
    private TableColumn<?, ?> kolomNoRekening;

    @FXML
    private TableColumn<?, ?> kolomSaldo;

    @FXML
    private TextField tfIDNasbahBaru;

    @FXML
    private TextField tfNoRekeningBaru;

    @FXML
    private TextField tfSaldoRekeningBaru;

    @FXML
    private Button btnTambahRekening;

    @FXML
    private TextField tfIDNasabah1;

    @FXML
    private TextField tfNama1;

    @FXML
    private TextField tfAlamat1;

    @FXML
    private TextField tfNIB;

    @FXML
    private TextField tfNoRekening1;

    @FXML
    private TextField tfSaldoRekening1;

    @FXML
    private Label labelSaveStatus1;

    @FXML
    private Button btnTambahAkun1;

    @FXML
    private Button btnRefresh1;

    @FXML
    private Button btnClear1;

    @FXML
    private TableView<?> tabelNasabahIndividu1;

    @FXML
    private TableColumn<?, ?> kolomID1;

    @FXML
    private TableColumn<?, ?> kolomNama1;

    @FXML
    private TableColumn<?, ?> kolomAlamat1;

    @FXML
    private TableColumn<?, ?> kolomNIB;

    @FXML
    private TableColumn<?, ?> kolomJumlahRekening1;

    @FXML
    private TableView<?> tabelRekening1;

    @FXML
    private TableColumn<?, ?> kolomNoRekening1;

    @FXML
    private TableColumn<?, ?> kolomSaldo1;

    @FXML
    private TextField tfIDNasbahBaru1;

    @FXML
    private TextField tfNoRekeningBaru1;

    @FXML
    private TextField tfSaldoRekeningBaru1;

    @FXML
    private Button btnTambahRekening1;

    @FXML
    private Label statusDatabase;

    @FXML
    void HandleButtonClear(ActionEvent event) {

    }

    @FXML
    void HandleButtonRefresh(ActionEvent event) {

    }

    @FXML
    void HandleButtonTambahAkun(ActionEvent event) {

    }

    @FXML
    void HandleButtonTambahRekening(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
