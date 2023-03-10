/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticket;

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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class Admin implements Initializable {

    @FXML
    private MenuButton menu;
    @FXML
    private MenuItem item1;
    @FXML
    private MenuItem item2;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         MenuButton m =new  MenuButton ();
         MenuItem item11=new  MenuItem ("DashBoard");
         MenuItem item12=new  MenuItem ("Logout");
         m.getItems().addAll(item11,item12);
         
         
         
         
         
        
        
        // TODO
    }    

    private void BACK(MouseEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("AdminLogin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Admin Login");
        stage.setScene(scene);
        stage.show();
        
        
        
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
    private void AddBus(MouseEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_AddBus.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Add Bus");
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
    private void Report(MouseEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_Report.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Routes");
        stage.setScene(scene);
        stage.show();
        
        
        
        
        
        
        
    }

    @FXML
    private void Earning(MouseEvent event) throws IOException {
        
           FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_Earnings.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Earning");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Booking(MouseEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_bookings.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Earning");
        stage.setScene(scene);
        stage.show();
        
        
        
    }

   
    @FXML
    private void dash(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("AdminLogin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setTitle("Admin Login");
        stage.setScene(scene);
        stage.show();

    }

   
   

    
}
