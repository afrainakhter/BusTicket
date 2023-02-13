/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticket;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class OTPvarificationController implements Initializable {

    @FXML
    private TextField otp;
    @FXML
    private Label hide;
    @FXML
    private Label username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void submit(ActionEvent event) throws IOException {
        String h = hide.getText();
        String o = otp.getText();
        String u = username.getText();
        if (h.equals(o)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDashBoard.fxml"));
            Parent root = loader.load();
            UserDashBoardController userdash = loader.getController();
            userdash.displayName(u);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Welcome");
            stage.show();
        }else{
        
        //ekhane kaj krbo else er
        
        otp.setText("Wrong otp");
        }
    }

    public void radom(String random) {

        hide.setText(random);

    }

    public void user(String name) {

        username.setText(name);

    }

}
