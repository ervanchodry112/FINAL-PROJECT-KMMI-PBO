package pkgfinal.project;

import db.DBHelper;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FinalProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //        launch(args);
        try {
            Rekening rek = new Rekening(12, 100000.);
            nasabahDataModel ndm = new nasabahDataModel("SQLITE");
            Perusahaan temp = new Perusahaan("12435", 2, "Budi", "Kota Balam", rek);
            ndm.addNasabah(temp);
            System.out.println("Data berhasil ditambahkan");
        } catch (SQLException ex) {
            System.out.println("Gagal menambahkan!");
            Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}
