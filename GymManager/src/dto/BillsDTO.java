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
public class BillsDTO implements Serializable, Comparable<BillsDTO>{
    private int id;
    private int invoiceid;
    private int courseid;
    private float price;

    public BillsDTO() {
    }

    public BillsDTO(int id, int invoiceid, int courseid, float price) {
        this.id = id;
        this.invoiceid = invoiceid;
        this.courseid = courseid;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BillsDTO{" + "id=" + id + ", invoiceid=" + invoiceid + ", courseid=" + courseid + ", price=" + price + '}';
    }
    
    @Override
    public int compareTo(BillsDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
