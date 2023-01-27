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

    public Admin_customer_data() {
    }

    public Admin_customer_data(int id, String name, String mobile_no, String email, String user_name) {
        this.id = id;
        this.name = name;
        this.mobile_no = mobile_no;
        this.email = email;
        this.user_name = user_name;
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

