/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.assertDetails;
import classes.database;

/**
 *
 * @author Randika Lakmal
 */
public class assertDetailsController {
    
    private database database;

    public assertDetailsController() {
        database = new database();
    }
    
    public boolean saveAssertDetails(assertDetails assertDetails){
        boolean flag = false;
        
        try {
            String saveQuery = "insert into assert_details"
                    + "(percase_date,expire_date,warenty_period,serial,"
                    + "assert_idassert,agent_idagent,reminder_date,reminder_idreminder)"
                    + " values ('"+assertDetails.getPrecaseDate()+"','"+assertDetails.getExpierDate()+"'"
                    + ",'"+assertDetails.getWarenty_period()+"','"+assertDetails.getSerial()+"'"
                    + ",'"+assertDetails.getAsset().getId()+"','"+assertDetails.getAgent().getId()+"'"
                    + ",'"+assertDetails.getReminderDate()+"','"+assertDetails.getReminder().getId()+"')";
            
            database.putData(saveQuery);
            
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        
        return flag;
    }
    
    
    
}
