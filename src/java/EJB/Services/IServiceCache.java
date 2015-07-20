/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

import javax.ejb.Local;

/**
 *
 * @author wilson.li
 */
@Local
public interface IServiceCache {
    public IService getService(ServiceEnumContext serviceName);
    public void addService(IService newService);
    
}
