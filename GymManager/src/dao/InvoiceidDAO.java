/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import dto.InvoiceidDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
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
    final private String SQLCREATE = "INSERT INTO INVOICES VALUES(?,?,?)";
    final private String SQLREADALL = "SELECT * FROM INVOICES ";
    final private String SQLUPDATE = "UPDATE INVOICES SET USERID = ?, DATE = ?, TOTAL = ? WHERE ID = ?";
    final private String SQLDELETE = "DELETE FROM INVOICES WHERE ID = ? ";
    final private String SQLKEY = "INSERT INTO INVOICES VALUES(?,?,?)";
    final String SQLREADBYDATE = "SELECT * FROM INVOICES WHERE DATE BETWEEN ? AND ?";
    final private String SQLREADBY_USERSID = "SELECT * FROM INVOICES WHERE USERID=?";
    SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat mdy = new SimpleDateFormat("MM/dd/yyyy");
    
    public InvoiceidDAO() {
        con = new DBConnector().getCon();
    }
    public List<InvoiceidDTO> readByUsersId(int id) {
        List<InvoiceidDTO> list = new ArrayList<>();
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBY_USERSID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    InvoiceidDTO in = new InvoiceidDTO();
                    in.setId(rs.getInt(1));
                    in.setUserid(rs.getInt(2));
                    try {
                        java.util.Date date = dmy.parse(dmy.format(rs.getDate(3)));
                        in.setDatetime(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(InvoiceidDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    in.setTotal(rs.getInt(4));
                    list.add(in);
                }
                return list;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int create(InvoiceidDTO in) {
        int generatedKey = 0;
        try {
            PreparedStatement ps = con.prepareStatement(SQLCREATE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, in.getUserid());
            try {
                //            ps.setDate(2, (Date) in.getDatetime());
                ps.setDate(2, new Date(mdy.parse(mdy.format(in.getDatetime())).getTime()));
            } catch (ParseException ex) {
                Logger.getLogger(InvoiceidDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ps.setFloat(3, in.getTotal());
            int i = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            if (i != 0) {
                return generatedKey;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
                    try {
                        java.util.Date date = dmy.parse(dmy.format(rs.getDate(3)));
                        in.setDatetime(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(InvoiceidDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
            try {
                ps.setDate(2, new Date(mdy.parse(mdy.format(in.getDatetime())).getTime()));
            } catch (ParseException ex) {
                Logger.getLogger(InvoiceidDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    public List<InvoiceidDTO> readByDate(java.util.Date dateFrom, java.util.Date dateTo) {
        List<InvoiceidDTO> l = new ArrayList<>();
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYDATE);
            java.util.Date df = mdy.parse(mdy.format(dateFrom));
            java.util.Date dt = mdy.parse(mdy.format(dateTo));
            pr.setDate(1, new Date(df.getTime()));
            pr.setDate(2, new Date(dt.getTime()));
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int userid = rs.getInt(2);
                    java.util.Date date = dmy.parse(dmy.format(rs.getDate(3)));
                    float price = rs.getFloat(4);
                    l.add(new InvoiceidDTO(id, userid, date, price));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceidDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(InvoiceidDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
}
