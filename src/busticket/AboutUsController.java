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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class AboutUsController implements Initializable {

    @FXML
    private Button home;
    @FXML
    private Button contactUs;
    @FXML
    private Hyperlink about_US_learn_more;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homw(ActionEvent event) {
    }

    @FXML
    private void contactUs(ActionEvent event) {
    }

    @FXML
    private void about_US_learn_more(ActionEvent event) {
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Home.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
        
        
    }
    
}
