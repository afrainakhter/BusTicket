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
    private PasswordField ConfirmPass;
    @FXML
    private TextField SeqQues;
    @FXML
    private TextField Ans;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Register(ActionEvent event) throws SQLException, IOException {

        String u = UserName.getText();
        String F = FirstName.getText();
        String L = LastName.getText();
        String p = PassWord.getText();
        String CP = ConfirmPass.getText();
        
       String SEQ = SeqQues.getText();
        String ANS = Ans.getText();
        
        Connection connection ;

        PreparedStatement psInsert =null;

        PreparedStatement psCheckUserExists ;
        ResultSet resultset ;

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
             ConfirmPass.setText("");
             SeqQues.setText("");
              Ans.setText("");
             
        } else {

            psInsert = connection.prepareStatement("INSERT INTO login (user_name, password, FirstName, LastName, confirm_Pass,SequrityQues,Answer) VALUES (?, ?, ?, ?, ?, ?, ?)");
            psInsert.setString(1, u);
            psInsert.setString(2, p);
            psInsert.setString(3, F);
            psInsert.setString(4, L);
            psInsert.setString(5, CP);
            psInsert.setString(6, SEQ);
            psInsert.setString(7, ANS);
            
            psInsert.executeUpdate( );

            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDashBoard.fxml"));
            Parent root = loader.load();

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

        }}

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

}
