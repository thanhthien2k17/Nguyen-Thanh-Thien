/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import account.Account;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class Bank implements BankBus {

    int next;
    int max;
    int nextAcc;
    Account[] acct = new Account[100];

    public Bank() {
        next = 0;
        max = 100;
        nextAcc = 1;
    }

    @Override
    public void display(Account a) {
        System.out.println(a.toString());
    }

    @Override
    public void create() {
        int eror = 0;
        int balance = 0;
        System.out.println("tao tai khoan moi:");
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten khach hang");
        String cName = sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("nhap so tien gui");
        try {
            balance = sc.nextInt();
            if (balance < 100) {
                eror = 1;
            }
        } catch (Exception e) {
            System.out.println("so tien gui phai la kieu so nguyen");
            eror = 2;
        }
        switch (eror) {
            case 1:
                System.out.println("balance phai > 100d");
                break;
            case 2:
                break;
            default:
                Account r = new Account(cName, nextAcc, balance);
                acct[next] = r;
                next++;
                nextAcc++;
                System.out.println("them tai khoan thanh cong");
                System.out.println("thong tin tai khoan cua khach hang la:" + r.toString());
                break;
        }
    }

    @Override
    public void withdraw() {
        int check = 0, balance = 0, num = 0, eror = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so tai khoan can rut:");
        try {
            num = sc.nextInt();
        } catch (Exception e) {
            eror = 1;
            System.out.println("nhap sai , ma so phai la so nguyen:");
        }
        if (eror == 0) {
            for (int i = 0; i < next; i++) {
                if (acct[i].getNum() != num) {
                } else {
                    display(acct[i]);
                    System.out.println("nhap so tien can rut");
                    sc = new Scanner(System.in);
                    try {
                        balance = sc.nextInt();
                        if (balance > acct[i].getBalance()) {
                            check = 1;
                        }
                    } catch (Exception e) {
                        check = 2;
                    }
                    switch (check) {
                        case 1:
                            System.out.println("so tien rut cao hon so tien co trong tai khoan");
                            break;
                        case 2:
                            System.out.println("nhap sai , phai nhap so tien rut la so nguyen");
                            break;
                        default:
                            acct[i].setBalance(acct[i].getBalance() - balance);
                            balance = acct[i].getBalance();
                            check = 3;
                            break;
                    }
                }
            }
            if (check == 0) {
                System.out.println("tai khoan k ton tai");
            }
            if (check == 3) {
                System.out.println("rut tien thanh cong ,tai khoan con lai a:" + balance);
            }
        }
    }

    @Override
    public void deposit() {
        int check = 0, balance = 0, num = 0, eror = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so tai khoan can gui:");
        do {
            try {
                num = sc.nextInt();
            } catch (Exception e) {
                eror = 1;
                System.out.println("nhap sai , ma so phai la so nguyen,nhap lai:");
            }
        } while (eror == 1);
        for (int i = 0; i < next; i++) {
            if (acct[i].getNum() == num) {
                display(acct[i]);
                System.out.println("nhap so tien can gui");
                sc = new Scanner(System.in);
                try {
                    balance = sc.nextInt();
                } catch (Exception e) {
                    check = 2;
                }
                switch (check) {
                    case 1:
                        break;
                    case 2:
                        System.out.println("nhap sai , phai nhap so tien rut la so nguyen");
                        break;
                    default:
                        acct[i].setBalance(acct[i].getBalance() + balance);
                        balance = acct[i].getBalance();
                        check = 3;
                        break;
                }
            }
        }
        if (check == 0) {
            System.out.println("tai khoan k ton tai");
        } else {
            System.out.println("gui tien thanh cong ,tai khoan con lai a:" + balance);
        }
    }
}
