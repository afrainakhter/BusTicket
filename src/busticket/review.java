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
public class review {
    
    
    
    String name;
    String email;
    int rating;
    String massange;

    public review(String name, String email, int rating, String massange) {
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.massange = massange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMassange() {
        return massange;
    }

    public void setMassange(String massange) {
        this.massange = massange;
    }
    
    
}
