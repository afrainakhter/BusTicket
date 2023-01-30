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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class Edit_ProfileController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField LastName;
    @FXML
    private TextField SeqQues;
    @FXML
    private TextField Ans;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField division;
    @FXML
    private TextField city;
    @FXML
    private TextField FirstName;
    @FXML
    private DatePicker birthdate;
    @FXML
    private TextField username;
 Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void savechange(ActionEvent event) throws SQLException, IOException {
        
        
        try{
     PreparedStatement psupdate = null;
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("connected");
 
          String u=username.getText();
          String e = email.getText();
        String f = FirstName.getText();
        String l = LastName.getText();
        String seq = SeqQues.getText();
       
        String anser= Ans.getText();
        String p = phonenumber.getText();
        
           LocalDate date = birthdate.getValue();
           
         String c= city.getText();
        String d = division.getText();
        

        String sql= ("UPDATE login SET `Answer`='"+anser+"',`division`='"+d+"', `email`='"+e+"',`FirstName`='"+f+"',`LastName`='"+l+"',`SequrityQues`='"+seq+"',`city`='"+c+"',`mobile`='"+p +"'  WHERE (`user_name`='"+u+"')");
        
        psupdate =connection.prepareStatement(sql);
         psupdate.execute();
            System.out.println("Edit profile done");
            
         
          FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDashBoard.fxml"));
                Parent root = loader.load();
               UserDashBoardController user=loader.getController();
               user.displayName(u);
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.show();
        
        
        
        
        }catch(SQLException e){
        
        
        e.printStackTrace();}
        
        
        
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
                Parent root = loader.load();
               
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.show();
        
    }

    @FXML
    private void Back(MouseEvent event) throws IOException {
           
        String u=username.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDashBoard.fxml"));
                Parent root = loader.load();
                UserDashBoardController user=loader.getController();
               user.displayName(u);
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.show();
        
    }

    @FXML
    private void dashboard(ActionEvent event) throws IOException {
        
        String u=username.getText();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDashBoard.fxml"));
                Parent root = loader.load();
               UserDashBoardController user=loader.getController();
               user.displayName(u);
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.show();
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
                Parent root = loader.load();
               
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.show();
    }
    
    
     public void displayName(String Name) {

      username.setText( Name );
    }
    
}
