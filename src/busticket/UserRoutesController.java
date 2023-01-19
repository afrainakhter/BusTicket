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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class UserRoutesController implements Initializable {

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
    private void Buses(MouseEvent event) {
        
    }

    @FXML
    private void MyBooking(MouseEvent event) {
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
         FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDashBoard.fxml"));
                Parent root = loader.load();
               
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.show();
        
    }

    @FXML
    private void Dhaka_to_Dinajpur(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Thakurgaon(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Satkhira(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Hili(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Bandarban(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Rangamati(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Kushtia(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Khulna(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Khagrachari(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Rajshahi(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Jhenaidah(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Kurigram(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Darshana(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Rangpur(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Joypurhat(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Gopalganj(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Barisal(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Sreemangal(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Jessore(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Teknaf(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Chittagong(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Bogra(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Coxs_Bazar(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Panchagor(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Kolkata(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Gaibandha(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Nilphamari(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Feni(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Naogaon(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Chapai_Nawabganj(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Sylhet(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Moulvibazar(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Nazirhat(MouseEvent event) {
    }

    @FXML
    private void Dhaka_to_Brahmanbaria(MouseEvent event) {
    }
    
}
