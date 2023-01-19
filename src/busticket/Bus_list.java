package busticket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbookpro
 */
public class Bus_list {
    
    String Bus_name;
    String Dep_time;
    String Arl_time;
    String from;
    String to;
    int tik_pri;

    public Bus_list() {
    }

    public Bus_list(String Bus_name, String Dep_time, String Arl_time, String from, String to, int tik_pri) {
        this.Bus_name = Bus_name;
        this.Dep_time = Dep_time;
        this.Arl_time = Arl_time;
        this.from = from;
        this.to = to;
        this.tik_pri = tik_pri;
    }

    public String getBus_name() {
        return Bus_name;
    }

    public void setBus_name(String Bus_name) {
        this.Bus_name = Bus_name;
    }

    public String getDep_time() {
        return Dep_time;
    }

    public void setDep_time(String Dep_time) {
        this.Dep_time = Dep_time;
    }

    public String getArl_time() {
        return Arl_time;
    }

    public void setArl_time(String Arl_time) {
        this.Arl_time = Arl_time;
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

    public int getTik_pri() {
        return tik_pri;
    }

    public void setTik_pri(int tik_pri) {
        this.tik_pri = tik_pri;
    }
    

}