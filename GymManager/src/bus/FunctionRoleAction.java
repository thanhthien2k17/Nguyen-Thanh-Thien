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
public class FunctionRoleAction {

    FunctionRolesDAO dao;

    public FunctionRoleAction() {
        dao = new FunctionRolesDAO();
    }

    public FunctionRoles create(FunctionRoles f) {
        return dao.create(f);
    }

    public List<FunctionRoles> readAll() {
        return dao.readAll();
    }

    public FunctionRoles readByRole(int id) {
        return dao.readByRole(id);
    }

    public List<FunctionRoles> readByFunction(int id) {
        return dao.readByFunction(id);
    }

    public boolean delete(int role, int function) {
        return dao.delete(role, function);
    }
}
