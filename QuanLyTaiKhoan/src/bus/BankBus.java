/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import account.Account;

/**
 *
 * @author thien
 */
public interface BankBus {

    void display(Account a);

    void create();

    void withdraw();

    void deposit();
}
