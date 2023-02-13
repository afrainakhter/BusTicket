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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class Payment_successfullController implements Initializable {

    @FXML
    private AnchorPane Dhaka_to_Dinajpur;
    @FXML
    private FontAwesomeIcon Back;
    Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;
    @FXML
    private TextField username;
    @FXML
    private Label to;
    @FXML
    private Label From;
    @FXML
    private Label date;
    @FXML
    private Label busname;
    @FXML
    private Label time;
    @FXML
    private Label seat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void BACK(MouseEvent event) {

    }

    @FXML
    private void Exit(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
        String u = username.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserDashBoard.fxml"));
        Parent root = fxmlLoader.load();

        UserDashBoardController user = fxmlLoader.getController();
        user.displayName(u);

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void receipt_Printer(ActionEvent event) throws ClassNotFoundException, SQLException, JRException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");

        System.out.println("conected");

        String u = username.getText();
        String f = From.getText();
        String t = to.getText();
        String s = seat.getText();

        JasperDesign jdesign = JRXmlLoader.load("/Users/macbookpro/NetBeansProjects/BusTicket/src/busticket/PaySlip.jrxml");
        String sql = "SELECT * from Booking_history WHERE `User_name`='" + u + "'AND `From_bus`='" + f + "' AND `To_bus`='" + t + "' AND `Seat`='" + s + "' ";

        JRDesignQuery updateQuery = new JRDesignQuery();

        updateQuery.setText(sql);
        jdesign.setQuery(updateQuery);

        // JasperReport jreport =JasperCompileManager.compileReport("/Users/macbookpro/NetBeansProjects/BusTicket/src/busticket/PaySlip.jrxml");
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);

        JasperPrint jPrint = JasperFillManager.fillReport(jreport, null, connection);
        JasperViewer.viewReport(jPrint, false);

    }

    public void username(String user_name) {

        username.setText(user_name);

    }

    public void busfrom(String frombus) {

        From.setText(frombus);

    }

    public void date(String d) {

        date.setText(d);

    }

    public void bus(String b) {

        busname.setText(b);

    }

    public void seat(String s) {

        seat.setText(s);

    }

    public void time(String Time) {

        time.setText(Time);

    }

    public void busTO(String tobus) {

        to.setText(tobus);

    }

}
