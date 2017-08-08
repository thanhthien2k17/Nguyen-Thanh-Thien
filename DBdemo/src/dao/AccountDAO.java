/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DB.Database;
import dto.Account;
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
public class AccountDAO {

    final private String SQLCREATE = "INSERT INTO ACCOUNT VALUES(?,?)";
    final private String SQLREADALL = "SELECT * FROM ACCOUNT";
    final private String SQLRUPDATE = "UPDATE ACCOUNT SET PASSWORD = ? WHERE USERNAME = ?";
    final private String SQLDELETE = "DELETE FROM ACCOUNT WHERE USERNAME = ?";
    List<Account> list = null;

    Connection con = null;

    public AccountDAO() {

        con = new Database().getCon();

        list = new ArrayList<>();
    }

    //CRUD
    public Account create(Account ac) {
        try {

            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setString(1, ac.getUsername());
            pr.setString(2, ac.getPassword());
            int i = pr.executeUpdate();
            return ac;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Account> readAll() {
        list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    Account ac = new Account();
                    ac.setUsername(rs.getString(1));
                    ac.setPassword(rs.getString(2));
                    list.add(ac);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Account update(Account ac) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLRUPDATE);
            pr.setString(1, ac.getPassword());
            pr.setString(2, ac.getUsername());

            int i = pr.executeUpdate();
            return ac;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean delete(String username) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLDELETE);
            pr.setString(1, username);
            int i = pr.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
