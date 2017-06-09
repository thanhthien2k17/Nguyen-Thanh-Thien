/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.RoomDAO;
import entity.Room;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class RoomTest {

    public static void main(String[] args) {

        RoomDAO dao = new RoomDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println("Employee manager");
        do {
            System.out.println("1. dat phong");
            System.out.println("2. so phong con trong");
            System.out.println("3. tim kiem");
            System.out.println("4. tra phong");
            System.out.println("5. hien thi phong da dat");
            System.out.println("6. tong tien cac phong da dat");
            System.out.println("7. exit");
            int choose = sc.nextInt();
            sc = new Scanner(System.in);

            switch (choose) {
                case 1:
                    System.out.println("Code: ");
                    String code = sc.nextLine();
                    System.out.println("Price: ");
                    int price = sc.nextInt();
                    sc = new Scanner(System.in);
                    Room e = new Room(code, price, true);
                    if (dao.create(e) == false) {
                        System.out.println("het phong");
                    } else {
                        System.out.println("dat phong thanh cong");
                    }

                    break;

                case 2:
                    System.out.println(dao.count());
                    break;
                case 3:

                    System.out.println("nhap code phong can tim:");
                    String code1 = sc.nextLine();
                    Room[] list1 = dao.readAll();
                    int i = dao.readByCode(code1);
                    System.out.println(list1[i].toString());
                    break;
                case 4:
                    System.out.println("nhap code phong can tra");
                    String code2 = sc.nextLine();
                    if (dao.update(code2) == true) {
                        System.out.println("tra phong thanh cong");
                    }
                    break;
                case 5:
                    Room[] list2 = dao.readAll();
                    for (Room abc : list2) {
                        if (abc.isStatus() == true) {
                            System.out.println(abc.toString());
                        }
                    }
                    break;
                case 6:
                    System.out.println(dao.total());

                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }

}
