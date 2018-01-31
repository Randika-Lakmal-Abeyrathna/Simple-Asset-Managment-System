/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.vender;
import classes.database;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Randika Lakmal
 */
public class venderController {

    database database;

    public venderController() {
        database = new database();
    }

    public boolean saveVender(vender vender) {
        boolean flag = false;
        try {
            String saveQuery = "INSERT INTO vender(vender_name) VALUES('" + vender.getVenderName() + "')";

            database.putData(saveQuery);

            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public vender getVender(int venderId) {
        vender vender = null;
        try {
            String getVenderQuery = "SELECT * FROM vender WHERE idvender = '" + venderId + "'";

            ResultSet venderDetails = database.getData(getVenderQuery);

            if (venderDetails.next()) {
                vender = new vender();
                vender.setId(venderId);
                vender.setVenderName(venderDetails.getString("vender_name"));
                return vender;
            } else {
                JOptionPane.showMessageDialog(null, "No Data Found Under the id of : " + venderId);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return vender;
    }

}
