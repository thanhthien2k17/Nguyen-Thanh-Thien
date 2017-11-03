/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.FunctionsDAO;
import dto.Functions;
import java.util.List;

/**
 *
 * @author phong
 */
public class FunctionsAction {

    FunctionsDAO dao;

    public FunctionsAction() {
        dao = new FunctionsDAO();
    }

    public Functions create(Functions f) {
        return dao.create(f);
    }

    public List<Functions> readAll() {
        return dao.readAll();
    }

    public Functions readById(int id) {
        return dao.readById(id);
    }

    public List<Functions> readByName(String name) {
        return dao.readByName(name);
    }

    public Functions readByNameFunction(String name) {
        return dao.readByNameFunction(name);
    }

    public Functions update(Functions f) {
        return dao.update(f);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }
}
