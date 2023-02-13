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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class Admin_AddBusController implements Initializable {

    @FXML
    private TextField Ticket_Price;
    @FXML
    private TextField deptTime;
    @FXML
    private TextField Arival_time;
    @FXML
    private TextField BusName;
    @FXML
    private TableColumn<Bus_list, String> From;
    @FXML
    private TableColumn<Bus_list, String> To;
    @FXML
    private TableColumn<Bus_list, String> bus_Name;
    @FXML
    private TableColumn<Bus_list, Integer> Ticket;
    @FXML
    private TableColumn<Bus_list, String> Dep_time;
    @FXML
    private TableColumn<Bus_list, String> Ari_time;
    @FXML
    private TableView<Bus_list> Bus_Table;
    Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    Bus_list bus = null;

    ObservableList<Bus_list> Bus_List;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    
int index=-1;
    @FXML
    private TableColumn<Bus_list, Integer> ID;
    @FXML
    private TextField Bus_ID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Bus_List = FXCollections.observableArrayList();
        intCOl();

        try {
            load();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_AddBusController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_AddBusController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void intCOl() {
        
        
          ID.setCellValueFactory(new PropertyValueFactory<>("id"));

        bus_Name.setCellValueFactory(new PropertyValueFactory<>("Bus_name"));

        Ticket.setCellValueFactory(new PropertyValueFactory<>("tik_pri"));

        Dep_time.setCellValueFactory(new PropertyValueFactory<>("Dep_time"));

        Ari_time.setCellValueFactory(new PropertyValueFactory<>("Arl_time"));
        From.setCellValueFactory(new PropertyValueFactory<>("from"));

        To.setCellValueFactory(new PropertyValueFactory<>("to"));

        
      

    }

    private void load() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");

        System.out.println("conected");

        try {

            preparedStatement = connection.prepareStatement("Select * From Bus_list");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

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

        Bus_Table.setItems(Bus_List);
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

    @FXML
    private void Add(ActionEvent event) throws SQLException, IOException {
        Connection connection;

        PreparedStatement psInsert = null;

        String busname = BusName.getText();
        String f = from.getText();

        String t = to.getText();
        String tic = Ticket_Price.getText();
       int ticint = Integer.parseInt(tic);
        String dep = deptTime.getText();
        String ari = Arival_time.getText();

        //Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("connected");
try{
       psInsert = connection.prepareStatement("INSERT INTO Bus_list (`Bus_Name`,`From`,`To`,`Ticket_price`,`Departure_time`,`Arival_time`)VALUES(?,?,?,?,?,?)");
        
        psInsert.setString(1, busname);
        psInsert.setString(2, f);
        psInsert.setString(3, t);
        psInsert.setInt(4, ticint);
         psInsert.setString(5, dep);
       psInsert.setString(6, ari);
        
        
       psInsert.executeUpdate();
        System.out.println("ADD BUS Done");

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_AddBus.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
}catch(SQLException e){
    
 e.printStackTrace();

}
        if (psInsert != null) {

            try {

                psInsert.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

        }

    }

    
       
    @FXML
    private void update(ActionEvent event) throws SQLException  {
        
       
        
       
try{
     PreparedStatement psupdate = null;
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("connected");
          String busname = BusName.getText();
        String f = from.getText();
        String t = to.getText();
        String tic = Ticket_Price.getText();
       int ticint = Integer.parseInt(tic);
        String dep = deptTime.getText();
        String ari = Arival_time.getText();
         String id= Bus_ID.getText();
         
         int intid=Integer.parseInt(id);
       
        String sql= ("UPDATE Bus_list SET  `Bus_Name`='"+busname+"',`From`='"+f+"',`To`='"+t+"',`Ticket_price`='"+ticint+"',`Departure_time`='"+dep+"',`Arival_time`='"+ari +"'  WHERE (`BusID`='"+intid+"')");
         psupdate =connection.prepareStatement(sql);
         psupdate.execute();
         
         System.out.println("UPDATE BUS Done");

        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_AddBus.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();

         
} catch(Exception e){

e.printStackTrace();}
        
        
    }

    @FXML
    private void getSelected(MouseEvent event) {
        
        index=  Bus_Table.getSelectionModel().getSelectedIndex();
        if (index<=-1){
        
            return ;
        
        }
        
         Bus_ID.setText(ID.getCellData(index).toString());
        
       
        BusName.setText(bus_Name.getCellData(index));
        from.setText( From.getCellData(index));
        to.setText(To.getCellData(index));
       Ticket_Price.setText( Ticket.getCellData(index).toString());
        Arival_time.setText( Ari_time.getCellData(index));
        deptTime.setText(  Dep_time.getCellData(index));
        
                 
      
        
          
         
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException, IOException {
        
     
         Connection connection;

        PreparedStatement psdelete= null;

        
       
        
        //Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_login", "root", "12345678");
        System.out.println("connected");
   try{
       
        String id= Bus_ID.getText();
         
         int intid=Integer.parseInt(id);
       psdelete = connection.prepareStatement("DELETE FROM Bus_list  WHERE BusID=?");
        psdelete.setInt(1,intid );
        
         psdelete.execute();
         System.out.println("delete bus successful");
         FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_AddBus.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
        
    }catch(SQLException e){
        
        e.printStackTrace();
    }}

    @FXML
    private void dashboard(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
        
        
        
    }

    @FXML
    private void user(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_Customer.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void reviews(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusTicket.class.getResource("Admin_Report.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

}
