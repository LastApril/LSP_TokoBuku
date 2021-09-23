/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
/**
 * Interface berisi metode login
 * @author Arjun
 */
public interface Login {
    boolean login(String username, String password);
}
