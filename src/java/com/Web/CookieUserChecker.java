/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web;

import DAO.Services.IServiceLocator;
import DAO.Services.ServiceEnumContext;
import DAO.Services.UsersService;
import Hibernate.Users;
import com.Web.State.CookiesDAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Cookie;

/**
 *
 * @author wilson.li
 */
@ManagedBean(name="CookieUserChecker",eager=true)
@SessionScoped
public class CookieUserChecker implements Serializable
{
    private CookiesDAO cookie;
    
    private UsersService uService;
    private String userName;
    
    @EJB
    private IServiceLocator sLocator;
    
    public CookieUserChecker()
    {
        cookie = new CookiesDAO();
        //Wl Need to move this out. Might need to create a separate service for the web tier
        //this.uService = (UsersService) sLocator.getService(ServiceEnumContext.UsersService);
    }
    
    @PostConstruct
    public void init()
    {
        this.uService = (UsersService) sLocator.getService(ServiceEnumContext.UsersService);
    }
    
    public Users getUserFromUserCookieBank() throws NullPointerException
    {
        Cookie[] cookies = cookie.getAllCookies();
        Users user = null;
        for (Cookie cookie1 : cookies)
        {
            user = uService.getUserBySessionIdAndUserName(cookie1.getValue(),cookie1.getName());
            if(user != null)
            {
                userName = user.getUserName();
                break;
            }
        }
        return user;
    }
    
    public void removeUserFromUserCookieBank() throws NullPointerException
    {
        cookie.removeCookie(this.userName);
    }
    
}