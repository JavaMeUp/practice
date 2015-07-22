/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Services;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author wilson.li
 */
@Local
public interface IServiceLocator 
{
 public IService getService(ServiceEnumContext ServiceName);
 
}
