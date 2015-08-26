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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Cookie;

/**
 *
 * @author wilson.li
 */
@ManagedBean(name="WebCookieService",eager=true)
@SessionScoped
public class WebCookieService  implements Serializable
{
    private Date date;
    private UsersService userservice;
    @EJB
    private IServiceLocator serviceLocator;
    private Users loginUser;
    private UsersService uService;
    
    
    public WebCookieService()
    {
        this.date = new Date();
        
    }
    
    @PostConstruct
    public void init()
    {
        this.userservice = (UsersService) serviceLocator.getService(ServiceEnumContext.UsersService);
        this.uService = (UsersService) serviceLocator.getService(ServiceEnumContext.UsersService);
    }
        
    public void setValidUserCookie(String userName, String sessionId)
    {
        CookiesDAO singleookie = new CookiesDAO();
        singleookie.SetCookie(userName,sessionId,-1);
    }
    
    public Users getUserFromUserCookieBank() throws NullPointerException
    {
        CookiesDAO cookie = new CookiesDAO();
        Cookie[] cookies = cookie.getAllCookies();
        Users user = null;
        for (Cookie cookie1 : cookies)
        {
            user = uService.getUserBySessionIdAndUserName(cookie1.getValue(),cookie1.getName());
            if(user != null)
            {
                break;
            }
        }
        return user;
    }
    
    public void removeUserFromUserCookieBank() throws NullPointerException
    {
        CookiesDAO cookie = new CookiesDAO();
        Cookie[] cookies = cookie.getAllCookies();
        Users user = null;
        for (Cookie cookie1 : cookies)
        {
            user = uService.getUserBySessionIdAndUserName(cookie1.getValue(),cookie1.getName());
            if(user != null)
            {
                cookie1.setMaxAge(0);
                cookie1.setValue("");
                cookie1.setPath("");
                cookie.removeCookie(user.getUserName());
                
            }
        }
        
        
    }
    
    
}
