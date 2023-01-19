/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticket;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class TicketBookingController implements Initializable {

    @FXML
    private Label WelComeUser;
    @FXML
    private AnchorPane to;
    @FXML
    private ComboBox From;
    @FXML
    private ComboBox To;
    @FXML
    private DatePicker Date_picker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> list1 = FXCollections.observableArrayList("Rajshahi", "Chattogram", "Khulna", "Sylhet", "Barishal", "Cumilla", "Narayanganj", "Gazipur", "Bhairab", "Bogura", "Brahmanbaria", "Chandpur", "Chowmuhani", "Chuadanga", "Cumilla Sadar Dakshin", "Cox's Bazar", "Dinajpur", "Faridpur", "Feni", "Jamalpur", "Jashore", "Jhenaidah", "Kadam Rasul (Bandar)",
            
               "Kaliakair", "Kishoreganj", "Kushtia", "Maijdee", "Naogaon", "Narsingdi", "Nawabganj", "Pabna", "Saidpur", "Satkhira", "Savar", "Siddhirganj", "Sirajganj", "Sreepur", "Tangail", "Tarabo", "Tongi");
         ObservableList<String> list2 = FXCollections.observableArrayList("Dhaka");
        
        From.setItems(list2);
        To.setItems(list1);

    }

    @FXML
    private void CheckAvility(ActionEvent event) throws IOException {

////
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Seat.fxml"));
//        Parent root = loader.load();
//
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.setTitle("Select Seat ");
//        stage.show();
//       SeatController seat = loader.getController();
//       
//       
        String s1 = From.getSelectionModel().getSelectedItem().toString();
        String s2 = To.getSelectionModel().getSelectedItem().toString();
        LocalDate date = Date_picker.getValue();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Available_Bus.fxml"));
        Parent root = loader.load();

        Available_BusController available_BusController = loader.getController();

        available_BusController.show_PlaceName_from(s1);
        available_BusController.show_PlaceName_to(s2);
        available_BusController.show_date(date.toString());

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Select your Bus");
        stage.show();

    }

    @FXML
    private void RoundTrip(ActionEvent event) throws IOException {
        
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("RoundTrip.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Book Your ticket");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void OneWay(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TicketBooking.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Select Seat ");
        stage.show();
    }

   
    @FXML
    private void BACK(MouseEvent event) throws IOException {
        System.out.println("clicked");
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserDashBoard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sign up Page");
        stage.setScene(scene);
        stage.show();
        
        
    }

}
