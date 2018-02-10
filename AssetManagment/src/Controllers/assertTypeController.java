/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.assertType;
import classes.database;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author Randika Lakmal
 */
public class assertTypeController {
    
    private database database; 

    public assertTypeController() {
        database= new database();
    }
    
    public void getAllAssetType(JComboBox comboBox){
        try {
            
            String getAssetTypeQury = "select type from assert_type";
            
            ResultSet dataSet = database.getData(getAssetTypeQury);
            comboBox.removeAllItems();
            while (dataSet.next()) {                
                comboBox.addItem(dataSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public assertType getAssetType(String assertName){
        assertType type  =null;
        
        try {
            String getAssertQuery = "select * from assert_type where type='"+assertName+"'";
            ResultSet assertTypeData = database.getData(getAssertQuery);
            
            if (assertTypeData.next()) {
                type=new assertType();
                type.setId(assertTypeData.getInt("idassert_type"));
                type.setType(assertTypeData.getString("type"));
                return type;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type;
    }
    
    public assertType getAssetType(int id){
        assertType type = null;
        
        try {
            String getAssertQuery = "select * from assert_type where idassert_type='"+id+"'";
            ResultSet assertData = database.getData(getAssertQuery);
            if (assertData.next()) {
                type = new assertType();
                type.setId(id);
                type.setType(assertData.getString("type"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type;
    }
    
}
