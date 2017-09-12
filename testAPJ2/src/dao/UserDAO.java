/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UserDTO;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBConnetorDerBy;
import utils.HashUtil;

/**
 *
 * @author vtson
 */
public class UserDAO {

    final private String SQLCREATE = "INSERT INTO USERS VALUES(?,?)";
    final private String SQLREADBYUSERNAME = "SELECT PASSWORD FROM USERS WHERE USERNAME = ?";
    Connection con = null;

    public UserDAO() {
        con = new DBConnetorDerBy().getCon();
    }

    public UserDTO create(UserDTO u) {
        PreparedStatement pr;
        try {
            pr = con.prepareStatement(SQLCREATE);
            pr.setString(1, u.getUsername());
            pr.setString(2, new HashUtil().hashmd5(u.getPassword()));
            pr.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;
    }

    public UserDTO readByUsername(String username) {
        PreparedStatement pr;
        try {
            pr = con.prepareStatement(SQLREADBYUSERNAME);
            pr.setString(1, username);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    UserDTO u = new UserDTO(username, rs.getString(1));
                    return u;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean checkLogin(String username, String password) {
        UserDTO u = readByUsername(username);
        if (u != null) {
            return u.getPassword().equals(password);
        }
        return false;
    }

    public static void main(String[] args) {
        UserDTO u = new UserDTO("admin", "admin");
        //new UserDAO().create(u);
        UserDAO dao = new UserDAO();
        u = dao.readByUsername("admin");

        System.out.println(u.toString());

        if (dao.checkLogin("admin", "ISMvKXpXpadDiUoOSoAfww==")) {
            System.out.println("ok");
        } else {
            System.out.println("fail");
        }
    }
}
