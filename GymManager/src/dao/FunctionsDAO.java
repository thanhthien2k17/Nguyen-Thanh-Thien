package dao;

import db.DBConnector;
import dto.Functions;
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
 * @author phong
 */
public class FunctionsDAO {

    Connection con;
    final String SQLCREATE = "INSERT INTO FUNTIONS VALUES(?,?)";
    final String SQLREADALL = "SELECT * FROM FUNTIONS";
    final String SQLREADBYID = "SELECT * FROM FUNTIONS WHERE ID=?";
    final String SQLREADBYNAMEFUNCTION = "SELECT * FROM FUNTIONS WHERE NAME=?";
    final String SQLUPDATE = "UPDATE FUNTIONS SET NAME=?, DESCRIPTION=? WHERE ID=?";
    final String SQLDELETE = "DELETE FROM FUNTIONS WHERE ID=?";

    public FunctionsDAO() {
        con = new DBConnector().getCon();
    }

    public Functions create(Functions f) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setString(1, f.getName());
            pr.setString(2, f.getDes());
            if (pr.executeUpdate() != 0) {
                return f;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Functions> readAll() {
        List<Functions> l = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String des = rs.getString(3);
                    l.add(new Functions(id, name, des));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public Functions readById(int id) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    String name = rs.getString(2);
                    String des = rs.getString(3);
                    return new Functions(id, name, des);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Functions readByNameFunction(String name) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYNAMEFUNCTION);
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    String des = rs.getString(3);
                    return new Functions(id, name, des);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Functions update(Functions f) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLUPDATE);
            pr.setString(1, f.getName());
            pr.setString(2, f.getDes());
            pr.setInt(3, f.getId());
            if (pr.executeUpdate() != 0) {
                return f;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean delete(int id) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLDELETE);
            pr.setInt(1, id);
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
