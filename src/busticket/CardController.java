/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticket;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
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
public class CardController implements Initializable {

    @FXML
    private FontAwesomeIcon Back;
    @FXML
    private TextField Card_no;
    @FXML
    private PasswordField seqcode;
    @FXML
    private Label Tickiet_price;
    @FXML
    private TextField total_amount;
    @FXML
    private Label username;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void BACK(MouseEvent event) throws IOException {

        String from = From.getText();
        String t = to.getText();
        String b = busname.getText();
        String d = date.getText();
        String Time = time.getText();
        String s = seat.getText();

        String u = username.getText();

        String tic_price = Tickiet_price.getText();

        String total = total_amount.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Payment.fxml"));
        Parent root = fxmlLoader.load();

        PaymentController pay = fxmlLoader.getController();

        pay.totalPrice(total);
        pay.user_name(u);
        pay.F(from);
        pay.To(t);
        pay.Time(Time);
        pay.Seat(s);
        pay.bus(b);
        pay.date(d);
        pay.tic(tic_price);

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

        String tic_price = Tickiet_price.getText();

        String total = total_amount.getText();
        String card = Card_no.getText();
        String seq = seqcode.getText();
        if (card.equals("") && seq.equals("")) {

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
    private void bkash(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Bkash.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Payment Page");
        stage.setScene(scene);
        stage.show();

    }

    public void ticprice(String ticprice) {

        Tickiet_price.setText(ticprice);

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
