/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticket;

/**
 *
 * @author macbookpro
 */
public class Admin_customer_data {
     int id;
    String name;
      String mobile_no;
      String email;
      String user_name;
      String busname;
      String From_bus;
      String to_bus;

    public Admin_customer_data() {
    }

    public Admin_customer_data(int id, String name, String mobile_no, String email, String user_name, String busname, String From_bus, String to_bus) {
        this.id = id;
        this.name = name;
        this.mobile_no = mobile_no;
        this.email = email;
        this.user_name = user_name;
        this.busname = busname;
        this.From_bus = From_bus;
        this.to_bus = to_bus;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public String getFrom_bus() {
        return From_bus;
    }

    public void setFrom_bus(String From_bus) {
        this.From_bus = From_bus;
    }

    public String getTo_bus() {
        return to_bus;
    }

    public void setTo_bus(String to_bus) {
        this.to_bus = to_bus;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
      
    
    
}

