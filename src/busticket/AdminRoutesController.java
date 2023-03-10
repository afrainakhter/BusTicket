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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class AdminRoutesController implements Initializable {

    @FXML
    private TextField RouteFrom;
    @FXML
    private TextField RouteTo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DashBoard(MouseEvent event) throws IOException {
        
          
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Route(MouseEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("AdminRoutes.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Routes");
        stage.setScene(scene);
        stage.show();
         
        
    }

    @FXML
    private void AddBus(MouseEvent event) throws IOException {  
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_AddBus.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void Booking(MouseEvent event) throws IOException {
        
        
        
          FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_bookings.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Customers");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Customer(MouseEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_Customer.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Customers");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Report(MouseEvent event) throws IOException {
        
          
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_Report.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void BACK(MouseEvent event) throws IOException {
          
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Earning(MouseEvent event) throws IOException {
          
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_Earnings.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addroutes(ActionEvent event) throws SQLException, IOException {
        
         String f=RouteFrom.getText();
         String t=RouteTo.getText();
         Connection con;
         PreparedStatement pst=null;
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("Connected");
try{
         pst=con.prepareStatement("INSERT INTO bus (from,to) VALUES (?,?)");
         
         pst.setString(1, f);
         pst.setString(2, t);
         pst.executeUpdate();
         
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
}catch(SQLException e){

e.printStackTrace();}
    }
    
}
