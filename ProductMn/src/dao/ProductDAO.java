/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bus.ProductBus;
import entity.Product;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class ProductDAO implements ProductBus {

    int len;//so nguyen chi ra so luong san pham co the co
    int n;//so nguyen chi ra so luong san pham thuc su ton tai
    Product[] p = new Product[20];

    public ProductDAO() {
        len = 20;
        n = 0;
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten san pham:");
        String name = sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("nhap code san pham:");
        int code = sc.nextInt();
        System.out.println("nhap gia san pham:");
        int price = sc.nextInt();
        System.out.println("nhap so luong san pham:");
        int quantity = sc.nextInt();
        Product sp = new Product(quantity, price, code, name);
        if (n < len) {
            p[n] = sp;
            n++;
        } else {
            System.out.println("day kho");
        }
    }

    @Override
    public boolean delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap code san pham can xoa:");
        int code = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (code == p[i].getCode()) {
                for (; i < n; i++) {
                    p[i] = p[i + 1];
                }
                n--;
                return true;
            }
        }
        return false;

    }

    @Override
    public void sort() {
        Product temp = new Product();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = p[i].getQuantity() * p[i].getPrice();
                int b = p[j].getPrice() * p[j].getQuantity();
                if (a < b) {
                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }

    @Override
    public void diplay() {
        for (int i = 0; i < n; i++) {
            System.out.println("code=" + p[i].getCode() + ", name=" + p[i].getName() + ", quantity=" + p[i].getQuantity() + ", price=" + p[i].getPrice() + "");
        }
    }

}
