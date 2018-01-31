/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.agent;
import Models.vender;
import classes.database;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Randika Lakmal
 */
public class agentController {
    database database;

    public agentController() {
        this.database = new database();
    }
    
    public Vector<vender> getAllVenders(){
        Vector<vender> dataSet = new Vector<>();
        try {
            String getDataQuery = "SELECT * FROM vender";
        
            ResultSet rs= database.getData(getDataQuery);
            
            while(rs.next()){
                vender vender = new vender();
                
                vender.setId(rs.getInt("idvender"));
                vender.setVenderName(rs.getString("vender_name"));
                
                dataSet.add(vender);
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return dataSet;
        
    } 
    
    public boolean saveAgent(agent agent){
        boolean flag = false;
            
        try {
            
            String saveAgentQury = "insert into agent(agent_name,contact,email,vender_idvender) values"
                    + " ('"+agent.getName()+"','"+agent.getContact()+"','"+agent.getEmail()+"','"+agent.getVender().getId()+"')";
            database.putData(saveAgentQury);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        
        return flag;
        
    }
    
}
