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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class Available_BusController implements Initializable {

    @FXML
    private TableColumn<Bus_list, String> Bus_name;
    @FXML
    private TableColumn<Bus_list, Integer> Ticket_price;
    @FXML
    private TableColumn<Bus_list, String> Departure_time;
    @FXML
    private TableColumn<Bus_list, String> Arival_time;
    @FXML
    private TableView<Bus_list> Bus_ListTable;

    // String qurey = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Bus_list bus = null;

    ObservableList<Bus_list> Bus_List;
    @FXML
    private Label From_feild;
    @FXML
    private Label To_feild;
    @FXML
    private Label Date_feild;
    @FXML
    private TextField Search_bus;
    @FXML
    private TextField Search_bus_ticket;
    @FXML
    private TextField Search_bus_time;
    @FXML
    private TextField bus_Name_show;
    @FXML
    private TextField tic_price_show;
    @FXML
    private TextField time_show;

    Integer index;
    @FXML
    private Label user_name;

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL location, ResourceBundle resources) {
        Bus_List = FXCollections.observableArrayList();

        intCOl();
        load();

        searchBY_BusProperty();

    }

    /*       Data set  in Table         */
    private void intCOl() {

        Bus_name.setCellValueFactory(new PropertyValueFactory<>("Bus_name"));

        Ticket_price.setCellValueFactory(new PropertyValueFactory<>("tik_pri"));

        Departure_time.setCellValueFactory(new PropertyValueFactory<>("Dep_time"));

        Arival_time.setCellValueFactory(new PropertyValueFactory<>("Arl_time"));

    }

    /*       Data load in Table Function          */
    private void load() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        } catch (SQLException e) {

            e.printStackTrace();

        }

        System.out.println("conected");

        try {

            // String UserTo=To_feild.getText();
            preparedStatement = connection.prepareStatement("Select * From Bus_list");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // String Datato=resultSet.getString("To");

                Bus_List.add(new Bus_list(
                        resultSet.getString("Bus_Name"),
                        resultSet.getString("Departure_time"),
                        resultSet.getString("Arival_time"),
                        resultSet.getString("From"),
                        resultSet.getString("To"),
                        resultSet.getInt("Ticket_price"),
                        resultSet.getInt("BusID")
                ));

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        Bus_ListTable.setItems(Bus_List);
    }

    /*       Data SEARCH in Table Function       */
    private void searchBY_BusProperty() {

        Bus_ListTable.setItems(Bus_List);

        FilteredList<Bus_list> filteredList = new FilteredList<>(Bus_List, b -> true);

        Search_bus.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredList.setPredicate(Bus_list -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;

                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Bus_list.getBus_name().toLowerCase().indexOf(lowerCaseFilter) != -1) {

                    return true;

                } else {
                    return false;
                }
            });

        });

        Search_bus_ticket.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredList.setPredicate(Bus_list -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;

                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(Bus_list.getTik_pri()).indexOf(lowerCaseFilter) != -1) {

                    return true;

                } else {
                    return false;
                }
            });

        });
        Search_bus_time.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredList.setPredicate(Bus_list -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;

                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(Bus_list.getDep_time()).indexOf(lowerCaseFilter) != -1) {

                    return true;

                } else {
                    return false;
                }
            });

        });

        SortedList<Bus_list> sort = new SortedList<>(filteredList);
        sort.comparatorProperty().bind(Bus_ListTable.comparatorProperty());
        Bus_ListTable.setItems(sort);

    }

    public void show_PlaceName_from(String name) {

        From_feild.setText(name);

    }

    public void show_PlaceName_to(String name) {

        To_feild.setText(name);

    }

    public void show_date(String date) {

        Date_feild.setText(date);

    }

    @FXML
    private void Chose_seat(ActionEvent event) throws IOException, SQLException {

        String from = From_feild.getText();
        String to = To_feild.getText();
        String date = Date_feild.getText();
        String b = bus_Name_show.getText();
        String tic_price = tic_price_show.getText();
        String departure_time = time_show.getText();
        String u = user_name.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Seat.fxml"));
        Parent root = loader.load();
        //TicketBookingController ticket=loader.getController();

        SeatController seat = loader.getController();

        seat.show_PlaceName_from(from);
        seat.show_PlaceName_to(to);
        seat.show_date(date);
        seat.Bus_name(b);
        seat.show_TPrice(tic_price);
        seat.Dept_time(departure_time);
        seat.username(u);

        seat.getred();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Select Seat ");
        stage.show();

    }

    @FXML
    private void Clicked(MouseEvent event) {

        System.out.println("Clicked");

        index = Bus_ListTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;

        }

        bus_Name_show.setText(Bus_name.getCellData(index));
        tic_price_show.setText(Ticket_price.getCellData(index).toString());
        time_show.setText(Departure_time.getCellData(index));

    }

    @FXML
    private void BACK(MouseEvent event) throws IOException {
        String u= user_name.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("TicketBooking.fxml"));
        Parent root = fxmlLoader.load();
        
        TicketBookingController tic=fxmlLoader.getController();
        tic.username(u);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TICKET BOOKING");
        stage.setScene(scene);
        stage.show();

    }

    public void username(String name) {
        user_name.setText(name);

    }

}
