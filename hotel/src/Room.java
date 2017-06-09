
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
public class Room {
    private int id;
    private String name;
    private int code;

    public Room(){
    }

    public Room(int id, String name, int code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", name=" + name + ", code=" + code + '}';
    }
    
}
