/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CustomerDTO;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import db.DBConnector;

/**
 *
 * @author Aptech
 */
public class CustomerDAO {

    Connection con = null;
    final private String SQLCREATE = "INSERTS INTO CUSTOMER VALUES (?,?,?,?)";
    final private String SQLREADALL = "SELECT * FROM CUSTOMER ";
    final String SQLUPDATE = "UPDATE CUSTOMER SET ADDRESS = ?,PHONE = ?,NAME = ? WHERE ID = ?";
    final String SQLDELETE = "DELETE FROM CUSTOMER WHERE ID = ?";

    public CustomerDAO() {
        con = new DBConnector().getCon();
    }

    public CustomerDTO create(CustomerDTO c) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLCREATE);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setInt(3, c.getPhone());
            ps.setString(4, c.getAddress());
            int i = ps.executeUpdate();
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public java.util.List<CustomerDTO> readAll() {
        java.util.List<CustomerDTO> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    CustomerDTO c = new CustomerDTO();
                    c.setId(rs.getInt(1));
                    c.setName(rs.getString(2));
                    c.setPhone(rs.getInt(3));
                    c.setAddress(rs.getString(4));

                    list.add(c);
                }
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public CustomerDTO update(CustomerDTO s) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLUPDATE);
            ps.setString(1, s.getAddress());
            ps.setInt(2, s.getPhone());
            ps.setString(3, s.getName());
            ps.setInt(4, s.getId());
            int i = ps.executeUpdate();
            if( i !=0 ){
                return s;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public boolean delete(int customerid) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLDELETE);
            ps.setInt(1, customerid);
            int i = ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }


}
