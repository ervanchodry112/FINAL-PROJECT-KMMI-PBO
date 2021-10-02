/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    private TextField txtrekdep;
    @FXML
    private TextField txtrektun;
    @FXML
    private TextField txtnominaldep;
    @FXML
    private TextField txtnominaltun;
    @FXML
    private Button btntarik;
    @FXML
    private Button btndeposit;
    @FXML
    private TextField txtpassword;
    @FXML 
    private Label succes;
    @FXML
    private Label failed;
    @FXML 
    private Label succes2;
    @FXML
    private Label failed2;
    
    
    public void handletarik(ActionEvent event) throws IOException{
      checktarik();
    }

   
    private void checktarik() throws IOException {
         String rektun = txtrektun.getText();
         String password = txtpassword.getText();
         String nominaltun= txtnominaltun.getText();
     
        if (password.equals("12345")){
            succes.setText("Succes!");
        } else {
            failed.setText("Transaction Failed!");
        }  
    }
   
   
    public void handledeposit(ActionEvent event) throws IOException{
      checkdeposit();
    }

   
    private void checkdeposit() throws IOException {
         String rektun = txtrekdep.getText();
         String nominaltun= txtnominaldep.getText();
        
         //if ()){
            succes2.setText("Succes!");
        ///} else {
      //      failed2.setText("Transaction Failed!");
      //  }  
    }
    
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
