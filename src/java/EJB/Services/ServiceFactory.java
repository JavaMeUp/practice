/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author wilton
 */
@Stateless 
public class ServiceFactory 
{
    private List<IService> genericServices;
    
    @EJB
    private ClassesService classesService;
    
    public ServiceFactory()
    {
        
    }
    
    public IService getService()
    {
        return this.classesService;
    }
    
}
