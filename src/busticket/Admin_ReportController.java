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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
public class Admin_ReportController implements Initializable {

    @FXML
    private TableColumn<review, String> Name;
    @FXML
    private TableColumn<review, String> email;
    @FXML
    private TableColumn<review, Integer> rating;
    @FXML
    private TableColumn<review, String> massage;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private BarChart<?, ?> Rating;
    Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    ObservableList<review> data;
    @FXML
    private TableView<review> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //int rate=Integer.parseInt(rating);
        data = FXCollections.observableArrayList();
        try {
            chart();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            load();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void chart() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        preparedStatement = connection.prepareStatement("Select Name ,Rating From Review");
        XYChart.Series set = new XYChart.Series();
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            set.getData().add(new XYChart.Data(resultSet.getString(1), resultSet.getInt(2)));
//        set.getData().add(new XYChart.Data(resultSet.getInt(1), 4));
//        set.getData().add(new XYChart.Data(resultSet.getInt(1), 3));
//        set.getData().add(new XYChart.Data(resultSet.getInt(1), 2));

        }

        Rating.getData().addAll(set);
    }

    public void load() throws ClassNotFoundException, SQLException {

        Name.setCellValueFactory(new PropertyValueFactory<>("name"));

        massage.setCellValueFactory(new PropertyValueFactory<>("massange"));

        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));

        email.setCellValueFactory(new PropertyValueFactory<>("email"));

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");

        System.out.println("conected");

        try {

            preparedStatement = connection.prepareStatement("Select * From Review");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                data.add(new review(
                        resultSet.getString("Name"),
                        resultSet.getString("Email"),
                        resultSet.getInt("Rating"),
                        resultSet.getString("massage")
                ));

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        table.setItems(data);

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
    private void Route(MouseEvent event) {
    }

    @FXML
    private void AddBus(MouseEvent event) {
    }

    @FXML
    private void Booking(MouseEvent event) {
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
    private void Report(MouseEvent event) {
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
    private void Earning(MouseEvent event) {
    }

}
