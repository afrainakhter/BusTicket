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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class User_ReviewController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField massage;
    @FXML
    private Button submit;

    int count1 = 0, count2 = 0, count3 = 0, count4 = 0, result;
    
  
    @FXML
    private FontAwesomeIcon four;
    @FXML
    private FontAwesomeIcon two;

    @FXML
    private FontAwesomeIcon five;
    @FXML
    private FontAwesomeIcon three;
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void BACK(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("UserDashBoard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Book Your ticket");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Starfour(MouseEvent event) {
        four.setFill(Color.ORANGE);
        count1 = 1;

    }

    @FXML
    private void Starthree(MouseEvent event) {
        three.setFill(Color.ORANGE);
        count2 = 1;
        
    }

    @FXML
    private void starTwo(MouseEvent event) {
        two.setFill(Color.ORANGE);
        count3 = 1;

    }

    @FXML
    private void Starfive(MouseEvent event) {
        five.setFill(Color.ORANGE);
        count4 = 1;

    }

    @FXML
    private void submit(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

        Connection con;

        PreparedStatement psInsert = null;
        result = 1 + count1 + count2 + count3 + count4;
        int x= result;
        System.out.println(result);

        //String res = Integer.toString(result);
       // int res=Integer.parseInt(result);
        String n = name.getText();
        String em = email.getText();
        String m = massage.getText();

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");

        System.out.println("Connected");

        try {

            psInsert = con.prepareStatement("INSERT INTO Review(Name,email,Rating,massage) VALUES (?,?,?,?)");

            psInsert.setString(1, n);
            psInsert.setString(2, em);
            psInsert.setInt(3, x);
            psInsert.setString(4, m);
            
            
             psInsert.executeUpdate();
             
             Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
             alert.setContentText("Thanks for your Valuable review");
             alert.show();
             
             
             
              FXMLLoader loader = new FXMLLoader(getClass().getResource("User_Review.fxml"));
                Parent root = loader.load();
                
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Give a Review");
                stage.show();
             
             
             
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
    }

}
