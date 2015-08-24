/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Hibernate.Users;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author wilton
 */
@Named(value = "userLogedIn")
@Dependent
public class UserLogedIn {

    private Users use;

    /**
     * Creates a new instance of UserLogedIn
     */
    public UserLogedIn() 
    {
        
    }

    

    public Users getUse() {
        return use;
    }

    public void setUse(Users use) {
        this.use = use;
    }    
}
