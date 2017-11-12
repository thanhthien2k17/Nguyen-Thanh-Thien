/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import dto.BillsDTO;
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
public class BillsDAO {
    Connection con = null;
    final private String SQLCREATE = "INSERT INTO BILLS VALUE(?,?,?)";
    final private String SQLREADALL= "SELECT * FROM BILLS ";
    final private String SQLUPDATE = "UPDATE BILLS SET INVOICEID = ? , COURSEID = ?, PRICE = ? WHERE ID = ? ";
    final private String SQLDELETE = "DELETE FROM BILLS WHERE ID = ?";

    public BillsDAO() {
         con = new DBConnector().getCon();
    }
    public BillsDTO create (BillsDTO b){
         try {
            PreparedStatement ps = con.prepareStatement(SQLCREATE);
            ps.setInt(1, b.getInvoiceid());
            ps.setInt(2, b.getCourseid());
            ps.setFloat(3, b.getPrice());
            int i = ps.executeUpdate();
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public java.util.List<BillsDTO> readAll(){
        java.util.List<BillsDTO> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                   BillsDTO b = new BillsDTO();
                    b.setId(rs.getInt(1));
                    b.setInvoiceid(rs.getInt(2));
                    b.setCourseid(rs.getInt(3));
                    b.setPrice(rs.getFloat(4));
                    list.add(b);
                }
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public BillsDTO update(BillsDTO b){
         try {
            PreparedStatement ps = con.prepareStatement(SQLUPDATE);
            ps.setInt(1, b.getInvoiceid());
            ps.setInt(2, b.getCourseid());
            ps.setFloat(3,b.getPrice());
            ps.setInt(4, b.getId());
            int i = ps.executeUpdate();
            if( i !=0 ){
                return b;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean delete(int id){
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
