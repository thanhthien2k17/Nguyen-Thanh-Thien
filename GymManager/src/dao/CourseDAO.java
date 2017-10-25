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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CourseDAO {

    Connection con = null;
    final private String SQLCREATE = "INSERT INTO COURSE VALUE (?,?,?,?,?)";
    final private String SQLREADALL = " SELECT * FROM COURSE ";
    final private String SQLUPDATE = "UPDATE COURSE SET NAME = ? , TIME = ?,PRICE = ?, DESCRIPTION =?";
    final private String SQLDELETE = "DELETE FROM COURSE WHERE ID = ?";

    public CourseDAO() {
        con = new DBConnector().getCon();
    }

    public CourseDTO create(CourseDTO c) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLCREATE);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getTime());
            ps.setInt(4, c.getPrice());
            ps.setString(5, c.getDescription());
            int i = ps.executeUpdate();
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<CourseDTO> readAll() {
        List<CourseDTO> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    CourseDTO c = new CourseDTO();
                    c.setId(rs.getInt(1));
                    c.setName(rs.getString(2));
                    c.setTime(rs.getString(3));
                    c.setPrice(rs.getInt(4));
                    c.setDescription(rs.getString(5));
                    list.add(c);
                }
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public CourseDTO update(CourseDTO c) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLUPDATE);
            ps.setString(1, c.getName());
            ps.setString(2, c.getTime());
            ps.setInt(3, c.getPrice());
            ps.setString(4, c.getDescription());
            ps.setInt(5, c.getId());
            int i = ps.executeUpdate();
            if (i != 0) {
                return c;
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
