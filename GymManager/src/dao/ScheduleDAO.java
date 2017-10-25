/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import dto.ScheduleDTO;
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
 * @author Aptech
 */
public class ScheduleDAO {

    Connection con = null;
    final private String SQLCREATE = "INSERT INTO SCHEDULE VALUE(?,?,?,?,?,?,?) ";
    final private String SQLREADALL = "SELECT * FROM SCHEDULE ";
    final private String SQLUPDATE = "UPDATE SCHEDULE SET CUSTOMERID = ?, COURSEID = ?, USERID = ? , TIMESTART = ? , TIMEEND = ?,CAREREGIME = ? WHERE ID = ?";
    final private String SQLDELETE = "DELETE FROM SCHEDULE WHERE ID = ?";

    public ScheduleDAO() {
        con = new DBConnector().getCon();
    }

    public ScheduleDTO create(ScheduleDTO s) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLCREATE);
            ps.setInt(1, s.getId());
            ps.setInt(2, s.getCustomerid());
            ps.setInt(3, s.getCourseid());
            ps.setInt(4, s.getUserid());
            ps.setString(5, s.getTimeStart());
            ps.setString(6, s.getTimeEnd());
            ps.setString(7, s.getCareRegime());

            int i = ps.executeUpdate();
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<ScheduleDTO> readAll() {
         java.util.List<ScheduleDTO> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    ScheduleDTO s = new ScheduleDTO();
                    s.setId(rs.getInt(1));
                    s.setCustomerid(rs.getInt(2));
                    s.setCourseid(rs.getInt(3));
                    s.setUserid(rs.getInt(4));

                    list.add(s);
                }
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ScheduleDTO update() {

        return null;
    }

    public boolean delete(int id) {
        return false;
    }

}
