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
    private int role;
    private List<Integer> functions;

    public FunctionRoles() {
    }

    public FunctionRoles(int role, List<Integer> functions) {
        this.role = role;
        this.functions = functions;
    }

    @Override
    public String toString() {
        return "FunctionRoles{" + "role=" + role + ", functions=" + functions + '}';
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
        if (this.role != other.role) {
            return false;
        }
        return true;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public List<Integer> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Integer> functions) {
        this.functions = functions;
    }

    @Override
    public int compareTo(FunctionRoles o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
