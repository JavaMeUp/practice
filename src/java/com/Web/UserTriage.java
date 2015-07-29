/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web;

import DAO.Services.IServiceLocator;
import DAO.Services.ServiceEnumContext;
import static DAO.Services.ServiceEnumContext.UsersService;
import DAO.Services.UsersService;
import DAO.Services.VisitorsService;
import Hibernate.Users;
import Hibernate.Visitors;
import com.Web.State.Cookies;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author wilson.li
 */
@Stateless
public class UserTriage 
{
    private Date date;
    private UsersService userservice;
    @EJB
    private IServiceLocator serviceLocator;
    private Users loginUser;
    
    public UserTriage()
    {
        this.date = new Date();
    }
    
    @PostConstruct
    public void init()
    {
        userservice = (UsersService) serviceLocator.getService(ServiceEnumContext.UsersService);
        
    }
    
    public boolean isValidUser(String userName, String SessionId)
    {
        loginUser = userservice.getUserBySessionId(SessionId);
        return loginUser != null  ? true :false;
    }
    
    public void setValidUserCookie(String userName, String sessionId)
    {
        Cookies cookie = new Cookies();
        cookie.SetCookie(userName,sessionId,-1);
    }
    
    public void updateValidUser(String SessionID)
    {
        loginUser.setLastLogin(date);
        loginUser.setSessionID(SessionID);
        userservice.update(loginUser);
    }
    
    public void insertInvalidUser(String ipAddress,String userName, String password)
    {
        
        VisitorsService vService = (VisitorsService) serviceLocator.getService(ServiceEnumContext.VisitorsService);
        Visitors v = new Visitors(ipAddress,userName,password);
        v.setLastRequested(date);
        vService.persist(v);
    }
    
    
}
