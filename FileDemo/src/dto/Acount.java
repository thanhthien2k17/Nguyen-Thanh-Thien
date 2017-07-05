/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author thien
 */
public class Acount implements Serializable,Comparable<Acount>{

    private String password, description;
    private String username;

    public Acount() {
    }

    public Acount(String username, String password, String description) {
        this.username = username;
        this.password = password;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.username + "," + this.password + "," + this.description;
    }

    @Override
    public int compareTo(Acount o) {
        int valueUser = this.username.compareTo(o.username);
        int valuePass = this.password.compareTo(o.password);
        if (valueUser == 0) {
            if (valuePass == 0) {
                return 0;
            } else {
                return valuePass;
            }
        } else {
            return valueUser;
        }
    }

}
