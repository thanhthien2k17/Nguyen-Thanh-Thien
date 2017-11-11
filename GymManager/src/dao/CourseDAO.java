/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import dto.CourseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CourseDAO {

    Connection con = null;
    final private String SQLCREATE = "INSERT INTO COURSE VALUES (?,?,?,?)";
    final private String SQLREADALL = " SELECT * FROM COURSE ";
    final private String SQLREADBYID = "SELECT * FROM COURSE WHERE ID=?";
    final private String SQLUPDATE = "UPDATE COURSE SET NAME = ? , TIME = ?,PRICE = ?, DESCRIPTION =? WHERE ID = ?";
    final private String SQLDELETE = "DELETE FROM COURSE WHERE ID = ?";
    SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat mdy = new SimpleDateFormat("MM/dd/yyyy");

    public CourseDAO() {
        con = new DBConnector().getCon();
    }

    public CourseDTO create(CourseDTO c) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLCREATE);
            ps.setString(1, c.getName());
            ps.setDate(2, new java.sql.Date(mdy.parse(mdy.format(c.getTime())).getDate()));
//            ps.setDate(3, new java.sql.Date(c.getDate().getTime());
            ps.setFloat(3, c.getPrice());
            ps.setString(4, c.getDescription());
            int i = ps.executeUpdate();
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<CourseDTO> readAll(){
        List<CourseDTO> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    CourseDTO c = new CourseDTO();
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    Date time = dmy.parse(dmy.format(rs.getDate(3)));
                    float price = rs.getFloat(4);
                    String description = rs.getString(5);
                    list.add(new CourseDTO(id, name, time, price, description));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public CourseDTO update(CourseDTO c) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLUPDATE);
            ps.setString(1, c.getName());
            ps.setDate(2, new java.sql.Date(mdy.parse(mdy.format(c.getTime())).getDate()));;
            ps.setFloat(3, c.getPrice());
            ps.setString(4, c.getDescription());
            ps.setInt(5, c.getId());
            int i = ps.executeUpdate();

                return c;


        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public CourseDTO readById(int id){
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if(rs != null){
                if(rs.next()){
                    String name = rs.getString(2);
                    Date time = dmy.parse(dmy.format(rs.getDate(3)));
                    double price = rs.getDouble(4);
                    String description = rs.getString(5);
                    return (new CourseDTO(id, name, time, (float) price, description));
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
