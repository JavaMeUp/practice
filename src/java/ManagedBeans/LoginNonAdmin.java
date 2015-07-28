/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author wilson.li
 */
@Named(value = "loginNonAdmin")
@Dependent
public class LoginNonAdmin {

    /**
     * Creates a new instance of LoginNonAdmin
     */
    public LoginNonAdmin() {
    }
    
}
