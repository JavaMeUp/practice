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
    
    
    
    private List<IService> services;
    
    public ServiceCache()
    {
        services = new ArrayList<IService>();
    }
    
    public IService getService(String serviceName)
    {
        
        for(IService service : services)
        {
            //WL TODO; Need to place in service where name of the 
            // Service is known 
            switch(serviceName)
            {
                case "":
                    
                        
                    
                
            }
            
            if( service.getServiceName().equalsIgnoreCase(serviceName))
            {
                return (IService) new StudentService();
            }
            
            
        }
        
        return null;
    }
    
    public void addService(IService newService)
    {
        boolean exists =false;
        
        for(IService service : services)
        {
            
            if(service.getServiceName().equalsIgnoreCase(newService.getServiceName()))
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
