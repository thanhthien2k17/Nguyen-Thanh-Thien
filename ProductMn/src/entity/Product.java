/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author thien
 */
public class Product extends Good {

    private int quantity;
    private int price;
    public Product() {
    }

    public Product(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Product(int quantity, int price, int code, String name) {
        super(code, name);
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "quantity=" + quantity + ", price=" + price + "code=" + code + ", name=" + name +'}';
    }



}
