/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticket;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Payment_successfullController implements Initializable {

    @FXML
    private AnchorPane Dhaka_to_Dinajpur;
    @FXML
    private FontAwesomeIcon Back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BACK(MouseEvent event) {
    }

    @FXML
    private void Exit(ActionEvent event) throws IOException {
        
        
          
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
        
          
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserDashBoard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void receipt_Printer(ActionEvent event) {
    }
    
}
