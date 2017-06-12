/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import dao.ProductDAO;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class ProductMn {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. Add");
            System.out.println("2. List");
            System.out.println("3. Delete");
            System.out.println("4. Sort by price");
            System.out.println("5. exit");
            System.out.println("Choose function");
            int choose = sc.nextInt();
            sc = new Scanner(System.in);
            switch (choose) {
                case 1:
                    dao.add();
                    break;
                case 2:
                    dao.diplay();
                    break;
                case 3:
                    if (dao.delete()) {
                        System.out.println("xoa thanh cong");
                    } else {
                        System.out.println("khong co san pham nao dc tim thay");
                    }
                    break;
                case 4:
                    dao.sort();
                    System.out.println("sp sau khi sap xep theo tong gia'");
                    dao.diplay();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }
}
