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
import javax.swing.JComboBox;

/**
 *
 * @author Randika Lakmal
 */
public class agentController {

    database database;
    private venderController venderController;

    public agentController() {
        this.database = new database();
        venderController = new venderController();
    }

    public Vector<vender> getAllVenders() {
        Vector<vender> dataSet = new Vector<>();
        try {
            String getDataQuery = "SELECT * FROM vender";

            ResultSet rs = database.getData(getDataQuery);

            while (rs.next()) {
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

    public boolean saveAgent(agent agent) {
        boolean flag = false;

        try {

            String saveAgentQury = "insert into agent(agent_name,contact,email,vender_idvender) values"
                    + " ('" + agent.getName() + "','" + agent.getContact() + "','" + agent.getEmail() + "','" + agent.getVender().getId() + "')";
            database.putData(saveAgentQury);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }

        return flag;

    }

    public agent getAgent(int id) {
        agent agent = null;

        try {
            String getAgentQuery = "select * from agent where idagent='" + id + "'";

            ResultSet agentData = database.getData(getAgentQuery);
            if (agentData.next()) {
                agent.setContact(agentData.getString("contact"));
                agent.setEmail(agentData.getString("email"));
                agent.setName(agentData.getString("agent_name"));
                agent.setVender(venderController
                        .getVender(agentData.getInt("vender_idvender")));
                return agent;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return agent;
    }

    public void getAgentsToVender(JComboBox comboBox, String venderName) {
        boolean flag = false;
        int venderId;
        try {

            String getVenderIdQuery = "select * from vender where vender_name='" + venderName + "'";

            ResultSet venderData = database.getData(getVenderIdQuery);
            comboBox.removeAllItems();

            if (venderData.next()) {
                String getAgentQuery = "select * from agent where "
                        + "vender_idvender ='" + venderData.getString("idvender") + "'";

                ResultSet agentData = database.getData(getAgentQuery);

                while (agentData.next()) {
                    flag = true;
                    comboBox.addItem(agentData.getString("agent_name"));
                }
                
                if (!flag) {
                    comboBox.addItem("No Data Found");
                }
                
            } else {
                comboBox.addItem("No Data Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public agent getAgentByName(String agentName){
        agent agent = null;
        try {
            String getAgenyDataQuery = "select * from agent where agent_name='"+agentName+"'";
            
            ResultSet agentData = database.getData(getAgenyDataQuery);
            
            if (agentData.next()) {
                agent = new agent();
                
                agent.setContact(agentData.getString("contact"));
                agent.setEmail(agentData.getString("email"));
                agent.setName(agentData.getString("agent_name"));
                agent.setVender(venderController
                        .getVender(agentData.getInt("vender_idvender")));
                
                return agent;
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return agent;
    }

}
