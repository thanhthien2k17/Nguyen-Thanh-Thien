/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.InvoiceidDAO;
import dto.InvoiceidDTO;
import java.util.List;

/**
 *
 * @author thien
 */
public class InvoiceidAction {

    InvoiceidDAO dao = null;

    public InvoiceidAction() {
        dao=new InvoiceidDAO();
    }

    public int create(InvoiceidDTO c) {
        return dao.create(c);
    }

    public List<InvoiceidDTO> readAll() {
        return dao.readAll();
    }

    public InvoiceidDTO update(InvoiceidDTO s) {
        return dao.update(s);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }
    
    public List<InvoiceidDTO> readByDate(java.util.Date dateFrom, java.util.Date dateTo) {
        return dao.readByDate(dateFrom, dateTo);
    }
     public List<InvoiceidDTO> readByUsersId(int id) {
         return dao.readByUsersId(id);
     }

}
