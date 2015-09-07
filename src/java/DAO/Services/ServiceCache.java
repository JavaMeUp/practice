/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author wilson.li
 */
@Stateless
public class ServiceCache implements IServiceCache
{
  
    private List<IService> services;
    
    
    public ServiceCache()
    {
        services = new ArrayList<IService>();
    }
    
    @Override
    public IService getService(ServiceEnumContext serviceName) throws NullPointerException
    {
        for(IService service : services)
        {
            if( serviceName.getServiceName().equals(service.getServiceName()))
            {
                return service;
            }
        }
        return null;
    }
    
    @Override
    public void addService(ServiceEnumContext newService)
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
            
            //Here are the options to add the services to the cache should they not 
            //Exsist, New ones should be placed here
            if(newService.getServiceName().equals("ClassesService"))
            {
                services.add(new ClassesService());
            }
            
            if(newService.getServiceName().equals("StudentService"))
            {
                services.add(new StudentService());
            }
                        
            if(newService.getServiceName().equals("TeacherService"))
            {
                services.add(new TeacherService());
            }            
            
            if(newService.getServiceName().equals("UsersService"))
            {
                services.add(new UsersService());
            }            
            
            if(newService.getServiceName().equals("VisitorsService"))
            {
                services.add(new VisitorsService());
            }            
            if(newService.getServiceName().equals("StudentClassesService"))
            {
                services.add( new StudentClassesService());
            }
            if(newService.getServiceName().equals("TeacherClassesService"))
            {
                services.add( new TeacherClassesService());
            }
        }
        
    }
    
    
    
}

