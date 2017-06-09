/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Room;

/**
 *
 * @author Administrator
 */
public class RoomDAO implements RoomBus {

    int max;
    int index;
    Room[] list = new Room[10];

    public RoomDAO() {
        max = 10;
        index = 0;
        for(int i=0;i<max;i++){
            list[i]=new Room();
        }
    }

    

    @Override

    public boolean create(Room r) {
        for (int i = 0; i < 10; i++) {
            if (list[i].isStatus() == false) {
                list[i] = r;
                index++;
                return true;
            }
        }
        return false;
    }
public Room[] readAll() {
        Room[] temp = new Room[index];
        for (int i = 0; i < index; i++) {
            temp[i] = list[i];
        }
        return temp;
    }
    @Override
    public boolean update(String code) {
        if (readByCode(code) != -1) {
            if (list[readByCode(code)].getCode().equals(code)) {
                list[readByCode(code)].setStatus(false);
                return true;
            }
        }
        return false;

    }

    @Override
    public int readByCode(String code) {
        for (int i = 0; i < max; i++) {
            if (list[i].getCode().equals(code)) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public int count() {
        int sl = 0;
        for (int i = 0; i < max; i++) {
            if (list[i].isStatus() == false) {
                sl++;
            }
        }
        return sl;
    }

    @Override
    public int total() {
        int tongGia = 0;
        for (int i = 0; i < max; i++) {
            if (list[i].isStatus() == true) {
                tongGia += list[i].getPrice();
            }
        }
        return tongGia;
    }
}
