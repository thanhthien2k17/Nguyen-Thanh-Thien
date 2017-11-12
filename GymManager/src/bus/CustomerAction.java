/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.CustomerDAO;
import dto.CustomerDTO;
import java.util.List;

/**
 *
 * @author Aptech
 */
public class CustomerAction {

    CustomerDAO dao = null;

    public CustomerAction() {
        dao = new CustomerDAO();
    }

    public CustomerDTO create(CustomerDTO c) {
        return dao.create(c);
    }

    public List<CustomerDTO> readAll() {
        return dao.readAll();
    }

    public CustomerDTO update(CustomerDTO s) {
        return dao.update(s);
    }

    public boolean delete(int customerid) {
        return dao.delete(customerid);
    }
}