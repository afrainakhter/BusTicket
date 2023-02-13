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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class Front_AboutUSController implements Initializable {

    @FXML
    private Button log_In;
    @FXML
    private Button contact_us;
    @FXML
    private Button about_us;
    @FXML
    private Button register;
    @FXML
    private FontAwesomeIcon RH;
    @FXML
    private FontAwesomeIcon AH;
    @FXML
    private FontAwesomeIcon CH;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void log_In(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void contact_us(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Contact_us.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void about_us(ActionEvent event) throws IOException {
        
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("AboutUs.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void register(ActionEvent event) throws IOException {
        
        
        
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Register.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

   

    @FXML
    private void aboutHome(MouseEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Front_AboutUS.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Admin Login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void contactHome(MouseEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Front_Contact.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Admin Login");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void home(MouseEvent event) throws IOException {
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Home.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
    }
    
}
