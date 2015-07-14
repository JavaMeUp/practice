/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

import javax.ejb.Stateless;

/**
 *
 * @author wilson.li
 */
@Stateless
public class ServiceLocator 
{
    private static final ServiceCache cache;
    
    static
    {
        cache = new ServiceCache();
    }
    
    public static IService getService(String ServiceName)
    {
        IService service = cache.getService(ServiceName);
        
        if(service != null)
        {
            return service;
        }
        
        ServiceContext context = new ServiceContext();
        IService service1 = (IService) context.lookUp(ServiceName);
        cache.addService(service1);
        return service1;
        
        
    }
    
}
