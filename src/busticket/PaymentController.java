
package busticket;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class PaymentController implements Initializable {

    @FXML
    private TextField FirstName;
    @FXML
    private TextField Mobile;
    @FXML
    private TextField LastName;
    @FXML
    private TextField Email;
    @FXML
    private ComboBox Payment;
    @FXML
    private Label Amount;
    String m;
    @FXML
    private TextField Total_Price;
    @FXML
    private Label user_name;
    @FXML
    private Label TO;
    @FXML
    private Label date;
    @FXML
    private Label From;
    @FXML
    private Label no_of_Seat;
    @FXML
    private Label time;
    @FXML
    private Label Busname;
    @FXML
    private Label tic;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> list1 = FXCollections.observableArrayList("Card", "Bkash");
        Payment.setItems(list1);
        // TODO
    }

    @FXML
    private void Procced_to_pay_button(ActionEvent event) throws IOException, SQLException {

        
           
        
        
        
        
        String F = FirstName.getText();
        String l = LastName.getText();
        String e = Email.getText();
        String mobile = Mobile.getText();
        
        String total =Total_Price.getText();
        
        String from= From.getText();
        String to = TO.getText();
        String bus = Busname.getText();
        String d = date.getText();
        
        String t =time.getText();
        
         String u =user_name.getText();
         String s=no_of_Seat.getText();
         String tic_price=tic.getText();
         
        Connection con;
        try{
        PreparedStatement psInsert = null;
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("Connected");

        psInsert = con.prepareStatement("INSERT INTO Booking_history (`First_Name`,`Last_Name`,`Bus_name`,`Date`,`Time`,`Seat`,`Total_Amount`,`User_name`,`Mobile_No`,`E-mail`,`From_bus`,`To_bus`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        psInsert.setString(1, F);
        psInsert.setString(2, l);
        psInsert.setString(3, bus);
        psInsert.setString(4, d);
         psInsert.setString(5, t);
          psInsert.setString(6, s);
        psInsert.setString(7 ,total);
        psInsert.setString(8, u);
        psInsert.setString(9,mobile);
         psInsert.setString(10, e);
          psInsert.setString(11, from);
        psInsert.setString(12, to);
        
         
        
        psInsert.executeUpdate();
        m = Payment.getSelectionModel().getSelectedItem().toString();

        if (m == "Card") {

            FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Card.fxml"));
            Parent root = fxmlLoader.load();
            
            
        
            CardController card=fxmlLoader.getController();
            
        // card.ticprice(tic_price);
        
        
        
            card.totalPrice(total);
            card.busTO(to);
            card.busfrom(from);
            card.username(u);
            card.date(d);
            card.bus(bus);
            card.time(t);
            card.seat(s);
            card.ticprice(tic_price);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Sign up Page");
            stage.setScene(scene);
            stage.show();

        } else {

            
            FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Bkash.fxml"));
            Parent root = fxmlLoader.load();
             BkashController bkash =fxmlLoader.getController();
             bkash.totalPrice(total);
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Sign up Page");
            stage.setScene(scene);
            stage.show();

        }}
        catch(SQLException yu){
            yu.printStackTrace();
        
        }

    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Payment.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sign up Page");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Back(MouseEvent event) throws IOException, SQLException {

        String from=From.getText();
        String to=TO.getText();
        String d=date.getText();
        String b=Busname.getText();
        String tic_price=tic.getText();
        String u=user_name.getText();
        String departure_time=time.getText();
        String s=no_of_Seat.getText();  
                
        
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Seat.fxml"));
        Parent root = fxmlLoader.load();
        
         SeatController seat = fxmlLoader.getController();

        seat.show_PlaceName_from(from);
        seat.show_PlaceName_to(to);
        seat.show_date(d);
        seat.Bus_name(b);
        seat.show_TPrice(tic_price);
        seat.Dept_time(departure_time);
        seat.username(u);
        seat.no_of_seat(s);
        seat.getred();
       
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sign up Page");
        stage.setScene(scene);
        stage.show();
    }
    
    public void totalPrice(String totalprice){
    
       Total_Price.setText(totalprice);
    
    }
    
    public void user_name(String name){
    
      user_name.setText(name);
    
    }
    
    public void F(String from){
    
      From.setText(from);
    
    }
    
    public void To(String to){
    
      TO.setText(to);
    
    }
    
    public void date(String datE){
    
    date.setText(datE);
    
    }
    public void Time(String t){
    
      time.setText(t);
    
    }
    public void Seat(String seat){
    
      no_of_Seat.setText(seat);
    
    }
    
     public void bus(String b){
    
      Busname.setText(b);
    
    }
     
     public void tic(String T){
     
     tic.setText(T);
     
     }

}
