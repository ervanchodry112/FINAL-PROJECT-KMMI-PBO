package Utilities;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Helper {
    public Stage stage;
    public Scene scene;
    public Parent root;

    public Helper() {
    }
    
    public void changePage(ActionEvent event, String page){
        try {
            root = FXMLLoader.load(getClass().getResource(page));
            System.out.println("GUd");
        } catch (IOException ex) {
            System.out.println("gagal Load");
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
