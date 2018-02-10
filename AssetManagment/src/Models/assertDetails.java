/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author Randika Lakmal
 */
public class assertDetails {
    private Date precaseDate; 
    private Date expierDate;
    private String warenty_period;
    private String serial;
    private asset asset;
    private agent agent;
    private reminder reminder;
    private Date reminderDate;

    public Date getPrecaseDate() {
        return precaseDate;
    }

    public void setPrecaseDate(Date precaseDate) {
        this.precaseDate = precaseDate;
    }

    public Date getExpierDate() {
        return expierDate;
    }

    public void setExpierDate(Date expierDate) {
        this.expierDate = expierDate;
    }

    public String getWarenty_period() {
        return warenty_period;
    }

    public reminder getReminder() {
        return reminder;
    }

    
    
    public void setWarenty_period(String warenty_period) {
        this.warenty_period = warenty_period;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public asset getAsset() {
        return asset;
    }

    public void setAsset(asset asset) {
        this.asset = asset;
    }

    public agent getAgent() {
        return agent;
    }

    public void setAgent(agent agent) {
        this.agent = agent;
    }

    public void setReminder(reminder reminder) {
        this.reminder = reminder;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public Date getReminderDate() {
        return reminderDate;
    }
    
    
}
