/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web;

import DAO.Services.IServiceLocator;
import DAO.Services.ServiceEnumContext;
import DAO.Services.UsersService;
import DAO.Services.VisitorsService;
import Hibernate.Users;
import Hibernate.Visitors;
import com.Web.State.CookiesDAO;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author wilson.li
 */
@ManagedBean(name="WebUserService",eager=true)
@ApplicationScoped
public class WebUserService  implements Serializable
{
    private Date date;
    private UsersService userservice;
    @EJB
    private IServiceLocator serviceLocator;
    private Users loginUser;
    
    public WebUserService()
    {
        this.date = new Date();
        
    }
    
    @PostConstruct
    public void init()
    {
        userservice = (UsersService) serviceLocator.getService(ServiceEnumContext.UsersService);
        
    }
    
    public boolean isValidUser(String userName, String passeord)
    {
        loginUser = userservice.getUser(userName, passeord);
        return loginUser != null;
    }
    
    public void setValidUserCookie(String userName, String sessionId)
    {
        CookiesDAO cookie = new CookiesDAO();
        cookie.SetCookie(userName,sessionId,-1);
    }
    
    public void updateValidUser(String SessionID)
    {
        loginUser.setLastLogin(date);
        loginUser.setSessionId(SessionID);
        userservice.update(loginUser);
    }
    
    public void insertInvalidUser(String ipAddress,String userName, String password)
    {
        
        VisitorsService vService = (VisitorsService) serviceLocator.getService(ServiceEnumContext.VisitorsService);
        Visitors visitor = new Visitors(ipAddress,userName,password);
        visitor.setLastRequested(date);
        vService.persist(visitor);
    }
    
    public Users getUserByNameAndPassword(String userName,String password) throws NullPointerException
    {
        return userservice.getUser(userName, password);
    }
        
    
}
