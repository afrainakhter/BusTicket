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
import java.util.ArrayList;
import java.util.Optional;
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

    //Button variables
    @FXML
    private Button a1;
    @FXML
    private Button a2;
    @FXML
    private Button a3;
    @FXML
    private Button a4;

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

    @FXML
    private Label Ticket_price;
    @FXML
    private Label Date;
    @FXML
    private Label Place_name;
    @FXML
    private Label Place_name2;
    //Database variables

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
    private Button reset;
    @FXML
    private Label No_of_Seat;

    //seat press boolean check variable
    boolean bta1, bta2, bta3, bta4, btb1, btb2, btb3, btb4, btc1, btc2,
            btc3, btc4, btd1, btd2, btd3, btd4, bte1, bte2, bte3, bte4, btf1,
            btf2, btf3, btf4, btg1, btg2, btg3, btg4, bth1, bth2, bth3, bth4, bti1,
            bti2, bti3, bti4, btj1, btj2, btj3, btj4, btk1, btk2, btk3, btk4, btk5, btl;

    //Seat counter varibale
    int seatcountA1 = 0, seatcountA2 = 0, seatcountA3 = 0, seatcountA4 = 0, seatcountB1 = 0, seatcountB2 = 0, seatcountB3 = 0,
            seatcountB4 = 0, seatcountC1 = 0, seatcountC2 = 0, seatcountC3 = 0, seatcountC4 = 0, seatcountD1 = 0, seatcountD2 = 0,
            seatcountD3 = 0, seatcountD4 = 0, seatcountE1 = 0, seatcountE2 = 0, seatcountE3 = 0, seatcountE4 = 0,
            seatcountF1 = 0, seatcountF2 = 0, seatcountF3 = 0, seatcountF4 = 0, seatcountG1 = 0, seatcountG2 = 0,
            seatcountG3 = 0, seatcountG4 = 0,
            seatcountH1 = 0, seatcountH2 = 0, seatcountH3 = 0, seatcountH4 = 0, seatcountI1 = 0,
            seatcountI2 = 0, seatcountI3 = 0, seatcountI4 = 0, seatcountJ1 = 0, seatcountJ2 = 0,
            seatcountJ3 = 0, seatcountJ4 = 0, seatcountK1 = 0, seatcountK2 = 0, seatcountK3 = 0,
            seatcountK4 = 0, seatcountK5 = 0, seatcountL = 0;

    //Seat color 
   String red = "-fx-background-color:red";
    String green = "-fx-background-color:#39FF14";
    String orange = "-fx-background-color:#ff7b08";

    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> list4 = new ArrayList<>();
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list6 = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
                    a1.setStyle(red);
                } else {

                    bta1 = true;
                    seatcountA1 = 1;
                    a1.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void B1(ActionEvent event) {

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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='B1' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    B1.setStyle(red);

                } else {

                    btb1 = true;
                    seatcountB1 = 1;
                    B1.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + +seatcountA4 + seatcountB1 + seatcountB2 + seatcountC1));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

    }

    @FXML
    private void C1(ActionEvent event) {

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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='C1' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    C1.setStyle(red);

                } else {

                    btc1 = true;
                    seatcountC1 = 1;
                    C1.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

    }

    @FXML
    private void D1(ActionEvent event) {

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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='D1' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    D1.setStyle(red);

                } else {

                    btd1 = true;
                    seatcountD1 = 1;
                    D1.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

    }

    @FXML
    private void D3(ActionEvent event) {

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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='D3' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    D3.setStyle(red);

                } else {

                    btd3 = true;
                    seatcountD3 = 1;
                    D3.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

    }

    @FXML
    private void E1(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='E1' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    E1.setStyle(red);

                } else {

                    bte1 = true;
                    seatcountE1 = 1;
                    E1.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void F1(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='F1' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    F1.setStyle(red);

                } else {

                    btf1 = true;
                    seatcountF1 = 1;
                    F1.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void G1(ActionEvent event) {

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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='G1' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    G1.setStyle(red);

//          
//         
//              Alert alert = new Alert(Alert.AlertType.WARNING);
//          alert.setAlertType(Alert.AlertType.WARNING);
//          alert.setContentText("oops! The seat is booked already. Select another");
//          Optional<ButtonType> result = alert.showAndWait();
//         
                } else {

                    btg1 = true;
                    seatcountG1 = 1;
                    G1.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void H1(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='H1' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    H1.setStyle(red);

//          
//         
//              Alert alert = new Alert(Alert.AlertType.WARNING);
//          alert.setAlertType(Alert.AlertType.WARNING);
//          alert.setContentText("oops! The seat is booked already. Select another");
//          Optional<ButtonType> result = alert.showAndWait();
//         
                } else {

                    bth1 = true;
                    seatcountH1 = 1;
                    H1.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void I1(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='I1' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    I1.setStyle(red);

//          
//         
//              Alert alert = new Alert(Alert.AlertType.WARNING);
//          alert.setAlertType(Alert.AlertType.WARNING);
//          alert.setContentText("oops! The seat is booked already. Select another");
//          Optional<ButtonType> result = alert.showAndWait();
//         
                } else {

                    bti1 = true;
                    seatcountI1 = 1;
                    I1.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void J1(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='J1' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    J1.setStyle(red);

                } else {

                    btj1 = true;
                    seatcountJ1 = 1;
                    J1.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
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
                    a2.setStyle(red);

                } else {

                    bta2 = true;
                    seatcountA2 = 1;
                    a2.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

    }

    @FXML
    private void B3(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='B3' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    B3.setStyle(red);

                } else {

                    btb3 = true;
                    seatcountB3 = 1;
                    B3.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

    }

    @FXML
    private void B2(ActionEvent event) {

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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='B2' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    B2.setStyle(red);

                } else {

                    btb2 = true;
                    seatcountB2 = 1;
                    B2.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void C2(ActionEvent event) {

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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='C2' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    C2.setStyle(red);

                } else {

                    btc2 = true;
                    seatcountC2 = 1;
                    C2.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void D2(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='D2' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    D2.setStyle(red);

                } else {

                    btd2 = true;
                    seatcountD2 = 1;
                    D2.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void E2(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='E2' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    E2.setStyle(red);

                } else {

                    bte2 = true;
                    seatcountE2 = 1;
                    E2.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void F2(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='F2' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    F2.setStyle(red);

                } else {

                    btf2 = true;
                    seatcountF2 = 1;
                    F2.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void G2(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='G2' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    D3.setStyle(red);

                } else {

                    btg2 = true;
                    seatcountG2 = 1;
                    G2.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void H2(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='H2' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    H2.setStyle(red);

                } else {

                    bth2 = true;
                    seatcountH2 = 1;
                    H2.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void I2(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='I2' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    I2.setStyle(red);

                } else {

                    bti2 = true;
                    seatcountI2 = 1;
                    I2.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @FXML
    private void J2(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='J2' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    J2.setStyle(red);

                } else {

                    btj2 = true;
                    seatcountJ2 = 1;
                    J2.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
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
                    a3.setStyle(red);

                } else {

                    bta3 = true;
                    seatcountA3 = 1;
                    a3.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void C3(ActionEvent event) {

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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='C3' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    C3.setStyle(red);

                } else {

                    btc3 = true;
                    seatcountC3 = 1;
                    C3.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void E3(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='E3' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    E3.setStyle(red);
//          
//         
//              Alert alert = new Alert(Alert.AlertType.WARNING);
//          alert.setAlertType(Alert.AlertType.WARNING);
//          alert.setContentText("oops! The seat is booked already. Select another");
//          Optional<ButtonType> result = alert.showAndWait();
//         
                } else {

                    bte3 = true;
                    seatcountE3 = 1;
                    E3.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @FXML
    private void F3(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='F3' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    F3.setStyle(red);

                } else {

                    btf3 = true;
                    seatcountF3 = 1;
                    F3.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @FXML
    private void G3(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='G3' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    G3.setStyle(red);
                } else {

                    btg3 = true;
                    seatcountG3 = 1;
                    G3.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @FXML
    private void H3(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='H3' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    H3.setStyle(red);

                } else {

                    bth3 = true;
                    seatcountH3 = 1;
                    H3.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @FXML
    private void I3(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='I3' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    I3.setStyle(red);

                } else {

                    bti3 = true;
                    seatcountI3 = 1;
                    I3.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void J3(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='J3' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    J3.setStyle(red);
                } else {

                    btj3 = true;
                    seatcountJ3 = 1;
                    J3.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
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

                    a4.setStyle(red);
                } else {

                    bta4 = true;
                    seatcountA4 = 1;
                    a4.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @FXML
    private void B4(ActionEvent event) {

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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='B4' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    B4.setStyle(red);
                } else {

                    btb4 = true;
                    seatcountB4 = 1;
                    B4.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void C4(ActionEvent event) {

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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='C4' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();
                    C4.setStyle(red);

                } else {

                    btc4 = true;
                    seatcountC4 = 1;
                    C4.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

    }

    @FXML
    private void D4(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='D4' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    D4.setStyle(red);
                } else {

                    btd4 = true;
                    seatcountD4 = 1;
                    D4.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void E4(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='E4' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    E4.setStyle(red);
                } else {

                    bte4 = true;
                    seatcountE4 = 1;
                    E4.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void F4(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='F4' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    F4.setStyle(red);
                } else {

                    btf4 = true;
                    seatcountF4 = 1;
                    F4.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void G4(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='G4' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    G4.setStyle(red);
                } else {

                    btg4 = true;
                    seatcountG4 = 1;
                    G4.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void H4(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='H4' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    H4.setStyle(red);
                } else {

                    bth4 = true;
                    seatcountH4 = 1;
                    H4.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void I4(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='I4' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    I4.setStyle(red);
                } else {

                    bti4 = true;
                    seatcountI4 = 1;
                    I4.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void J4(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='J4' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    J4.setStyle(red);
                } else {

                    btj4 = true;
                    seatcountJ4 = 1;
                    J4.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void L(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='L' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    L.setStyle(red);
                } else {

                    btl = true;
                    seatcountL = 1;
                    L.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void K1(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='K1' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    K1.setStyle(red);
                } else {

                    btk1 = true;
                    seatcountK1 = 1;
                    K1.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void K2(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='K2' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    K2.setStyle(red);
                } else {

                    btk2 = true;
                    seatcountK2 = 1;
                    K2.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void K4(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='K4' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    K4.setStyle(red);
                } else {

                    btk4 = true;
                    seatcountK4 = 1;
                    K4.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void K5(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='K5' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    K5.setStyle(red);
                } else {

                    btk5 = true;
                    seatcountK5 = 1;
                    K5.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void K3(ActionEvent event) {
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
            preparedStatement = connection.prepareStatement("select count from Seat WHERE SeatName='K3' and busname='" + busName + "'");

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int s = resultSet.getInt(1);
                System.out.println(s);

                if (s == 1) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                    K3.setStyle(red);
                } else {

                    btk3 = true;
                    seatcountK3 = 1;
                    K3.setStyle(green);
                    No_of_Seat.setText(String.valueOf(seatcountA1 + seatcountA2 + seatcountA3 + seatcountA4 + seatcountB1 + seatcountB2 + seatcountB3 + seatcountB4
                            + seatcountC1 + seatcountC2 + seatcountC3 + seatcountC4 + seatcountD1 + seatcountD2 + seatcountD3 + seatcountD4 + seatcountE1
                            + seatcountE2 + seatcountE3 + seatcountE4 + seatcountF1 + seatcountF2 + seatcountF3 + seatcountF4 + seatcountG1 + seatcountG2 + seatcountG3 + seatcountG4
                            + seatcountH1
                            + seatcountH2 + seatcountH3 + seatcountH4 + seatcountI1 + seatcountI2 + seatcountI3 + seatcountI4 + seatcountJ1 + seatcountJ2 + seatcountJ3 + seatcountJ4 + seatcountK1
                            + seatcountK2 + seatcountK3 + seatcountK4 + seatcountK5 + seatcountL));

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void Payment(ActionEvent event) throws IOException {

        String tic_price = Ticket_price.getText();
        String res = No_of_Seat.getText();

        int ticprice = Integer.parseInt(tic_price);

        int result = Integer.parseInt(res);

        int Total_Price = (result * ticprice);

        String total = Integer.toString(Total_Price);

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Payment.fxml"));
        Parent root = fxmlLoader.load();
        selection();
        PaymentController pay = fxmlLoader.getController();
        pay.totalPrice(total);

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Payment Page");
        stage.setScene(scene);
        stage.show();

        //CardController card=fxmlLoader.getController();
        // card.ticprice(tic_price);
        // card.totalPrice(total);
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
    private void Cancle(ActionEvent event) throws SQLException, IOException {

//         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Home.fxml"));
//        Parent root = fxmlLoader.load();
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setTitle("Available Bus");
//        stage.setScene(scene);
//        stage.show();
//        
    }

    @FXML
    private void Reset(ActionEvent event) throws ClassNotFoundException, SQLException {

        String busName = x.toString();

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        try {
            preparedStatement = connection.prepareStatement(
                    "select count,uname from Seat WHERE (SeatName='A1' or SeatName='A2' or  SeatName='A3' or  SeatName='A4' or SeatName='B1' or  SeatName='B2' or  SeatName='B3' or  SeatName='B4' or  SeatName='C1' or  SeatName='C2' or  SeatName='C3' or  SeatName='C4' or  SeatName='D1' or  SeatName='D2' or  SeatName='D3' or  SeatName='D4' or SeatName='E1' or SeatName='E2' or  SeatName='E3' or  SeatName='E4' or SeatName='F1' or SeatName='F2' or  SeatName='F3' or  SeatName='F4'or SeatName='G1' or SeatName='G2' or  SeatName='G3' or  SeatName='G4' or SeatName='H1' or  SeatName='H2' or  SeatName='H3' or  SeatName='H4' or SeatName='I1' or SeatName='I2' or  SeatName='I3' or  SeatName='I4' or SeatName='J1' or  SeatName='J2' or  SeatName='J3' or  SeatName='J4' or SeatName='K1' or SeatName='K2' or  SeatName='K3' or  SeatName='K4' or SeatName='K5' or  SeatName='L') and busname='"
                    + busName + "'");
            ResultSet r = preparedStatement.executeQuery();
            while (r.next()) {
                list.add(r.getInt(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        reset.setOnAction(e -> {

            No_of_Seat.setText("");
            total_price.setText("");

            if (list.get(0) == 0) {
                bta1 = false;
                seatcountA1 = 0;
                a1.setStyle(orange);
            }

            if (list.get(1) == 0) {
                bta2 = false;
                seatcountA1 = 0;
                a2.setStyle(orange);
            }

            if (list.get(2) == 0) {
                bta3 = false;
                seatcountA3 = 0;
                a3.setStyle(orange);
            }

            if (list.get(3) == 0) {

                bta4 = false;
                seatcountA4 = 0;
                a4.setStyle(orange);

            }
            if (list.get(4) == 0) {
                btb1 = false;
                seatcountB1 = 0;
                B1.setStyle(orange);
            }
            if (list.get(5) == 0) {
                btb2 = false;
                seatcountB2 = 0;
                B2.setStyle(orange);
            }
            if (list.get(6) == 0) {

                btb3 = false;
                seatcountB3 = 0;
                B3.setStyle(orange);
            }
            if (list.get(7) == 0) {

                btb4 = false;
                seatcountB4 = 0;
                B4.setStyle(orange);
            }
            if (list.get(8) == 0) {
                btc1 = false;
                seatcountC1 = 0;
                C1.setStyle(orange);
            }
            if (list.get(9) == 0) {
                btc2 = false;
                seatcountC2 = 0;
                C2.setStyle(orange);

            }
            if (list.get(10) == 0) {

                btc3 = false;
                seatcountC3 = 0;
                C3.setStyle(orange);
            }
            if (list.get(11) == 0) {
                btc4 = false;
                seatcountC4 = 0;
                C4.setStyle(orange);

            }
            if (list.get(12) == 0) {

                btd1 = false;
                seatcountD1 = 0;
                D1.setStyle(orange);

            }

            if (list.get(13) == 0) {
                btd2 = false;
                seatcountD2 = 0;
                D2.setStyle(orange);

            }
            if (list.get(14) == 0) {
                btd3 = false;
                seatcountD3 = 0;
                D3.setStyle(orange);

            }
            if (list.get(15) == 0) {
                btd4 = false;
                seatcountD4 = 0;
                D4.setStyle(orange);
            }
            if (list.get(16) == 0) {
                bte1 = false;
                seatcountE1 = 0;
                E1.setStyle(orange);
            }

            if (list.get(17) == 0) {
                bte2 = false;
                seatcountE1 = 0;
                E2.setStyle(orange);
            }
            if (list.get(18) == 0) {
                bte3 = false;
                seatcountE3 = 0;
                E3.setStyle(orange);
            }

            if (list.get(19) == 0) {
                bte4 = false;
                seatcountE4 = 0;
                E4.setStyle(orange);
            }
            if (list.get(20) == 0) {
                btf1 = false;
                seatcountF1 = 0;
                F1.setStyle(orange);
            }
            if (list.get(21) == 0) {
                btf2 = false;
                seatcountF1 = 0;
                F2.setStyle(orange);
            }
            if (list.get(22) == 0) {
                btf3 = false;
                seatcountF3 = 0;
                F3.setStyle(orange);
            }
            if (list.get(23) == 0) {
                btf4 = false;
                seatcountF4 = 0;
                F4.setStyle(orange);
            }

//        btg1 = false;
//        seatcountG1 = 0;
//        G1.setStyle(orange);
//
//        btg2 = false;
//        seatcountG1 = 0;
//        G2.setStyle(orange);
//
//        btg3 = false;
//        seatcountG3 = 0;
//        G3.setStyle(orange);
//
//        btg4 = false;
//        seatcountG4 = 0;
//        G4.setStyle(orange);
//
//        bth1 = false;
//        seatcountH1 = 0;
//        H1.setStyle(orange);
//
//        bth2 = false;
//        seatcountE1 = 0;
//        H2.setStyle(orange);
//
//        bth3 = false;
//        seatcountH3 = 0;
//        H3.setStyle(orange);
//
//        bth4 = false;
//        seatcountH4 = 0;
//        H4.setStyle(orange);
//
//        bti1 = false;
//        seatcountI1 = 0;
//        I1.setStyle(orange);
//
//        bti2 = false;
//        seatcountI1 = 0;
//        I2.setStyle(orange);
//
//        bti3 = false;
//        seatcountI3 = 0;
//        I3.setStyle(orange);
//
//        bti4 = false;
//        seatcountI4 = 0;
//        I4.setStyle(orange);
//
//        btj1 = false;
//        seatcountJ1 = 0;
//        J1.setStyle(orange);
//
//        btj2 = false;
//        seatcountJ1 = 0;
//        J2.setStyle(orange);
//
//        btj3 = false;
//        seatcountJ3 = 0;
//        J3.setStyle(orange);
//
//        btj4 = false;
//        seatcountJ4 = 0;
//        J4.setStyle(orange);
//
//        btk1 = false;
//        seatcountK1 = 0;
//        K1.setStyle(orange);
//
//        btk2 = false;
//        seatcountK1 = 0;
//        K2.setStyle(orange);
//
//        btk3 = false;
//        seatcountK3 = 0;
//        K3.setStyle(orange);
//
//        btk4 = false;
//        seatcountK4 = 0;
//        K4.setStyle(orange);
//
//        btk5 = false;
//        seatcountK5 = 0;
//        K5.setStyle(orange);
//        btl = false;
//        seatcountL = 0;
//        L.setStyle(orange);
        });

    }

    public void selection() {
        String busName = x.toString();
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

        if (bta1) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='A1' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (bta2) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='A2' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (bta3) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='A3' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (bta4) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='A4' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (btc1) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='C1' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (btc2) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='C2' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (btc3) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='C3' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (btc4) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='C4' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (btb1) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='B1' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (btb2) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='B2' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (btb3) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='B3' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (btb4) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='B4' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (btd1) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='D1' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (btd2) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='D2' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (btd3) {
            try {
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='D3' and busname='" + busName + "'");
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();

            }
            if (btd4) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='D4' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bte1) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='E1' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bte2) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='E2' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bte3) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='E3' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bte4) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='E4' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (btf1) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='F1' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (btf2) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='F2' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (btf3) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='F3' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (btf4) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='F4' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (btg1) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='G1' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (btg2) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='G2' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }if (btg3) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='G3' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }if (btg4) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='G4' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            if (bth1) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='H1' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (bth2) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='H2' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }if (bth3) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='H3' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }if (bth4) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='h4' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if (bti1) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='I1' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (bti2) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='I2' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }if (bti3) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='I3' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }if (bti4) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='I4' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            if (btj1) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='J1' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (btj2) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='J2' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }if (btj3) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='J3' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }if (btj4) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='J4' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            
            if (btk1) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='K1' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (btk2) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='K2' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }if (btk3) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='K3' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }if (btk4) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='K4' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            if (btk5) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='K5' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }if (btl) {
                try {
                    PreparedStatement ps = connection
                            .prepareStatement("UPDATE Seat SET count = 1 WHERE SeatName='L' and busname='" + busName + "'");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            
            
        }
    }

    public void getred() throws SQLException {

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

            String busName = x.toString();
            PreparedStatement ps = connection.prepareStatement("SELECT count FROM Seat WHERE busname='" + busName + "'");

            resultSet = ps.executeQuery();

            
            while (resultSet.next()) {
                list.add(resultSet.getInt(1));

            }
            
            
            if (list.get(0) == 1) {
                a1.setStyle("-fx-background-color:red");
            }
            if (list.get(1) == 1) {
                a2.setStyle("-fx-background-color:red");

            }
            if (list.get(2) == 1) {
                a3.setStyle("-fx-background-color:red");
            }
            if (list.get(3) == 1) {
                a4.setStyle("-fx-background-color:red");

            }
            if (list.get(4) == 1) {
                B1.setStyle("-fx-background-color:red");
            }

            if (list.get(5) == 1) {
                B2.setStyle("-fx-background-color:red");
            }
            if (list.get(6) == 1) {
                B3.setStyle("-fx-background-color:red");

            }
            if (list.get(7) == 1) {
                B4.setStyle("-fx-background-color:red");
            }
            if (list.get(8) == 1) {
                C1.setStyle("-fx-background-color:red");

            }
            if (list.get(9) == 1) {
                C2.setStyle("-fx-background-color:red");
            }
            if (list.get(10) == 1) {
                C3.setStyle("-fx-background-color:red");

            }
            if (list.get(11) == 1) {
                C4.setStyle("-fx-background-color:red");
            }
            if (list.get(12) == 1) {
                D1.setStyle("-fx-background-color:red");

            }
            if (list.get(13) == 1) {
                D2.setStyle("-fx-background-color:red");
            }
            if (list.get(14) == 1) {
                D3.setStyle("-fx-background-color:red");

            }
            if (list.get(15) == 1) {
                D4.setStyle("-fx-background-color:red");

            }
            if (list.get(16) == 1) {
                E1.setStyle("-fx-background-color:red");

            }
            if (list.get(17) == 1) {
                E2.setStyle("-fx-background-color:red");

            }
            if (list.get(18) == 1) {
                E3.setStyle("-fx-background-color:red");

            }
            if (list.get(19) == 1) {
                E4.setStyle("-fx-background-color:red");

            }
            if (list.get(20) == 1) {
                F1.setStyle("-fx-background-color:red");

            }
            if (list.get(21) == 1) {
                F2.setStyle("-fx-background-color:red");

            }
            if (list.get(22) == 1) {
                F3.setStyle("-fx-background-color:red");

            }
            
             if (list.get(23) == 1) {
                F3.setStyle("-fx-background-color:red");

            }
             if (list.get(24) == 1) {
                G1.setStyle("-fx-background-color:red");

            }
             if (list.get(25) == 1) {
                G2.setStyle("-fx-background-color:red");

            }
             if (list.get(26) == 1) {
                G3.setStyle("-fx-background-color:red");

            }
             if (list.get(27) == 1) {
                G4.setStyle("-fx-background-color:red");

            }
             
             if (list.get(28) == 1) {
                H1.setStyle("-fx-background-color:red");

            }
             if (list.get(29) == 1) {
                H2.setStyle("-fx-background-color:red");

            }
             if (list.get(30) == 1) {
                H3.setStyle("-fx-background-color:red");

            }
             if (list.get(31) == 1) {
                H4.setStyle("-fx-background-color:red");

            }
             
             if (list.get(32) == 1) {
                I1.setStyle("-fx-background-color:red");

            }
             if (list.get(33) == 1) {
                I2.setStyle("-fx-background-color:red");

            }
             if (list.get(34) == 1) {
                I3.setStyle("-fx-background-color:red");

            }
             if (list.get(35) == 1) {
                I4.setStyle("-fx-background-color:red");

            }
             
             if (list.get(36) == 1) {
                J1.setStyle("-fx-background-color:red");

            }
             if (list.get(37) == 1) {
                J2.setStyle("-fx-background-color:red");

            }
             if (list.get(38) == 1) {
                J3.setStyle("-fx-background-color:red");

            }
             if (list.get(39) == 1) {
                J4.setStyle("-fx-background-color:red");

             }
             if (list.get(40) == 1) {
                K1.setStyle("-fx-background-color:red");

            }
             if (list.get(41) == 1) {
                K2.setStyle("-fx-background-color:red");

            }
             if (list.get(42) == 1) {
                K3.setStyle("-fx-background-color:red");

            }
             if (list.get(43) == 1) {
                K4.setStyle("-fx-background-color:red");

            }
             if (list.get(44) == 1) {
                K5.setStyle("-fx-background-color:red");

            }if (list.get(45) == 1) {
                L.setStyle("-fx-background-color:red");

            }
             

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
