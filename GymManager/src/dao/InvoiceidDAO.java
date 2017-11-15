/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import dto.InvoiceidDTO;
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
 * @author Admin
 */
//String sql = "YOUR INSERT STATEMENT HERE";
// 
//PreparedStatement ps = conn.prepareStatement(sql,
//        Statement.RETURN_GENERATED_KEYS);
// 
//ps.execute();
// 
//ResultSet rs = ps.getGeneratedKeys();
//int generatedKey = 0;
//if (rs.next()) {
//    generatedKey = rs.getInt(1);
//}
// 
//System.out.println("Inserted record's ID: " + generatedKey);
public class InvoiceidDAO {

    Connection con = null;
    final private String SQLCREATE = "INSERT INTO INVOICEID VALUES (?,?,?)";
    final private String SQLREADALL = "SELECT * FROM INVOICEID ";
    final private String SQLUPDATE = "UPDATE INVOICEID SET USERID = ?, DATE = ?, TOTAL = ? WHERE ID = ?";
    final private String SQLDELETE = "DELETE FROM INVOICEID WHERE ID = ? ";
    final private String SQLKEY = "YOUR INSERT INVOICEID HERE";

    public int key() {
        int generatedKey = 0;
        try {
            PreparedStatement ps = con.prepareStatement(SQLKEY,
                    Statement.RETURN_GENERATED_KEYS);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InvoiceidDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generatedKey;
    }

    public InvoiceidDAO() {
        con = new DBConnector().getCon();
    }

    public InvoiceidDTO create(InvoiceidDTO in) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLCREATE);
            ps.setInt(1, in.getUserid());
            ps.setString(2, in.getDatetime());
            ps.setFloat(3, in.getTotal());
            int i = ps.executeUpdate();
            return in;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<InvoiceidDTO> readAll() {
        List<InvoiceidDTO> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    InvoiceidDTO in = new InvoiceidDTO();
                    in.setId(rs.getInt(1));
                    in.setUserid(rs.getInt(2));
                    in.setDatetime(rs.getString(3));
                    in.setTotal(rs.getInt(4));
                    list.add(in);
                }
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public InvoiceidDTO update(InvoiceidDTO in) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLUPDATE);
            ps.setInt(1, in.getUserid());
            ps.setString(2, in.getDatetime());
            ps.setFloat(3, in.getTotal());
            ps.setInt(4, in.getId());
            int i = ps.executeUpdate();
            if (i != 0) {
                return in;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean delete(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLDELETE);
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
