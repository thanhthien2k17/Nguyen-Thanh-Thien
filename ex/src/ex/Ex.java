/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vtson
 */
public class Ex {

    /**
     * @param args the command line arguments
     */
    public int nhapso(String a) {
        try {
            return Integer.parseInt(a);
        } catch (Exception ex) {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhap vao mot chuoi");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println("Do dai chuoi: " + String.valueOf(a.length()));
        System.out.println("Chuoi con co 3 ki tu: " + a.substring(0, 2));
        System.out.println("Vi tri ki tu A trong chuoi: " + String.valueOf(a.indexOf("A")));
        System.out.println("Vi tri ki tu A cuoi cung trong chuoi: " + String.valueOf(a.lastIndexOf("A")));
//        /*Viết chương trình nhập số nguyên a, khi nào nhập đúng thì in ra*/
//        int a = -1;
//        try {
//            do {
//                System.out.println("Nhap so nguyen: ");
//                a = new Ex().nhapso(new Scanner(System.in).nextLine());
//            } while (a == -1);
//        } catch (Exception ex) {
//            System.out.println("Thong bao");
//        }

//        Test t = new Test();
//        try {
//            t.nhapso();
//            
//        try {
//            System.out.println("Nhap a: ");
//            Scanner sc = new Scanner(System.in);
//            int a = sc.nextInt();
//        } catch (Exception ex) {
//            for (StackTraceElement s : ex.getStackTrace()) {
//                System.out.println(s.toString());
//            }
//            System.out.println();
//            System.out.println("Ban nhap khong phai so");
//        }
//        } catch (Exception ex) {
//            System.out.println("Nhap so sai");
//            Logger.getLogger(Ex.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            System.out.println("Luon luon chay");
//        }
    }

}
