/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thien
 */
public class Hotel {

    int capacity;
    int roomOcc;
    Room res[] = new Room[10];

    public Hotel() {
        capacity = 10;
        roomOcc = 0;
    }

    
    public Room[] addRoom(Room s) {
        res[roomOcc] = s;
        roomOcc++;
        capacity--;
        return res;
    }

    public void display(Room item) {
        item.toString();
    }

    public Room[] readAll() {
        return res;
    }

    public boolean book() {
        if (capacity - roomOcc > 0) {
            return true;
        }
        return false;
    }

    public int find(int code) {
        for (int i = 0; i < capacity; i++) {
            if (code == res[i].getCode()) {
                return i;
            }
        }
        return 0;
    }
}
