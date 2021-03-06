/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.RolesDAO;
import dto.Roles;
import java.util.List;

/**
 *
 * @author phong
 */
public class RoleAction {

    RolesDAO dao;

    public RoleAction() {
        dao = new RolesDAO();
    }

    public Roles create(Roles r) {
        return dao.create(r);
    }

    public List<Roles> readAll() {
        return dao.readAll();
    }

    public Roles readByName(String name) {
        return dao.readByName(name);
    }

    public Roles readById(int id) {
        return dao.readById(id);
    }

    public Roles update(Roles r) {
        return dao.update(r);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }
}
