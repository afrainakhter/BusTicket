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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class Admin_CustomerController implements Initializable {

    @FXML
    private TableView<Admin_customer_data> Customer_table;
    @FXML
    private TableColumn<Admin_customer_data, Integer> ID;
    @FXML
    private TableColumn<Admin_customer_data, String> Name;
    @FXML
    private TableColumn<Admin_customer_data, String> UserName;
    @FXML
    private TableColumn<Admin_customer_data, String> Phone_no;
    @FXML
    private TableColumn<Admin_customer_data, String> Email;
Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    Bus_list bus = null;

    ObservableList<Admin_customer_data> data;
    @FXML
    private TableColumn<Admin_customer_data, String> city;
    @FXML
    private TableColumn<Admin_customer_data, String> div;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       data= FXCollections.observableArrayList();
        
        col();
        try {
            load();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    public void col(){
        
           ID.setCellValueFactory(new PropertyValueFactory<>("id"));

        Name.setCellValueFactory(new PropertyValueFactory<>("name"));

        UserName.setCellValueFactory(new PropertyValueFactory<>("user_name"));

        Phone_no.setCellValueFactory(new PropertyValueFactory<>("mobile_no"));

        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
       
        
     city.setCellValueFactory(new PropertyValueFactory<>("From_bus"));

        div.setCellValueFactory(new PropertyValueFactory<>("to_bus"));
       
        
    
    
    
    }
    
    
    
     public void load() throws ClassNotFoundException, SQLException{
     
     
     Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");

        System.out.println("conected");

        try {

            preparedStatement = connection.prepareStatement("Select * From login");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

               data.add(new Admin_customer_data(
                       resultSet.getInt("ID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("mobile"),
                        resultSet.getString("email"),
                        resultSet.getString("user_name"),
                        resultSet.getString("city"),
                        resultSet.getString("division"),
                        resultSet.getString("city")
                        
                        
                                        ));

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

       Customer_table.setItems(data);
    }

     
     
     
     
     
     

     
     
    
    
    
    
    
    
    
    @FXML
    private void BACK(MouseEvent event) throws IOException {
        
        
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("DashBoard");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void DashBoard(MouseEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("DashBoard");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Route(MouseEvent event) throws IOException {
             FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("AdminRoutes.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Earning");
        stage.setScene(scene);
        stage.show();
        
        
        
        
    }

    @FXML
    private void AddBus(MouseEvent event) throws IOException {
             FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_AddBus.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Earning");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Bookings(MouseEvent event) throws IOException {
             FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_bookings.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Earning");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Earnings(MouseEvent event) throws IOException {
             FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_Earnings.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Earning");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Reports(MouseEvent event) throws IOException {
             FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_Report.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Earning");
        stage.setScene(scene);
        stage.show();
        
    }
    
}
