package dao;

import db.DBConnector;
import dto.FunctionRoles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phong
 */
public class FunctionRolesDAO {

    Connection con;
    final String SQLCREATE = "INSERT INTO FUNTIONROLE VALUES(?,?)";
    final String SQLREADALL = "SELECT * FROM FUNTIONROLE";
    final String SQLREADBYROLE = "SELECT * FROM FUNTIONROLE WHERE ROLEID=?";
    final String SQLREADBYFUNCTION = "SELECT * FROM FUNTIONROLE WHERE FUNCTIONID=?";
    final String SQLDELTE = "DELETE FROM FUNTIONROLE WHERE ROLEID=? AND FUNCTIONID=?";

    public FunctionRolesDAO() {
        con = new DBConnector().getCon();
    }

    public FunctionRoles create(FunctionRoles f) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            for (Integer i : f.getFunctions()) {
                pr.setInt(1, f.getRole());
                pr.setInt(2, i);
                pr.executeUpdate();
            }
            return f;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionRolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<FunctionRoles> readAll() {
        List<FunctionRoles> l = new ArrayList<>();
        Map<Integer, List<Integer>> functions = new HashMap<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    int role = rs.getInt(2);
                    if (functions.containsKey(role)) {
                        functions.get(role).add(rs.getInt(3));
                    } else {
                        List<Integer> li = new ArrayList<>();
                        functions.put(role, li);
                        functions.get(role).add(rs.getInt(3));
                    }
                }
            }
            for (Map.Entry<Integer, List<Integer>> f : functions.entrySet()) {
                l.add(new FunctionRoles(f.getKey(), f.getValue()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionRolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public FunctionRoles readByRole(int id) {
        List<Integer> l = new ArrayList<>();
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYROLE);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    l.add(rs.getInt(3));
                }
                return new FunctionRoles(id, l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionRolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<FunctionRoles> readByFunction(int id) {
        List<FunctionRoles> l = new ArrayList<>();
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADBYFUNCTION);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int role = rs.getInt(2);
                    List<Integer> li = new ArrayList<>();
                    li.add(id);
                    l.add(new FunctionRoles(role, li));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionRolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public boolean delete(int role, int function) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLDELTE);
            pr.setInt(1, role);
            pr.setInt(2, function);
            int i = pr.executeUpdate();
            if (i != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionRolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
