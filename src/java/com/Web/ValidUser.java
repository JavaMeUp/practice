/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web;

import DAO.Services.IServiceLocator;
import static DAO.Services.ServiceEnumContext.UsersService;
import DAO.Services.UsersService;
import Hibernate.Users;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author wilson.li
 */
public class ValidUser 
{
    private final UsersService userservice;
    @EJB
    private IServiceLocator serviceLocator;
    
    public ValidUser()
    {
        this.userservice = (UsersService) serviceLocator.getService(UsersService);
    }
    
    public boolean isValid(String userName, String SessionId)
    {
        for(Users u : this.userservice.listAll() )
        {
            if(u.getSessionID().equals(SessionId) && u.getUserName().equals(userName))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    
    
}
