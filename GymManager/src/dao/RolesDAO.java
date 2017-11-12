/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import ultils.HashUtils;
import dto.Roles;
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
public class RolesDAO {

    Connection con;
    final String SQLCREATE = "INSERT INTO ROLES VALUES(?,?)";
    final String SQLREADALL = "SELECT * FROM ROLES";
    final String SQLREADBYID = "SELECT * FROM ROLES WHERE ID=?";
    final String SQLREADBYNAME = "SELECT * FROM ROLES WHERE NAME LIKE '%?%'";
    final String SQLREADBYNAMEROLE = "SELECT * FROM ROLES WHERE NAME=?";
    final String SQLUPDATE = "UPDATE ROLES SET NAME =?,DESCRIPTION=? WHERE ID=?";
    final String SQLDELETE = "DELETE FROM ROLES WHERE ID = ?";

    public RolesDAO() {
        con = new DBConnector().getCon();
    }

    public Roles create(Roles r) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setString(1, r.getName());
            pr.setString(2, HashUtils.encryptBlowfish(r.getDescription(), "create"));
            int i = pr.executeUpdate();
            if (i != 0) {
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Roles> readAll() {
        List<Roles> l = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String des = rs.getString(3);
                    l.add(new Roles(id, name, des));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public Roles readById(int id) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    String name = rs.getString(2);
                    String des = HashUtils.decryptBlowfish(rs.getString(3), "create");
                    return new Roles(id, name, des);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Roles> readByName(String name) {
        List<Roles> l = new ArrayList<>();
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYNAME);
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String nam = rs.getString(2);
                    String des = HashUtils.decryptBlowfish(rs.getString(3), "create");
                    l.add(new Roles(id, nam, des));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public Roles readByNameRole(String name) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYNAMEROLE);
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String des =rs.getString(3);
                   return  new Roles(id, name, des);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Roles update(Roles r) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLUPDATE);
            pr.setString(1, r.getName());
            pr.setString(2, new HashUtils().encryptBlowfish(r.getDescription(), "create"));
            pr.setInt(3, r.getId());
            int i = pr.executeUpdate();
            if (i != 0) {
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean delete(int id) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLDELETE);
            pr.setInt(1, id);
            int i = pr.executeUpdate();
            if (i != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
