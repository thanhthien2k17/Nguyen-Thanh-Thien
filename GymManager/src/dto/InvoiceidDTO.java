/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class InvoiceidDTO implements Serializable, Comparable<InvoiceidDTO>{
    private int id;
    private int userid;
    private String datetime;
    private int total;

    public InvoiceidDTO() {
    }

    public InvoiceidDTO(int id, int userid, String datetime, int total) {
        this.id = id;
        this.userid = userid;
        this.datetime = datetime;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "InvoiceidDTO{" + "id=" + id + ", userid=" + userid + ", datetime=" + datetime + ", total=" + total + '}';
    }
    

    @Override
    public int compareTo(InvoiceidDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
