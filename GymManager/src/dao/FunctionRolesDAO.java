/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import dto.FunctionRoles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phong
 */
public class FunctionRolesDAO {

    Connection con=null;
    final String SQLCREATE = "INSERT INTO FUNCTIONROLES VALUES(?,?)";
    final String SQLREADALL = "SELECT * FROM FUNCTIONROLES";
    final String SQLREADBYROLE = "SELECT * FROM FUNCTIONROLES WHERE ROLEID=?";
    final String SQLREADBYFUNCTION = "SELECT * FROM FUNCTIONROLES WHERE FUNCTIONID=?";
    final String SQLDELETE = "DELETE FROM FUNCTIONROLES WHERE ROLEID=? AND FUNCTIONID=?";
    
    public FunctionRolesDAO() {
        con = new DBConnector().getCon();
    }

    public FunctionRoles create(FunctionRoles f) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            for (Integer i : f.getFunctionId()) {
                pr.setInt(1, f.getRoleId());
                pr.setInt(2, i);
                int r = pr.executeUpdate();
            }
            return f;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionRolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<FunctionRoles> readAll() {
        List<FunctionRoles> l = new ArrayList<>();
        Map<Integer, List<Integer>> functions = new HashMap<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    int role = rs.getInt(2);
                    if (functions.containsKey(role)) {
                        functions.get(role).add(rs.getInt(3));
                    } else {
                        List<Integer> li = new ArrayList<>();
                        functions.put(role, li);
                        functions.get(role).add(rs.getInt(3));
                    }
                }
            }
            for (Map.Entry<Integer, List<Integer>> f : functions.entrySet()) {
                l.add(new FunctionRoles(f.getKey(), f.getValue()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionRolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public FunctionRoles readByRole(int id) {
        List<Integer> l = new ArrayList<>();
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYROLE);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    l.add(rs.getInt(3));
                }
                return new FunctionRoles(id, l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionRolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<FunctionRoles> readByFunction(int id) {
        List<FunctionRoles> l = new ArrayList<>();
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYFUNCTION);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int role = rs.getInt(2);
                    List<Integer> li = new ArrayList<>();
                    li.add(id);
                    l.add(new FunctionRoles(role, li));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionRolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public boolean delete(int role, int function) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLDELETE);
            pr.setInt(1, role);
            pr.setInt(2, function);
            int i = pr.executeUpdate();
            if (i != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionRolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
