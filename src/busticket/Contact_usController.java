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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class Contact_usController implements Initializable {

    @FXML
    private ComboBox<?> ChoiceBox;
    @FXML
    private ComboBox<?> ChoiceBox1;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        // TODO
    }    

    @FXML
    private void Select(ActionEvent event) {
    }

    @FXML
    private void Selection(ActionEvent event) {
    }

    @FXML
    private void BACK(MouseEvent event) throws IOException {
        
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Home.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sign up Page");
        stage.setScene(scene);
        stage.show();
        
        
    }
    
}
