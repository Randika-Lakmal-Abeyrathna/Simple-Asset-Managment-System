/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.asset;
import classes.database;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author Randika Lakmal
 */
public class assetController {

    private database database;
    private assertTypeController typeController;

    public assetController() {
        database = new database();
        typeController = new assertTypeController();
    }
    
    public boolean saveAsset(asset asset){
        boolean flag  = false;
        try {
            String saveQuery  = "insert into assert(assert_name,assert_number,assert_type_idassert_type)"
                    + " value('"+asset.getAssert_name()+"','"+asset.getAssert_number()+"','"+asset.getAssert_type().getId()+"')";
            
            database.putData(saveQuery);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
    
    public asset getAsset(String name,String number){
        asset asset = null;
        try {
            String getAssetQuery;
            if (name.isEmpty()) {
                getAssetQuery = "select * from assert where assert_number='"+number+"'";
            }else if (number.isEmpty()) {
                getAssetQuery = "select * from assert where assert_name='"+name+"'";
            }else{
                getAssetQuery = "select * from assert where"
                        + " assert_name='"+name+"' and assert_number='"+number+"'";
            }
            ResultSet assertData = database.getData(getAssetQuery);
            
            if (assertData.next()) {
                asset = new asset();
                asset.setAssert_name(assertData.getString("assert_name"));
                asset.setAssert_number(assertData.getString("assert_number"));
                asset.setAssert_type(typeController
                        .getAssetType(assertData.getInt("assert_type_idassert_type")));
                
                return asset;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
