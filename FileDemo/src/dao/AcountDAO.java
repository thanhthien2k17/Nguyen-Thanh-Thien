/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Acount;
import java.util.ArrayList;
import java.util.List;
import until.ProcessFile;

/**
 *
 * @author thien
 */
public class AcountDAO {
    
    public Acount update(Acount e,List<Acount> a) {
        for (Acount ee : a) {
            if (ee.compareTo(e) == 0) {
                ee = e;
                return e;
            }
        }
        return null;
    }

    public boolean delete(String name,List<Acount> a) {
        for (Acount ee : a) {
            if (ee.getUsername().equals(name)) {
                a.remove(ee);
                return true;
            }
        }
        return false;
    }
    
}
