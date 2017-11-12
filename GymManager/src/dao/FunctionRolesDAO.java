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
import java.util.List;
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
    final String SQLREADBYID = "SELECT * FROM FUNCTIONROLES WHERE ROLEID=?";
    final String SQLREADBYFUNCTION = "SELECT * FROM FUNCTIONROLES WHERE FUNCTIONID=?";
    final String SQLDELETE = "DELETE FROM FUNCTIONROLES WHERE ROLEID=? AND FUNCTIONID=?";
    
    public FunctionRolesDAO() {
        con = new DBConnector().getCon();
    }

    public FunctionRoles create(FunctionRoles f){

        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setInt(1, f.getRoleId());
            pr.setInt(2, f.getFunctionId());
            if (pr.executeUpdate() != 0) {
                return f;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionRolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<FunctionRoles> readAll() {
        List<FunctionRoles> l = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int roleId = rs.getInt(2);
                    int functionId = rs.getInt(3);
                    l.add(new FunctionRoles(id, roleId, functionId));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    public FunctionRoles readById(int id) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    int roleId = rs.getInt(2);
                    int funtionId = rs.getInt(3);
                    return new FunctionRoles(id, roleId, funtionId);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean delete(int id) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLDELETE);
            pr.setInt(1, id);
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
