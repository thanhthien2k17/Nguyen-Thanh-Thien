/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.BankDAO;
import dto.BankDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author thien
 */
public class BankAction extends UnicastRemoteObject implements BankIn {

    BankDAO dao = null;

    public BankAction() throws RemoteException {
        super();
        dao = new BankDAO();
    }

    @Override
    public BankDTO create(BankDTO e) throws RemoteException {
        return dao.create(e);
    }

    @Override
    public List<BankDTO> readAll() throws RemoteException {
        return dao.readAll();
    }

    @Override
    public BankDTO update(BankDTO e) throws RemoteException {
        return dao.update(e);
    }

    @Override
    public boolean delete(String number) throws RemoteException {
        return dao.delete(number);
    }

    @Override
    public boolean checkNumber(String s) throws RemoteException {

        int kt = 1;
        if (s.startsWith("0161") || s.startsWith("0162")) {
            char[] ch = s.toCharArray();
            if (ch.length != 11) {
                kt = 0;
            }
            for (char c : ch) {
                if (!Character.isDigit(c)) {
                    kt = 0;
                }
            }
        } else {
            kt = 0;
        }
        return kt != 0;

    }

    @Override
    public BankDTO search(List<BankDTO> list, String number) throws RemoteException {

        for (BankDTO e : list) {
            if (number.equals(e.getNumber())) {
                return e;
            }
        }
        return null;
    }

}
