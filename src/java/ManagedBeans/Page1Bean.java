/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Hibernate.Users;
import com.Web.CookieUserChecker;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author wilson.li
 */
@ManagedBean(name="Page1Bean",eager=true)
@RequestScoped
public class Page1Bean implements Serializable {

    private Users use;

    @ManagedProperty(value="#{CookieUserChecker}")
    private  CookieUserChecker userCheck;

    /**
     * Creates a new instance of Page1Bean
     */
    public Page1Bean() 
    {
        
    }
    @PostConstruct
    public void init()
    {
        use  = userCheck.getUserFromUserCookieBank();
    }
    
    public Users getUse() {
        return use;
    }

    public void setUse(Users use) {
        this.use = use;
    }
    
   public CookieUserChecker getUserCheck() {
        return userCheck;
    }

    public void setUserCheck(CookieUserChecker userCheck) {
        this.userCheck = userCheck;
    }
    
    public String LogOut()
    {
        return "Home.xhtml";
    }
}
