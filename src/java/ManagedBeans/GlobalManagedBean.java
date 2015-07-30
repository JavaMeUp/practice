/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import com.Web.State.Cookies;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author wilton
 */
@ManagedBean(name="GlobalManagedBean",eager=true)
@ApplicationScoped
public class GlobalManagedBean 
{
    private Cookies cookies;
    
    public GlobalManagedBean()
    {
        this.cookies = new Cookies();
    }
    
    public void isValidContinuingUser()
    {
        
    }
    
    
}
