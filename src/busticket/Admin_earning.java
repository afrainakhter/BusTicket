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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class Admin_earning implements Initializable {

    @FXML
    private BarChart<?, ?> IncomeChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
 Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            chart();
            // TODO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_earning.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_earning.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    
    
      public void chart() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        preparedStatement = connection.prepareStatement("Select `Date`, `Total_Amount` From Booking_history");
        XYChart.Series set = new XYChart.Series();
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            set.getData().add(new XYChart.Data(resultSet.getString(1), resultSet.getInt(2)));
//        set.getData().add(new XYChart.Data(resultSet.getInt(1), 4));
//        set.getData().add(new XYChart.Data(resultSet.getInt(1), 3));
//        set.getData().add(new XYChart.Data(resultSet.getInt(1), 2));

        }

       IncomeChart.getData().addAll(set);
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
    
}
