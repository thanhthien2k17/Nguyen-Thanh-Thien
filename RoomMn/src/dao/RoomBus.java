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
public interface RoomBus {

    public boolean create(Room r);

    public boolean update(String code);

    public int readByCode(String code);

    public int count();

    public int total();
    
}
