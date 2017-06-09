/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Administrator
 */
public class Room {
    private String code;
    private int price;
    private boolean status;
    
    public Room(){
        status=false;
    }
    public Room(String code, int price, boolean status) {
        this.code = code;
        this.price = price;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" + "code=" + code + ", price=" + price + ", status=" + status + '}';
    }

    
}
