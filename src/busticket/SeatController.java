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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class SeatController implements Initializable {

    @FXML
    private Label Ticket_price;
    @FXML
    private Label Date;
    @FXML
    private Label Place_name;
    @FXML
    private Label Place_name2;

    @FXML
    private Button B1;
    @FXML
    private Button C1;
    @FXML
    private Button D1;
    @FXML
    private Button E1;
    @FXML
    private Button F1;
    @FXML
    private Button B2;
    @FXML
    private Button C2;
    @FXML
    private Button D2;
    @FXML
    private Button E2;
    @FXML
    private Button F2;

    @FXML
    private Button B3;
    @FXML
    private Button C3;
    @FXML
    private Button D3;
    @FXML
    private Button E3;
    @FXML
    private Button F3;
    @FXML
    private Button B4;
    @FXML
    private Button C4;
    @FXML
    private Button D4;
    @FXML
    private Button E4;
    @FXML
    private Button F4;
    @FXML
    private Button L;
    boolean bta1, bta2, bta3, bta4, btb1, btb2, btb3, btb4, btc1, btc2, btc3, btc4, btd1, btd2, btd3, btd4, bte1, bte2, bte3, bte4;

    int seatcountA1 = 0, seatcountA2 = 0, seatcountA3 = 0, seatcountA4 = 0, seatcountB1 = 0, seatcountB2 = 0, seatcountB3 = 0, seatcountB4 = 0;

    String yellow = "-fx-background-color:#ffb805";
    String red = "-fx-background-color:#FF0000";
    String green = "-fx-background-color:#39FF14";
    String orange = "-fx-background-color:#ff7b08";

    @FXML
    private Button G1;
    @FXML
    private Button H1;
    @FXML
    private Button I1;
    @FXML
    private Button J1;
    @FXML
    private Button G2;
    @FXML
    private Button H2;
    @FXML
    private Button I2;
    @FXML
    private Button J2;
    @FXML
    private Button G3;
    @FXML
    private Button H3;
    @FXML
    private Button I3;
    @FXML
    private Button J3;
    @FXML
    private Button G4;
    @FXML
    private Button H4;
    @FXML
    private Button I4;
    @FXML
    private Button J4;
    @FXML
    private Button K1;
    @FXML
    private Button K2;
    @FXML
    private Button K4;
    @FXML
    private Button K5;
    @FXML
    private Button K3;
    @FXML
    private Label Bus_name;
    private Label Time;
    @FXML
    private Label Dept_time;
    @FXML
    private Label Ari_time;
    String x;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private Label total_price;
    @FXML
    private Button BOOK;
    @FXML
    private Button Cancle;
    @FXML
    private Button Reset;
    @FXML
    private Button Refresh;
    @FXML
    private Label No_of_Seat;
    @FXML
    private Button a1;
    @FXML
    private Button a2;
    @FXML
    private Button a3;
    @FXML
    private Button a4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        
//        ObservableList<String> list1 = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
//        
//        No_of_seat.setItems(list1);
//        
//        

        // TODO
    }

    @FXML
    private void A1(ActionEvent event) {

        String busName = x.toString();
        if (x.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        } else {

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

        }
        try {
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='A1' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {

                  
                        bta1 = true;
                        seatcountA1 = 1;
                        a1.setStyle(green);
                        No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3+ seatcountA4));

                    
                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void B1(ActionEvent event) {

    }

    @FXML
    private void C1(ActionEvent event) {
    }

    @FXML
    private void D3(ActionEvent event) {
    }

    @FXML
    private void E1(ActionEvent event) {
    }

    @FXML
    private void F1(ActionEvent event) {
    }

    @FXML
    private void G1(ActionEvent event) {
    }

    @FXML
    private void H1(ActionEvent event) {
    }

    @FXML
    private void I1(ActionEvent event) {
    }

    @FXML
    private void J1(ActionEvent event) {
    }

    @FXML
    private void A2(ActionEvent event) {

        String busName = x.toString();
        if (x.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        } else {

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

        }
        try {
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='A2' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    a2.setStyle(orange);

//          
//         
//              Alert alert = new Alert(Alert.AlertType.WARNING);
//          alert.setAlertType(Alert.AlertType.WARNING);
//          alert.setContentText("oops! The seat is booked already. Select another");
//          Optional<ButtonType> result = alert.showAndWait();
//         
                } else {

                   
                        bta2 = true;
                        seatcountA2 = 1;
                        a2.setStyle(green);
                        No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3+ seatcountA4));

                    
                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

    }

    @FXML
    private void B3(ActionEvent event) {
    }

    @FXML
    private void C2(ActionEvent event) {
    }

    @FXML
    private void D2(ActionEvent event) {
    }

    @FXML
    private void E2(ActionEvent event) {
    }

    @FXML
    private void F2(ActionEvent event) {
    }

    @FXML
    private void G2(ActionEvent event) {
    }

    @FXML
    private void H2(ActionEvent event) {
    }

    @FXML
    private void I2(ActionEvent event) {
    }

    @FXML
    private void J2(ActionEvent event) {
    }

    @FXML
    private void A3(ActionEvent event) {

        String busName = x.toString();
        if (x.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        } else {

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

        }
        try {
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='A3' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

//          
//         
//              Alert alert = new Alert(Alert.AlertType.WARNING);
//          alert.setAlertType(Alert.AlertType.WARNING);
//          alert.setContentText("oops! The seat is booked already. Select another");
//          Optional<ButtonType> result = alert.showAndWait();
//         
                } else {

                  
                        bta3 = true;
                        seatcountA3 = 1;
                        a3.setStyle(green);
                        No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3+ seatcountA4));

                    
                }

            }
        } catch (SQLException e) {

          e.printStackTrace();

        }

    }

    @FXML
    private void C3(ActionEvent event) {

    }

    @FXML
    private void E3(ActionEvent event) {
    }

    @FXML
    private void F3(ActionEvent event) {
    }

    @FXML
    private void G3(ActionEvent event) {
    }

    @FXML
    private void H3(ActionEvent event) {
    }

    @FXML
    private void I3(ActionEvent event) {
    }

    @FXML
    private void J3(ActionEvent event) {
    }

    @FXML
    private void A4(ActionEvent event) {
        String busName = x.toString();
        if (x.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        } else {

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

        }
        try {
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='A4' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

//          
//         
//              Alert alert = new Alert(Alert.AlertType.WARNING);
//          alert.setAlertType(Alert.AlertType.WARNING);
//          alert.setContentText("oops! The seat is booked already. Select another");
//          Optional<ButtonType> result = alert.showAndWait();
//         
                } else {

                   
                        bta4 = true;
                        seatcountA4 = 1;
                        a4.setStyle(green);
                        No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3+seatcountA4));

                    
                }

            }
        } catch (SQLException e) {

          e.printStackTrace();

        }
    }

    @FXML
    private void B4(ActionEvent event) {

    }

    @FXML
    private void C4(ActionEvent event) {

    }

    @FXML
    private void D4(ActionEvent event) {

    }

    @FXML
    private void E4(ActionEvent event) {

    }

    @FXML
    private void F4(ActionEvent event) {

    }

    @FXML
    private void G4(ActionEvent event) {

    }

    @FXML
    private void H4(ActionEvent event) {
    }

    @FXML
    private void I4(ActionEvent event) {
    }

    @FXML
    private void J4(ActionEvent event) {
    }

    @FXML
    private void L(ActionEvent event) {
    }

    @FXML
    private void K1(ActionEvent event) {
    }

    @FXML
    private void K2(ActionEvent event) {
    }

    @FXML
    private void K4(ActionEvent event) {
    }

    @FXML
    private void K5(ActionEvent event) {
    }

    @FXML
    private void K3(ActionEvent event) {
    }

    @FXML
    private void Payment(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Payment.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Payment Page");
        stage.setScene(scene);
        stage.show();

    }

    public void show_PlaceName_from(String name) {

        Place_name.setText(name);

    }

    public void show_PlaceName_to(String name) {

        Place_name2.setText(name);

    }

    public void show_date(String date) {

        Date.setText(date);

    }

    public void show_TPrice(String price) {

        Ticket_price.setText(price);

    }

    public void Bus_name(String bus_name) {

        Bus_name.setText(bus_name);
        this.x = bus_name;

    }

    public void Dept_time(String dep_time) {

        Dept_time.setText(dep_time);

    }

    public void Ari_time(String ariTime) {

        Ari_time.setText(ariTime);

    }

    @FXML
    private void Back(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Available_Bus.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Available Bus");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void BOOK(ActionEvent event) throws SQLException {

        String tic_price = Ticket_price.getText();

        String res = No_of_Seat.getText();

        int ticprice = Integer.parseInt(tic_price);

        int result = Integer.parseInt(res);

        int Total_Price = (result * ticprice);

        String total = Integer.toString(Total_Price);

        total_price.setText(total);
        
        
       
        

    }

    @FXML
    private void Cancle(ActionEvent event) throws SQLException {
        
//         String busname=Bus_name.getText();
//        
//         String tic_price = Ticket_price.getText();
//
//        String res = No_of_Seat.getText();
//        
//        Connection con;
//        PreparedStatement psInsert = null;
//        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
//        System.out.println("Connected");
//
//         psInsert = con.prepareStatement("INSERT INTO BusSeat (SeatName,Uname,BusName,Count)VALUES(?,?,?,?)");
//        psInsert.setString(1, busname);
//        psInsert.setString(2, res);
//        psInsert.setString(3,  tic_price);
//        psInsert.setString(4, res);
//        psInsert.executeUpdate();
    }

    @FXML
    private void Reset(ActionEvent event) {
    }

    @FXML
    private void Refresh(ActionEvent event) {
    }

}
