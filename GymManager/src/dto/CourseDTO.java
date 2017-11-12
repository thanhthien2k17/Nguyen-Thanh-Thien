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
public class CourseDTO implements Serializable,Comparable<CourseDTO>{
    private int id;
    private String name;
    private String time;
    private float price;
    private String description;
    public CourseDTO() {
    }

    public CourseDTO(int id, String name, String time, float price, String description) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.price = price;
        this.description = description;
    }
    
    public CourseDTO(String name, String time, float price, String description) {
        this.name = name;
        this.time = time;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseDTO{" + "id=" + id + ", name=" + name + ", time=" + time + ", price=" + price + ", description=" + description + '}';
    }
    
    @Override
    public int compareTo(CourseDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
