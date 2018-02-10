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
public class asset {
    private int id;
    private String assert_name;
    private String assert_number;
    private assertType assert_type;

    public void setId(int id) {
        this.id = id;
    }

    public void setAssert_name(String assert_name) {
        this.assert_name = assert_name;
    }

    public void setAssert_number(String assert_number) {
        this.assert_number = assert_number;
    }

    public void setAssert_type(assertType assert_type) {
        this.assert_type = assert_type;
    }

    public int getId() {
        return id;
    }

    public String getAssert_name() {
        return assert_name;
    }

    public String getAssert_number() {
        return assert_number;
    }

    public assertType getAssert_type() {
        return assert_type;
    }
    
    
}
