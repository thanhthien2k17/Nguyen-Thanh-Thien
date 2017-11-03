/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.UsersDAO;
import dto.Users;
import java.util.List;

/**
 *
 * @author phong
 */
public class UsersAction {

    UsersDAO dao;

    public UsersAction() {
        dao = new UsersDAO();
    }

    public Users create(Users u) {
        return dao.create(u);
    }

    public List<Users> readAll() {
        return dao.readAll();
    }

    public Users readByName(String name) {
        return dao.readByName(name);
    }

    public Users readById(int id) {
        return dao.readById(id);
    }

    public Users update(Users u) {
        return dao.update(u);
    }

    public Users updatePassword(Users u) {
        return dao.updatePassword(u);
    }

    public boolean delete(String name) {
        return dao.delete(name);
    }
}
