/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vtson
 */
public class EmployeeDAO {


    public Employee readByCode(String code,List<Employee> listE) {
        for (Employee i :listE) {
            if (i.getCode().equals(code)) {
                return i;
            }
        }
        return null;
    }

    public Employee update(Employee e,List<Employee> listE) {
        for (Employee i:listE) {
            if (i.getCode().equals(e.getCode())) {
                i = e;
                return i;
            }
        }
        return null;
    }

    public boolean delete(String code,List<Employee> listE) {
        for (Employee i:listE) {
            if (i.getCode().equals(code)) {
                listE.remove(i);
                return true;
            }
        }
        return false;
    }
}
