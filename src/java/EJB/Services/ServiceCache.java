/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author wilson.li
 */
@Stateless
public class ServiceCache 
{
    private List<IGenericService> services;
    
    public ServiceCache()
    {
        services = new ArrayList<IGenericService>();
    }
    
    public IGenericService getService(String serviceName)
    {
        
        for(IGenericService service : services)
        {
            //WL TODO; Need to place in service where name of the 
            // Service is known 
            if(  service.getClass().isInstance(StudentService.class))
            {
                return (IGenericService) new StudentService();
            }
            
            
        }
        
        return null;
    }
    
    public void addService(IGenericService newService)
    {
        boolean exists =false;
        
        for(IGenericService service : services)
        {
            //WL:TODO
            if(1<2)
            {
                exists=true;
            }
        }
        if(!exists)
        {
            services.add(newService);
        }
        
    }
    
    
    
}
