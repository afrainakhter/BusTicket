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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class User_MybookingController implements Initializable {

    @FXML
    private Label User_Name;
    @FXML
    private TableView<MyBooking> userbook_table;
    @FXML
    private TableColumn<MyBooking, String> busname;
    @FXML
    private TableColumn<MyBooking, String> seats;
    @FXML
    private TableColumn<MyBooking, String> to;
    @FXML
    private TableColumn<MyBooking, String> from;
    @FXML
    private TableColumn<MyBooking, Integer> total_price;
    @FXML
    private TableColumn<MyBooking, String> date;
    @FXML
    private TableColumn<MyBooking, String> time;

    ObservableList<MyBooking> data;
    Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;
    @FXML
    private TableColumn<MyBooking, Integer> C_ID;
    @FXML
    private TextField ID;

    int index=-1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();

        col();
       
    }

    public void col() {

        busname.setCellValueFactory(new PropertyValueFactory<>("bus_name"));
        seats.setCellValueFactory(new PropertyValueFactory<>("seat_name"));
        to.setCellValueFactory(new PropertyValueFactory<>("to"));
        from.setCellValueFactory(new PropertyValueFactory<>("from"));
        total_price.setCellValueFactory(new PropertyValueFactory<>("total_amount"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        C_ID.setCellValueFactory(new PropertyValueFactory<>("id"));

    }

    public void load() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");

        System.out.println("conected");
        String u = User_Name.getText();

        try {

            preparedStatement = connection.prepareStatement("Select * from Booking_history Where User_name=?");
            preparedStatement.setString(1, u);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                data.add(new MyBooking(
                        resultSet.getString("User_name"),
                        resultSet.getString("Bus_name"),
                        resultSet.getString("From_bus"),
                        resultSet.getString("To_bus"),
                        resultSet.getString("Time"),
                        resultSet.getString("Seat"),
                        resultSet.getInt("Total_Amount"),
                        resultSet.getString("Date"),
                        resultSet.getInt("Customer_ID")
                ));

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        userbook_table.setItems(data);

    }

    @FXML
    private void DashBoard(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserDashBoard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("DashBoard");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Routes(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserRoutes.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Find Routes");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Buses(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("User_avilable_busOperatorController.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Check Your Booking");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void MyBooking(MouseEvent event) throws IOException, ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");

        System.out.println("conected");

        try {

            preparedStatement = connection.prepareStatement("Select * from Booking_history Where User_name='u'");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                data.add(new MyBooking(
                        resultSet.getString("User_name"),
                        resultSet.getString("Bus_name"),
                        resultSet.getString("From_bus"),
                        resultSet.getString("To_bus"),
                        resultSet.getString("Time"),
                        resultSet.getString("Seat"),
                        resultSet.getInt("Total_Amount"),
                        resultSet.getString("Date"),
                        resultSet.getInt("Customer_ID")
                ));

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        userbook_table.setItems(data);

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("User_Mybooking.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Check Your Booking");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void TicketBooking(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("TicketBooking.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Book Your ticket");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Review(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserReview.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Give a Review");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Back(MouseEvent event) throws IOException {
        String u = User_Name.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserDashBoard.fxml"));
        Parent root = fxmlLoader.load();

        UserDashBoardController user = fxmlLoader.getController();
        user.displayName(u);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Dash Board");
        stage.setScene(scene);
        stage.show();

    }

    public void user_name(String name) {

        User_Name.setText(name);

    }

    @FXML
    private void cancelBooking(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {

        Connection connection;

        PreparedStatement psdelete = null;

        //Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("connected");
        try {

            
            String u=User_Name.getText();
            String i = ID.getText();

            int intid = Integer.parseInt(i);
            psdelete = connection.prepareStatement("DELETE FROM Booking_history WHERE Customer_ID=?");
            psdelete.setInt(1, intid);
            psdelete.execute();
            System.out.println("delete Booking successful");

            FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserDashBoard.fxml"));
            Parent root = fxmlLoader.load();
                        
           
        UserDashBoardController user = fxmlLoader.getController();
        user.displayName(u);

            
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Home Page");
            stage.setScene(scene);
            stage.show();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @FXML
    private void getSelected(MouseEvent event) {

        index = userbook_table.getSelectionModel().getSelectedIndex();

        if (index <= -1) {

            return;

        }
        ID.setText(C_ID.getCellData(index).toString());

  }
    
    
    

}
