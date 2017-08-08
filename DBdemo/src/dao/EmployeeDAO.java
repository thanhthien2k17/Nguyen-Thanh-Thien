/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DB.Database;
import dto.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class EmployeeDAO {

    final private String SQLCREATE = "INSERT INTO EMP VALUES(?,?,?,?,?,?)";
    final private String SQLREADALL = "SELECT * FROM EMP";
    final private String SQLRUPDATE = "UPDATE EMP SET NAME = ?, AGE = ?, SALARY = ?, USERNAME = ?, ROLE = ? WHERE CODE = ?";
    final private String SQLDELETE = "DELETE FROM EMP WHERE CODE = ?";
    List<Employee> list = null;
    Connection con = null;

    public EmployeeDAO() {
        list = new ArrayList<>();
        con = new Database().getCon();
    }

    public Employee creater(Employee e) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setString(1, e.getCode());
            pr.setString(2, e.getName());
            pr.setInt(3, e.getAge());
            pr.setFloat(4, e.getSalary());
            pr.setString(5, e.getUsername());
            pr.setInt(6, e.getRole());
            int i = pr.executeUpdate();
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Employee> readAll() {
        try {
            list = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setCode(rs.getString(1));
                    emp.setName(rs.getString(2));
                    emp.setAge(rs.getInt(3));
                    emp.setSalary(rs.getFloat(4));
                    emp.setUsername(rs.getString(5));
                    emp.setRole(rs.getInt(6));
                    list.add(emp);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean update(Employee e) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLRUPDATE);

            pr.setString(1, e.getName());
            pr.setInt(2, e.getAge());
            pr.setFloat(3, e.getSalary());
            pr.setString(4, e.getUsername());
            pr.setInt(5, e.getRole());
            pr.setString(6, e.getCode());
            int i = pr.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(String code) {

        try {
            PreparedStatement pr = con.prepareStatement(SQLDELETE);
            pr.setString(1, code);
            int i = pr.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
