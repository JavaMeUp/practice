/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web.State;

import java.util.HashMap;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wilton
 */
public class CookiesDAO 
{
    private Cookie cookie;
    private FacesContext context;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ExternalContext externalContext;
    private Map<String,Object> cookieData;
    
    public CookiesDAO()
    {
        context = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) context.getExternalContext().getRequest();
        response = (HttpServletResponse) context.getExternalContext().getResponse();
        externalContext = context.getExternalContext();
        cookieData = new HashMap <String,Object>();
        
    }
    
    public Cookie[]  getAllCookies()
    {
        return request.getCookies();
    }
    
    public Cookie getCookieByName(String cookieName) throws NullPointerException
    {
        Cookie [] cookies = request.getCookies();
        
        for(int i = 0; cookies!=null && cookies.length > i;i++)
        {
            if(cookies[i].getName().equals(cookieName))
            {
                return cookies[i];
            }
        }
        return null;
    }
    
    public Cookie getCookieBySessionId(String SessionId) throws NullPointerException
    {
        Cookie[] cookies = request.getCookies();
        for(int i = 0 ; i< cookies.length;i++)
        {
            if(cookies[i].getValue().equals(SessionId))
            {
                return cookies[i];
            }
        }
        return null;
    }
    
    public void SetCookie(String name, String value, int expiry )
    {
        Cookie [] cookies = request.getCookies();
        for(int i = 0 ; i< cookies.length; i++)
        {
            if(cookies != null && cookies[i].getName().equals(name))
            {
                this.cookie = cookies[i];
                break;
            }
        }
        if(this.cookie != null)
        {
            this.cookie.setValue(value);
        }
        else
        {
            this.cookie = new Cookie(name,value);
            this.cookie.setPath(request.getContextPath());
        }
        
        this.cookie.setMaxAge(expiry);
        response.addCookie(cookie);
    }
    
    public void removeCookie(String name )
    {
        Cookie [] cookies = request.getCookies();
        for(int i = 0 ; i< cookies.length; i++)
        {
            if(cookies != null && cookies[i].getName().equals(name))
            {
                this.cookie = cookies[i];
                this.cookie.setMaxAge(0);
                break;
            }
        }

        this.cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
    }
    
}
