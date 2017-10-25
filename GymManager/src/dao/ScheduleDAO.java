/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import java.sql.Connection;

/**
 *
 * @author Aptech
 */
public class ScheduleDAO {
    Connection con = null;
    final private String SQLCREATE = "INSERT INTO SCHEDULE VALUE(?,?,?,?,?,?,?) ";
    final private String SQLREADALL= "SELECT * FROM SCHEDULE ";
    final private String SQLUPDATE = "UPDATE SCHEDULE SET ADDRESS = ?,PHONE = ?,NAME = ? WHERE ID = ?";
    final private String SQLDELETE = "DELETE FROM SCHEDULE WHERE ID = ?";

    public ScheduleDAO() {
        con = new DBConnector().getCon();
    }
    
    
}
