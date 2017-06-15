/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import bus.Bank;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class BankTest {

    public static void main(String[] args) {
        Bank dao = new Bank();
        Scanner sc = new Scanner(System.in);

        System.out.println("Employee manager");
        do {
            System.out.println("1. Them tai khoan");
            System.out.println("2. Rut tien");
            System.out.println("3. Gui tien");
            System.out.println("4. exit");
            System.out.println("Choose function");
            int choose = sc.nextInt();
            sc = new Scanner(System.in);
            switch (choose) {
                case 1:
                    dao.create();
                    break;
                case 2:
                    dao.withdraw();
                    break;
                case 3:
                    dao.deposit();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }
}
