/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticket;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Random;
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
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
    @FXML
    private Label mail;
    @FXML
    private Label phone;
    @FXML
    private Label firstname;
    @FXML
    private Label lastname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void BACK(MouseEvent event) throws IOException, SQLException {

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
    private void submit(ActionEvent event) throws IOException, SQLException {

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

            Payment_unsuccessfulController unsucess = fxmlLoader.getController();
            unsucess.username(u);

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Payment Page");
            stage.setScene(scene);
            stage.show();

        } else {
            paymentcomplete();
            sendmail();
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

    public void FN(String fn) {

        firstname.setText(fn);

    }

    public void LN(String ln) {

        lastname.setText(ln);

    }

    public void Mobile(String mobile) {

        phone.setText(mobile);

    }

    public void Email(String email) {

        mail.setText(email);

    }

    public void paymentcomplete() throws SQLException {

        String F = firstname.getText();
        String l = lastname.getText();
        String e = mail.getText();
        String mobile = phone.getText();

        String total = total_amount.getText();

        String from = From.getText();
        String t = to.getText();
        String bus = busname.getText();
        String d = date.getText();

        String Time = time.getText();

        String u = username.getText();
        String s = seat.getText();
        //String tic_price = tic.getText();

        Connection con;
        try {
            PreparedStatement psInsert = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
            System.out.println("Connected");

            psInsert = con.prepareStatement("INSERT INTO Booking_history (`First_Name`,`Last_Name`,`Bus_name`,`Date`,`Time`,`Seat`,`Total_Amount`,`User_name`,`Mobile_No`,`E-mail`,`From_bus`,`To_bus`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            psInsert.setString(1, F);
            psInsert.setString(2, l);
            psInsert.setString(3, bus);
            psInsert.setString(4, d);
            psInsert.setString(5, Time);
            psInsert.setString(6, s);
            psInsert.setString(7, total);
            psInsert.setString(8, u);
            psInsert.setString(9, mobile);
            psInsert.setString(10, e);
            psInsert.setString(11, from);
            psInsert.setString(12, t);

            psInsert.executeUpdate();

        } catch (SQLException yu) {
            yu.printStackTrace();

        }

    }

    public void sendmail() {

        Properties props = System.getProperties();

        final String username = "afrainnur18@gmail.com";

        final String pass = "fydyemecbxtvfkeb";

        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.password", pass);

        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", true);

        //props.put("mail.smtp.debug", true);
        try {
            //Alert alert=new Alert(Alert.AlertType.WARNING);

            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setText("Your Booking is Successfull . Bus Name :" + busname.getText() + "     Seat Number:" + seat.getText() + "     Time:" + time.getText()+ "     Date:" + date.getText());
            message.setSubject("Payment Successfull ");
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.getText().trim()));
            message.saveChanges();
            try {

                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", username, pass);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();

                // alert.setContentText( "OTP has send to your Email id");
                //alert.show();
            } catch (Exception e) {
                e.printStackTrace();
                //alert.setContentText( "Please check your internet connection");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
