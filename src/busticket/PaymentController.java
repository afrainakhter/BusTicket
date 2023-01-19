/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticket;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class PaymentController implements Initializable {

    @FXML
    private TextField FirstName;
    @FXML
    private TextField Mobile;
    @FXML
    private TextField LastName;
    @FXML
    private TextField Email;
    @FXML
    private ComboBox Payment;
    @FXML
    private Label Amount;
    String m;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> list1 = FXCollections.observableArrayList("Card", "Bkash");
        Payment.setItems(list1);
        // TODO
    }

    @FXML
    private void Procced_to_pay_button(ActionEvent event) throws IOException, SQLException {

        String F = FirstName.getText();
        String l = LastName.getText();
        String e = Email.getText();
        String mobile = Mobile.getText();
        Connection con;
        PreparedStatement psInsert = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("Connected");

        psInsert = con.prepareStatement("INSERT INTO Payment (FirstName,Last_name,MoblieNo,Email)VALUES(?,?,?,?)");
        psInsert.setString(1, F);
        psInsert.setString(2, l);
        psInsert.setString(3, e);
        psInsert.setString(4, mobile);
        psInsert.executeUpdate();
        m = Payment.getSelectionModel().getSelectedItem().toString();

        if (m == "Card") {

            FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Card.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Sign up Page");
            stage.setScene(scene);
            stage.show();

        } else {

            FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Bkash.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Sign up Page");
            stage.setScene(scene);
            stage.show();

        }

    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Payment.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sign up Page");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Back(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Seat.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sign up Page");
        stage.setScene(scene);
        stage.show();
    }

}
