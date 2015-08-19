/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web;


import DAO.Services.ClassesService;
import DAO.Services.IServiceLocator;
import DAO.Services.ServiceEnumContext;
import DAO.Services.StudentClassesService;
import Hibernate.Classes;
import Hibernate.Studentclasses;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author wilson.li
 */
@ManagedBean(name="StudentService",eager=true)
@SessionScoped
public class WebStudentService implements Serializable{

   @EJB
   private IServiceLocator sLocator;
   private ClassesService classesService;
   private StudentClassesService enrollService;
    
    @PostConstruct
    public void init()
    {
        this.classesService = (ClassesService) sLocator.getService(ServiceEnumContext.ClassesService);
        this.enrollService = (StudentClassesService) sLocator.getService(ServiceEnumContext.StudentEnrolledClassesService);
    }
    
    public List<Classes> getClassesByStudent(String id)
    {
        //Need to get a list of the Studentenrolledclasses and then see what classeIds are present for the student and then query again to get the classes and return it.
         List<Classes> studentClass = this.enrollService.findClassesByStudentID();
        return studentClass;
        
    }
    
}
