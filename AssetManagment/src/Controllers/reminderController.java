/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.reminder;
import classes.database;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author Randika Lakmal
 */
public class reminderController {
    
    database database;

    public reminderController() {
        database = new database();
    }
    
    public boolean saveReminder(reminder reminder){
        boolean flag = false;
        try {
            String saveReminerQuery = "insert into reminder(reminder) values('"+reminder.getReminder()+"')";
            
            database.putData(saveReminerQuery);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public reminder getReminderByName(String remainderName){
        reminder reminder = null;
        
        try {
            String getReminderDetails = "select * from reminder where remainder ='"+remainderName+"'";
            
            ResultSet reminderData = database.getData(getReminderDetails);
            
            if (reminderData.next()) {
                reminder = new reminder();
                
                reminder.setId(reminderData.getInt("idreminder"));
                reminder.setReminder(reminderData.getString("reminder"));
                
                return reminder;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reminder;
    }
    
    public void getAllReminders(JComboBox comboBox){
        
        try {
            String getReminders = "select * from reminder";
            
            ResultSet reminderData = database.getData(getReminders);
            
            comboBox.removeAllItems();
            while (reminderData.next()) {                
                comboBox.addItem(reminderData.getString("reminder"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
