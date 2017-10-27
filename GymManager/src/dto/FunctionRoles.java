/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author phong
 */
public class FunctionRoles implements Serializable, Comparable<FunctionRoles>{
    private int id;
    private int roleId;
    private List<Integer> functionId;
    
    public FunctionRoles() {
    }

    public FunctionRoles(int id, int roleId, List<Integer> functionId) {
        this.id = id;
        this.roleId = roleId;
        this.functionId = functionId;
    }

    public FunctionRoles(int roleId, List<Integer> functionId) {
        this.roleId = roleId;
        this.functionId = functionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getFunctionId() {
        return functionId;
    }

    public void setFunctionId(List<Integer> functionId) {
        this.functionId = functionId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FunctionRoles other = (FunctionRoles) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FunctionRoles{" + "id=" + id + ", roleId=" + roleId + ", functionId=" + functionId + '}';
    }

    @Override
    public int compareTo(FunctionRoles o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
