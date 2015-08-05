/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web.Listeners;

import ManagedBeans.Login;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author wilson.li
 */
public class LogOutListener implements ActionListener
{

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException 
    {
            ExternalContext con = FacesContext.getCurrentInstance().getExternalContext();
            Map<String,Object> item = con.getSessionMap();
            Login log = (Login) con.getSessionMap().get("Login");
            
            
    }
    
}
