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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class User_MybookingController implements Initializable {

    @FXML
    private Label WelCome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    
    }    

    @FXML
    private void DashBoard(MouseEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserDashBoard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("DashBoard");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Routes(MouseEvent event) throws IOException {
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserRoutes.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Find Routes");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Buses(MouseEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("User_avilable_busOperatorController.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Check Your Booking");
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void MyBooking(MouseEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("User_Mybooking.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Check Your Booking");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void TicketBooking(MouseEvent event) throws IOException {
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("TicketBooking.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Book Your ticket");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Review(MouseEvent event) throws IOException {
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserReview.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Give a Review");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Back(MouseEvent event) throws IOException {
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserDashBoard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Dash Board");
        stage.setScene(scene);
        stage.show();

        
        
        
    }
    
}
