
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void handleButton(ActionEvent event) throws IOException{
      checkLogin();
    }
    

    private void checkLogin() throws IOException {
         String username = txtUsername.getText();
         String password = txtPassword.getText();
        if (username.equals("namasaya") && password.equals("12345")){
            succes.setText("Succes!");
        } else {
            infotxt.setText("Wrong User Password or User Name");
        }  
    }
          
   
}
