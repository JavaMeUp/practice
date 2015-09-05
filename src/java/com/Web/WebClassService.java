/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web;

import DAO.Services.ClassesService;
import DAO.Services.IServiceLocator;
import DAO.Services.ServiceEnumContext;
import Hibernate.Classes;
import Hibernate.Teacher;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author wilson.li
 */
@ManagedBean(name="WebClassService",eager=true)
@SessionScoped
public class WebClassService implements Serializable{

   @EJB
   private IServiceLocator sLocator;
   private ClassesService classService;
    /**
     * Creates a new instance of ClassService
     */
    public WebClassService() 
    {
        
    }
    
    @PostConstruct
    public void init()
    {
        this.classService = (ClassesService) sLocator.getService(ServiceEnumContext.ClassesService);
    }
    
    
}
