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
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class Forget_pass implements Initializable {

    @FXML
    private TextField User_name;
    @FXML
    private TextField New_pass;
 
    @FXML
    private Button Next;
    private TextField ques;
    private TextField Ans;
    @FXML
    private Label ERROR;

   // String ans, pass;
  
    @FXML
    private TextField opt;
    @FXML
    private Label hide;
    @FXML
    private TextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void Back(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Next(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

        String u =opt.getText();
        String h=hide.getText();
        String pass=New_pass.getText();
         String u_name = User_name.getText();
      
          try{
        if(h.equals(u)){
            
            Connection connection;
  
        PreparedStatement ps;

        //PreparedStatement psCheckUserExists ;
        
        ResultSet resultset;
       Class.forName("com.mysql.cj.jdbc.Driver");
           
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("Connected");

         String sql = ("UPDATE  login SET `password`='"+pass+"' WHERE (`user_name`='"+u_name+"')");
            ps = connection.prepareStatement(sql);
           ps.executeUpdate();
        
        
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
    }
        
        
        else{
        
            
            Alert alert=new Alert(Alert.AlertType.ERROR);
            
            alert.setContentText("Wrong otp,try again");
            alert.show();
        
        }}
        
        catch(Exception e){

e.printStackTrace();}
        
     
        
    }
    @FXML
    private void Search(ActionEvent event) throws SQLException, ClassNotFoundException {

        Connection connection;

        PreparedStatement ps;

        //PreparedStatement psCheckUserExists ;
        ResultSet resultset;

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("Connected");

//        New_pass.setText("");
//        Ans.setText("");
//
        String u_name = User_name.getText();
        if (u_name.isEmpty()) {

            ERROR.setText("Plese Insert UserName");

        } else {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select email from login where user_name=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, u_name);
            resultset = ps.executeQuery();
            if (resultset.next()) {

                  email.setText(resultset.getString(1));
//                ques.setText(resultset.getString(1));
//                ans = resultset.getString(2);
//                pass = resultset.getString(3);
//
                ERROR.setText("");

                ps.close();
                resultset.close();

            } else {

                ERROR.setText("Error: Username is incorrect ");

            }

        }

    }
    
//for seq ques method
//    private void Retrive(ActionEvent event) {
//        
//        if(ans.equals(Ans.getText())){
//            
//            New_pass.setText(pass);
//            ERROR.setText("Your answer is Corrent ");
//        
//        }
//        else{
//            
//            ERROR.setText("Your answer is wrong");
//            
//            New_pass.setText("");
//        
//        }
//        
//        
//    }
    public void Random() {
        Random rd = new Random();
        hide.setText("" + rd.nextInt(10000 + 1));

    }
    
    public void sendOTP() {
         Random();
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
            message.setSubject("OTP For your Busticket Account");
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getText().trim()));
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
