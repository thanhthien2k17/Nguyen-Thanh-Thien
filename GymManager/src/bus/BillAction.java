/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.BillsDAO;
import dto.BillsDTO;
import java.util.List;



/**
 *
 * @author thien
 */
public class BillAction {
    BillsDAO dao=null;

    public BillAction() {
        dao=new BillsDAO();
    }
     public BillsDTO create(BillsDTO c) {
        return dao.create(c);
    }

    public List<BillsDTO> readAll() {
            return dao.readAll();
    }

    public BillsDTO update(BillsDTO c) {
        return dao.update(c);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }
    
}
