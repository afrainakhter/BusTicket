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
public class UserDashBoardController implements Initializable {

    @FXML
    private Label WelCome;
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
    private void DashBoard(MouseEvent event) throws IOException {
        
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDashBoard.fxml"));
                Parent root = loader.load();
                 
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Welcome");
                stage.show();
        
    }

    @FXML
    private void Routes(MouseEvent event) throws IOException {
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserRoutes.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Book Your ticket");
        stage.setScene(scene);
        stage.show();

        
        
    }

    @FXML
    private void Buses(MouseEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("User_avilable_busOperator.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Book Your ticket");
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
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("User_Review.fxml"));
                Parent root = loader.load();
                
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Give a Review");
                stage.show();
    }

    @FXML
    private void BACK(MouseEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
                Parent root = loader.load();
               
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.show();
    }

    @FXML
    private void MyBooking(MouseEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("User_Mybooking.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Book Your ticket");
        stage.setScene(scene);
        stage.show();


        
        
    }
    
     public void displayName(String Name) {

       WelCome.setText( Name );
    }



    
    
    
}
