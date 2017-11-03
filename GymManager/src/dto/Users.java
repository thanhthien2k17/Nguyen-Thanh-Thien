/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author phong
 */
public class Users implements Serializable, Comparable<Users>{
    private int id;
    private String username;
    private String password;
    private int roleId;
    private int isActive;
    private String address;
    private String phone;
    private String email;
    private String fullName;

    public Users() {
    }

    public Users(int id, String username, String password, int roleId, int isActive, String address, String phone, String email, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.isActive = isActive;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
    }
    public Users(String username, String password, int roleId, int isActive, String address, String phone, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.isActive = isActive;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    

    
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Users other = (Users) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", username=" + username + ", password=" + password + ", roleId=" + roleId + ", isActive=" + isActive + ", address=" + address + ", phone=" + phone + ", email=" + email + ", fullName=" + fullName + '}';
    }

    

    @Override
    public int compareTo(Users o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
