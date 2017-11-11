/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.CourseDAO;
import dto.CourseDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aptech
 */
public class CourseAction {

    CourseDAO dao;

    public CourseAction() {
        dao = new CourseDAO();
    }

    public CourseDTO create(CourseDTO c) {
        return dao.create(c);
    }

    public List<CourseDTO> readAll() {
            return dao.readAll();
    }

    public CourseDTO update(CourseDTO c) {
        return dao.update(c);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

//    public CourseDTO readById(int id) {
//        return dao.readById(id);
//    }

}
