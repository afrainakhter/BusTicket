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
public class MyBooking {
    
    String user_name;
    String bus_name;
    String from;
    String to;
    String time;
    String seat_name;
  int total_amount;
  String date;

    public MyBooking(String user_name, String bus_name, String from, String to, String time, String seat_name, int total_amount, String date) {
        this.user_name = user_name;
        this.bus_name = bus_name;
        this.from = from;
        this.to = to;
        this.time = time;
        this.seat_name = seat_name;
        this.total_amount = total_amount;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    

    public MyBooking() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeat_name() {
        return seat_name;
    }

    public void setSeat_name(String seat_name) {
        this.seat_name = seat_name;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }
    
    
    
    
}
