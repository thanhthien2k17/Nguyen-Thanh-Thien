/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package until;

import dao.AcountDAO;
import dao.EmployeeDAO;
import dto.Acount;
import dto.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class Test {

    public boolean checkLogIn(String name, String pass) {
        ProcessFile f = new ProcessFile();
        List<Acount> e = new ArrayList<>();
        e = f.fileLoad();
        for (Acount i : e) {
            if (i.getUsername().equals(name) && i.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;

    }
    Integer checkInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException n) {
            System.out.println(n.getMessage());
            return null;
        }
    }

    Float checkFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException n) {
            System.out.println(n.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {

        ProcessFile f = new ProcessFile();
        Acount acount = new Acount();
        Employee emp = new Employee();
        EmployeeDAO daoEmp = new EmployeeDAO();
        AcountDAO dao = new AcountDAO();
        Scanner sc = new Scanner(System.in);
        List<Employee> ee = new ArrayList<>();
        ee = f.fileLoadEmp();
        Test test = new Test();
        while (true) {
            try {
                System.out.println("1-Login."
                        + "\n2-Exit.");
                System.out.println("Input your choice: ");
                int choiceAcc = 0;
                choiceAcc = sc.nextInt();
                sc = new Scanner(System.in);
                switch (choiceAcc) {
                    case 1:
                        System.out.println("acount:");
                        String name = sc.nextLine();
                        sc = new Scanner(System.in);
                        System.out.println("password:");
                        String pass = sc.nextLine();
                        if (test.checkLogIn(name, pass) == true) {
                            menu:
                            while (true) {
                                System.out.println("1-Add emp."
                                        + "\n2-View list."
                                        + "\n3-Delete."
                                        + "\n4-Update."
                                        + "\n5-Logout."
                                        + "\n6-Exit.");
                                System.out.println("Input your choice:");
                                int choice = 0;
                                choice = sc.nextInt();
                                sc = new Scanner(System.in);
                                switch (choice) {
                                    case 1:
                                        System.out.println("code:");
                                        String code = sc.nextLine();
                                        if (daoEmp.readByCode(code, ee) == null) {
                                            sc = new Scanner(System.in);
                                            System.out.println("name:");
                                            String name2 = sc.nextLine();
                                            sc = new Scanner(System.in);

                                            System.out.println("salary:");
                                            float salary = test.checkFloat(sc.nextLine());
                                            
                                            emp = new Employee(code, name2, salary);
                                            ee.add(emp);
                                            if (f.fileSave(ee)) {
                                                System.out.println("add thanh cong");
                                            } else {
                                                System.out.println("that bai");
                                            }
                                        } else {
                                            System.out.println("trung ma code");
                                        }
                                        break;
                                    case 2:
                                        for (Employee i : ee) {
                                            System.out.println(i.toString());
                                        }
                                        break;
                                    case 3:
                                        System.out.println("nhap code can delete");
                                        String code1 = sc.nextLine();
                                        sc = new Scanner(System.in);
                                        if (daoEmp.delete(code1, ee)) {
                                            if (f.fileSave(ee)) {
                                                System.out.println("delete thanh cong");
                                            } else {
                                                System.out.println("delete that bai");
                                            }
                                        } else {
                                            System.out.println("delete that bai");
                                        }

                                        break;
                                    case 4:
                                        System.out.println("nhap code can update");
                                        String code2 = sc.nextLine();
                                        sc = new Scanner(System.in);
                                        System.out.println("name:");
                                        String name3 = sc.nextLine();
                                        sc = new Scanner(System.in);
                                        System.out.println("salary:");
                                        float salary1 = sc.nextFloat();
                                        emp = new Employee(code2, name3, salary1);
                                        if (daoEmp.update(emp, ee) != null) {
                                            f.fileSave(ee);
                                            System.out.println("update thanh cong");
                                        } else {
                                            System.out.println("code k ton tai");
                                        }
                                        break;
                                    case 5:
                                        break menu;
                                    case 6:
                                        System.exit(0);
                                }
                            }
                        } else {
                            System.out.println("ten dang nhap hoac mat khau k dung");
                        }
                        break;
                    case 2:
                        System.exit(0);
                }
            } catch (NumberFormatException eee) {

            }
        }
    }
}
