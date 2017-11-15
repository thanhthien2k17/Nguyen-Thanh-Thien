/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ScheduleDAO;
import dto.ScheduleDTO;
import java.util.List;

/**
 *
 * @author thien
 */
public class ScheduleAction {
    ScheduleDAO dao = null;

    public ScheduleAction() {
        dao = new ScheduleDAO();
    }
    
     public ScheduleDTO create(ScheduleDTO c) {
        return dao.create(c);
    }

    public List<ScheduleDTO> readAll() {
            return dao.readAll();
    }

    public ScheduleDTO update(ScheduleDTO c) {
        return dao.update(c);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }
}
