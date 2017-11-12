/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.FunctionRolesDAO;
import dto.FunctionRoles;
import java.util.List;

/**
 *
 * @author phong
 */
public class FunctionRolesAction {

    FunctionRolesDAO dao;

    public FunctionRolesAction() {
        dao = new FunctionRolesDAO();
    }

    public FunctionRoles create(FunctionRoles f) {
        return dao.create(f);
    }

    public List<FunctionRoles> readAll() {
        return dao.readAll();
    }

    public FunctionRoles readById(int id) {
        return dao.readById(id);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

}
