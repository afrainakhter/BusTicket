/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticket;

import java.util.Properties;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField UserName;
    @FXML
    private PasswordField PassWord;

    @FXML
    private TextField SeqQues;
    @FXML
    private TextField Ans;
     @FXML
    private TextField Mobile;

    @FXML
    private TextField Email;
    @FXML
    private Label hide;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Register(ActionEvent event) throws SQLException, IOException {
        Random();
     
        String u = UserName.getText();
        String F = FirstName.getText();
        String L = LastName.getText();
        String email = Email.getText();
        String p = PassWord.getText();
        String h = hide.getText();
         String M = hide.getText();
//        String SEQ = SeqQues.getText();
//        String ANS = Ans.getText();

        Connection connection;

        PreparedStatement psInsert = null;

        PreparedStatement psCheckUserExists;
        ResultSet resultset;

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("Connected");
        psCheckUserExists = connection.prepareStatement("SELECT * FROM login WHERE user_name = ?");
        psCheckUserExists.setString(1, u);
        resultset = psCheckUserExists.executeQuery();

        if (resultset.isBeforeFirst()) {

            System.out.println("User already exist");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You can't use this UserName");

            alert.show();

            UserName.setText("");
            FirstName.setText("");
            LastName.setText("");
            PassWord.setText("");
            Email.setText("");
            Mobile.setText("");
//            SeqQues.setText("");
//            Ans.setText("");

        } else {

            psInsert = connection.prepareStatement("INSERT INTO login (user_name, password, FirstName, LastName, email,mobile) VALUES (?, ?, ?, ?, ?, ?)");
            psInsert.setString(1, u);
            psInsert.setString(2, p);
            psInsert.setString(3, F);
            psInsert.setString(4, L);
            psInsert.setString(5, email);
            psInsert.setString(6, M);
//            psInsert.setString(6, SEQ);
//            psInsert.setString(7, ANS);
//          
            psInsert.executeUpdate();
            
             sendOTP();
          

            FXMLLoader loader = new FXMLLoader(getClass().getResource("OTPvarification.fxml"));
            Parent root = loader.load();
            OTPvarificationController otp = loader.getController();
            otp.radom(h);
            otp.user(u);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Welcome");
            stage.show();

        }
        if (resultset != null) {
            

            try {

                resultset.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            if (psInsert != null) {

                try {

                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }

            }

        }
    }

    private void Home(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Home.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void login(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Back(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Home.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();

    }

    public void Random() {
        Random rd = new Random();
        hide.setText("" + rd.nextInt(10000 + 1));

    }

    public void sendOTP() {

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
            message.setText("Your OTP is " + hide.getText());
            message.setSubject("OTP For your busticket Account");
            message.setFrom(new InternetAddress(username));
            message.addRecipient(RecipientType.TO, new InternetAddress(Email.getText().trim()));
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
