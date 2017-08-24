/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.server;

import bus.BankAction;
import bus.BankIn;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thien
 */
public class RunServer {

    public static void main(String[] args) {
        try {
            BankIn p = new BankAction();
            LocateRegistry.createRegistry(1990);
            Naming.rebind("rmi://localhost:1990/BankDTO", p);
            System.out.println("Server start.....");
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(RunServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
