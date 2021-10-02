
package pkgfinal.project;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Utilities.Helper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginController implements Initializable {

    @FXML 
    private TextField txtUsername;
    @FXML 
    private PasswordField txtPassword;
    @FXML 
    private Button txtBtnlogin;
    @FXML
    private Label infotxt;
    @FXML
    private Label succes;
    
    @FXML
    public void handleButton(ActionEvent event){
        Stage stage;
        Scene scene;
        Parent root;
        if(checkLogin()){
            try {
                root = FXMLLoader.load(getClass().getResource("NasabahForm.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                System.out.println("GUd");
            } catch (IOException ex) {
                System.out.println("gagal Load");
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private boolean checkLogin(){
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        if (username.equals("admin") && password.equals("12345")){
            succes.setText("Succes!");
            return true;
        } else {
            infotxt.setText("Wrong!\nUsername : admin\nPassword : 12345");
            return false; 
        }
    }
          
   
}
