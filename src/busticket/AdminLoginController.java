/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticket;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class AdminLoginController implements Initializable {

    @FXML
    private TextField UserNAme;
    @FXML
    private PasswordField Pass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BACK_HOME(MouseEvent event) throws IOException {
        
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void LOGIN(ActionEvent event) throws IOException {
        
        
        String u=UserNAme.getText();
        String p=Pass.getText();
        
        if(u.equals("admin")&&p.equals("admin")){
            
             
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
        }else{
        
         Alert a = new Alert(Alert.AlertType.WARNING);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText("Worng PassWord");
                a.show();
                UserNAme.setText("");
                Pass.setText("");
        
        }
        
       
        
        
    }

    @FXML
    private void forget_pass(ActionEvent event) {
    }

    
}
