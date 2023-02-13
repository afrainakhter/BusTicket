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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class BkashController implements Initializable {

    @FXML
    private FontAwesomeIcon Back;
    @FXML
    private TextField bkash_no;
    @FXML
    private PasswordField pin_no;
    @FXML
    private TextField total_amount;
    @FXML
    private Label to;
    @FXML
    private Label From;
    @FXML
    private Label date;
    @FXML
    private Label busname;
    @FXML
    private Label time;
    @FXML
    private Label seat;
    @FXML
    private Label username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void BACK(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Payment.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Payment Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submit(ActionEvent event) throws IOException {

        String from = From.getText();
        String t = to.getText();
        String b = busname.getText();
        String d = date.getText();
        String Time = time.getText();
        String s = seat.getText();

        String u = username.getText();

        //String tic_price = Tickiet_price.getText();
        String total = total_amount.getText();
        // String card = Card_no.getText();
        // String seq = seqcode.getText();

        String bkash = bkash_no.getText();
        String pass = pin_no.getText();

        if (bkash.equals("") && pass.equals("")) {
            FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Payment_unsuccessful.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Payment Page");
            stage.setScene(scene);
            stage.show();
        } else {

            FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("payment_successfull.fxml"));
            Parent root = fxmlLoader.load();

            Payment_successfullController succ = fxmlLoader.getController();
            succ.username(u);
            succ.bus(b);
            succ.busfrom(from);
            succ.time(Time);
            succ.date(d);
            succ.seat(s);
            succ.busTO(t);

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Payment Page");
            stage.setScene(scene);
            stage.show();

        }
    }

    @FXML
    private void Card(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Card.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Card Page");
        stage.setScene(scene);
        stage.show();

    }

    public void totalPrice(String totalprice) {

        total_amount.setText(totalprice);

    }

    public void username(String user_name) {

        username.setText(user_name);

    }

    public void busTO(String tobus) {

        to.setText(tobus);

    }

    public void busfrom(String frombus) {

        From.setText(frombus);

    }

    public void date(String d) {

        date.setText(d);

    }

    public void bus(String b) {

        busname.setText(b);

    }

    public void seat(String s) {

        seat.setText(s);

    }

    public void time(String Time) {

        time.setText(Time);

    }

}
