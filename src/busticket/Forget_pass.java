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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class Forget_pass implements Initializable {

    @FXML
    private TextField User_name;
    @FXML
    private TextField New_pass;
 
    @FXML
    private Button Next;
    @FXML
    private TextField ques;
    @FXML
    private TextField Ans;
    @FXML
    private Label ERROR;

    String ans, pass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void Back(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Next(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("TicketBooking.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Search(ActionEvent event) throws SQLException, ClassNotFoundException {

        Connection connection;

        PreparedStatement ps;

        //PreparedStatement psCheckUserExists ;
        ResultSet resultset;

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("Connected");

        New_pass.setText("");
        Ans.setText("");

        String u_name = User_name.getText();
        if (u_name.isEmpty()) {

            ERROR.setText("Plese Insert UserName");

        } else {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select SequrityQues, Answer, password from login where user_name=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, u_name);
            resultset = ps.executeQuery();
            if (resultset.next()) {

                ques.setText(resultset.getString(1));
                ans = resultset.getString(2);
                pass = resultset.getString(3);

                ERROR.setText("");

                ps.close();
                resultset.close();

            } else {

                ERROR.setText("Error: Username is incorrect ");

            }

        }

    }

    @FXML
    private void Retrive(ActionEvent event) {
        
        if(ans.equals(Ans.getText())){
            
            New_pass.setText(pass);
            ERROR.setText("Your answer is Corrent ");
        
        }
        else{
            
            ERROR.setText("Your answer is wrong");
            
            New_pass.setText("");
        
        }
        
        
    }

}
