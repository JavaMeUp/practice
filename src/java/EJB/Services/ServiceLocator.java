/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author wilson.li
 */
@Stateless
public class ServiceLocator 
{
    @EJB
    private static ServiceCache cache;
    
    public static IService getService(String ServiceName)
    {
        try
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
        catch(Exception e)
        {
            System.out.print("There was an issue getting the service "+ ServiceName +" with the error " + e.getMessage());
        }
        
        return null;
        
    }
    
}
