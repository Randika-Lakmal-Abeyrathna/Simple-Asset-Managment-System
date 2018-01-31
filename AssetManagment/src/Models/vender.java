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
public class vender {
    private String venderName;
    private int Id;

    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }
    
    public String getVenderName() {
        return venderName;
    }
    
    
}
