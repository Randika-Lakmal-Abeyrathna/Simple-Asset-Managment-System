/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.vender;
import classes.database;
import java.sql.Connection;

/**
 *
 * @author Randika Lakmal
 */
public class venderController {
   database database;
    public venderController() {
        database = new database();
    }
    
    
    public boolean saveVender(vender vender){
        boolean flag = false;
        try {
            String saveQuery = "INSERT INTO vender(vender_name) VALUES('"+vender.getVenderName()+"')";
            
            database.putData(saveQuery);
            
            flag = true;
            
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
    
}
