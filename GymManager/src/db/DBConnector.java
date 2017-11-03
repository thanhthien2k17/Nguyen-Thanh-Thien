/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phong
 */
public class DBConnector {

    Connection con = null;

    public DBConnector() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GymManager","sa","123456");
            System.out.println("Connection success !!!!");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

//    public DBConnector() {
//        FileReader fr = null;
//        BufferedReader br = null;
//        String database = "";
//        String password = "";
//        String userName = "";
//        try {
//            fr = new FileReader(System.getProperty("user.dir") + "/connectDB.txt");
//            br = new BufferedReader(fr);
//            database = br.readLine();
//            password = br.readLine();
//            userName = br.readLine();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                br.close();
//                fr.close();
//            } catch (IOException ex) {
//                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        try {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            con = DriverManager.getConnection(database, password, userName);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public Connection getCon() {
        return con;
    }
    

}
