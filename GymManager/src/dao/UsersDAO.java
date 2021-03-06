/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import ultils.HashUtils;
import dto.Users;
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
public class UsersDAO {

    Connection con;
    final String SQLCREATE = "INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?)";
    final String SQLREADALL = "SELECT * FROM USERS";
    final String SQLREADBYNAME = "SELECT * FROM USERS WHERE USERNAME=?";
    final String SQLSEARCHBYNAME = "SELECT * FROM USERS WHERE USERNAME ";
    final String SQLREADBYID = "SELECT * FROM USERS WHERE ID=?";
    final String SQLUPDATEPASSWORD = "UPDATE USERS SET PASSWORD=? WHERE USERNAME=?";
    final String SQLUPDATE = "UPDATE USERS SET USERNAME=?,PASSWORD=?,ROLEID=?,ISACTIVE=?,ADDRESS = ?,PHONE = ?,EMAIL = ?,FULLNAME = ? WHERE ID=?";
    final String SQLDELETE = "DELETE FROM USERS WHERE USERNAME=?";

    public UsersDAO() {
        con = new DBConnector().getCon();
    }

    public Users create(Users u) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setString(1, u.getUsername());
            pr.setString(2, new HashUtils().hashmd5(u.getPassword()));
            pr.setInt(3, u.getRoleId());
            pr.setInt(4, u.getIsActive());
            pr.setString(5, u.getAddress());
            pr.setString(6, u.getPhone());
            pr.setString(7, u.getEmail());
            pr.setString(8, u.getFullName());
            int i = pr.executeUpdate();
            if (i != 0) {
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Users> readAll() {
        List<Users> l = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String username = rs.getString(2);
                    String password = rs.getString(3);
                    int role = rs.getInt(4);
                    int active = rs.getInt(5);
                    String address = rs.getString(6);
                    String phone = rs.getString(7);
                    String email = rs.getString(8);
                    String fullname = rs.getString(9);
                    l.add(new Users(id, username, password, role, active, address, phone, email, fullname));
                            
//                    l.add(new Users(id, username, password, role, active));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public Users readByName(String name) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYNAME);
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    String password = rs.getString(3);
                    int role = rs.getInt(4);
                    int active = rs.getInt(5);
                    String address = rs.getString(6);
                    String phone = rs.getString(7);
                    String email = rs.getString(8);
                    String fullname = rs.getString(9);
                    return new Users(id, fullname, password, role, active, address, phone, email, fullname);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Users readById(int id) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    String name = rs.getString(2);
                    String password = rs.getString(3);
                    int role = rs.getInt(4);
                    int active = rs.getInt(5);
                    String address = rs.getString(6);
                    String phone = rs.getString(7);
                    String email = rs.getString(8);
                    String fullname = rs.getString(9);
                    return new Users(id, fullname, password, role, active, address, phone, email, fullname);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Users update(Users u) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLUPDATE);
            pr.setString(1, u.getUsername());
            pr.setString(2, new HashUtils().hashmd5(u.getPassword()));
            pr.setInt(3, u.getRoleId());
            pr.setInt(4, u.getIsActive());
            pr.setString(5, u.getAddress());
            pr.setString(6, u.getPhone());
            pr.setString(7, u.getEmail());
            pr.setString(8, u.getFullName());
            pr.setInt(9, u.getId());
            int i = pr.executeUpdate();
            if (i != 0) {
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Users updatePassword(Users u) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLUPDATEPASSWORD);
            pr.setString(1, new HashUtils().hashmd5(u.getPassword()));
            pr.setString(2, u.getUsername());
            int i = pr.executeUpdate();
            if (i != 0) {
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean delete(String name) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLDELETE);
            ps.setString(1, name);
            int i = ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
