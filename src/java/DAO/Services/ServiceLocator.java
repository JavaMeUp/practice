/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author wilson.li
 */
@Stateless
public class ServiceLocator implements IServiceLocator
{
    @EJB
    private  IServiceCache cache;
    
    @Override
    public IService getService(ServiceEnumContext ServiceName) 
    {
        try
        {
            IService service = cache.getService(ServiceName);

            if(service != null)
            {
                return service;
            }
            cache.addService(ServiceName.getServiceName());
            return ServiceName.getServiceName();
        }
        catch(NullPointerException n)
        {
            System.out.println("There was an error in getting the Service "+n.getMessage());
        }
        catch(Exception e)
        {
            System.out.print("There was an issue getting the service "+ ServiceName +" with the error " + e.getMessage());
        }
        
        return null;
                
    }

    
}
