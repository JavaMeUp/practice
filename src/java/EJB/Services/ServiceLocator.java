/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

/**
 *
 * @author wilson.li
 */
public class ServiceLocator 
{
    private static final ServiceCache cache;
    
    static
    {
        cache = new ServiceCache();
    }
    
    public static IGenericService getService(String ServiceName)
    {
        IGenericService service = cache.getService(ServiceName);
        
        if(service != null)
        {
            return service;
        }
        
        ServiceContext context = new ServiceContext();
        IGenericService service1 = (IGenericService) context.lookUp(ServiceName);
        cache.addService(service1);
        return service1;
        
        
    }
    
}
