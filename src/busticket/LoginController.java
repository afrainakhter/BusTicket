package busticket;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Alert.AlertType;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class LoginController implements Initializable {

    @FXML
    private TextField UserNAme;
    @FXML
    private TextField Pass;
    ResultSet resultSet = null;
    PreparedStatement pst = null;
    Connection con;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void LOGIN(ActionEvent event) throws ClassNotFoundException, SQLException, Exception {

        String u = UserNAme.getText();
      
        
        String p = Pass.getText();
        if (u.equals("") && p.equals("")) {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
              a.show();
            a.setContentText("Invalid User name or Password");

        } else {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
            System.out.println("conected");
           
           pst=con.prepareStatement("select * from login where user_name=? and password=?");
            
            pst.setString(1,u);
            pst.setString(2,p);
            resultSet=pst.executeQuery();
            
            if (resultSet.next()) {

             
                FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDashBoard.fxml"));
                Parent root = loader.load();
                 UserDashBoardController user=loader.getController();
                user.displayName(u);
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Welcome");
                stage.show();

            } else {

                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText("Worng PassWord");
                a.show();
                UserNAme.setText("");
                Pass.setText("");
            }

        }

    }

    @FXML
    private void BACK_HOME(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Home.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void forget_pass(ActionEvent event) throws IOException {
        
        
        
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Forget_pass.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();

        
        
    }

    @FXML
    private void Creat_acc(ActionEvent event) throws IOException {
        
        
        
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Register.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sign up Page");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Admin_login(MouseEvent event) throws IOException {
        
        
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("AdminLogin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sign up Page");
        stage.setScene(scene);
        stage.show();
    }

    
}



    