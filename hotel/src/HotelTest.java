
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thien
 */
public class HotelTest {

    public static void main(String[] args) {
        int choice;
        Scanner nhap = new Scanner(System.in);
        Hotel test = new Hotel();
        Room st = new Room();
        do {

            System.out.println("CHUONG TRINH HOTEL."
                    + "\n1-Dat phong."
                    + "\n2-Tim kiem."
                    + "\n3-Hien thi danh sach phong da dat."
                    + "\n4-Thoat chuong trinh khi nhap 4.");
            System.out.println("Nhap lua chon tu 1 den 3:");
            choice = nhap.nextInt();
            switch (choice) {
                case 1:
                    if (test.book()) {
                        System.out.println("nhap them phong moi:");
                        Room add = new Room();
                        System.out.println("nhap ma khac hang:");
                        add.setId(nhap.nextInt());
                        nhap = new Scanner(System.in);
                        System.out.println("nhap ten khach hang:");
                        add.setName(nhap.nextLine());
                        System.out.println("nhap ma phong:");
                        add.setCode(nhap.nextInt());
                        nhap = new Scanner(System.in);
                        test.addRoom(add);
                    } else {
                        System.out.println("het phong");
                    }
                    break;
                case 2:
                    System.out.println("nhap ma phong can tim");
                    if (test.find(nhap.nextInt()) != 0) {
                        System.out.println(st.toString());
                    } else {
                        System.out.println("khong tim thay phong can tim");
                    }
                    break;
                case 3:
                    Room[] xuat;
                    xuat = new Room[10];
                    xuat = test.readAll();
                    for (int i = 0; i < test.roomOcc; i++) {
                        System.out.println(xuat[i].toString());
                    }
                    break;
                default:
                    break;
            }
        } while (choice != 4);
    }
}
