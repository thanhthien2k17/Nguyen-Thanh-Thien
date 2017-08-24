/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.BankDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultils.DBConnector;

/**
 *
 * @author thien
 */
public class BankDAO {

    final private String SQLCREATE = "INSERT INTO BANKMANAGER VALUES(?,?,?)";
    final private String SQLREADALL = "SELECT * FROM BANKMANAGER";
    final private String SQLUPDATE = "UPDATE BANKMANAGER SET NAME=?,ADDRESS=? WHERE NUMBER=?";
    final private String SQLDELETE = "DELETE FROM BANKMANAGER WHERE NUMBER=?";
    Connection con = null;

    public BankDAO() {
        con = new DBConnector().getCon();
    }

    public BankDTO create(BankDTO e) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setString(1, e.getNumber());
            pr.setString(2, e.getName());
            pr.setString(3, e.getAddress());
            pr.executeUpdate();
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<BankDTO> readAll() {
        List<BankDTO> list = new ArrayList<>();
        try {
            Statement pr = con.createStatement();
            ResultSet rs = pr.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    BankDTO ac = new BankDTO();
                    ac.setNumber(rs.getString(1));
                    ac.setName(rs.getString(2));
                    ac.setAddress(rs.getString(3));
                    list.add(ac);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public BankDTO update(BankDTO e) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLUPDATE);
            ps.setString(1, e.getName());
            ps.setString(2, e.getAddress());
            ps.setString(3, e.getNumber());
            ps.executeUpdate();
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public boolean delete(String number) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQLDELETE);
            ps.setString(1, number);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
