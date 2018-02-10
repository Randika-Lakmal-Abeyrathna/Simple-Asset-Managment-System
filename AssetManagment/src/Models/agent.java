/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Randika Lakmal
 */
public class agent {
    
    vender vender;
    String name;
    String contact;
    String email;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVender(vender vender) {
        this.vender = vender;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public vender getVender() {
        return vender;
    }

    public int getId() {
        return id;
    }

    
    
    
}
