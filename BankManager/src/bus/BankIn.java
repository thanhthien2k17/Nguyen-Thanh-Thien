/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dto.BankDTO;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author thien
 */
public interface BankIn extends java.rmi.Remote {

    public BankDTO create(BankDTO e) throws RemoteException;

    public List<BankDTO> readAll() throws RemoteException;

    public BankDTO update(BankDTO e) throws RemoteException;

    public boolean delete(String number) throws RemoteException;

    public boolean checkNumber(String s) throws RemoteException;

    public BankDTO search(List<BankDTO> list, String number) throws RemoteException;
}
