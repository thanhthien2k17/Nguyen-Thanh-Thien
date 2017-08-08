/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.EmployeeDAO;
import dto.Employee;
import java.util.List;

/**
 *
 * @author thien
 */
public class EmployeeAction {

    EmployeeDAO dao = new EmployeeDAO();

    public Employee creater(Employee e) {
        return dao.creater(e);
    }

    public List<Employee> readAll() {
        return dao.readAll();
    }

    public boolean update(Employee e) {
        return dao.update(e);
    }

    public boolean delete(String code) {
        return dao.delete(code);
    }
}
