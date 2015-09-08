/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web;

import DAO.Services.ClassesService;
import DAO.Services.IServiceLocator;
import DAO.Services.ServiceEnumContext;
import DAO.Services.TeacherClassesService;
import Hibernate.Classes;
import Hibernate.Teacher;
import Hibernate.Teacherclasses;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author wilson.li
 */
@ManagedBean(name="WebTeacherClassService",eager=true)
@SessionScoped
public class WebTeacherClassService implements Serializable{

   @EJB
   private IServiceLocator sLocator;
   private TeacherClassesService teacherClassService;
    /**
     * Creates a new instance of ClassService
     */
    public WebTeacherClassService() 
    {
        
    }
    
    @PostConstruct
    public void init()
    {
        this.teacherClassService = (TeacherClassesService) sLocator.getService(ServiceEnumContext.TeacherClassesService);
    }
    
    public List<Classes> getClassByTeacher(String id)
    {
        List<Classes> classes = new ArrayList <Classes>();
        teacherClassService.listAll();
        for(Teacherclasses singleTeacherClass:teacherClassService.listAll())
        {
            System.out.print(singleTeacherClass.getClasses().getTeacherId());
            String i = String.valueOf(singleTeacherClass.getClasses().getTeacherId());
            if(singleTeacherClass.getClasses().getTeacherId() == Integer.valueOf(id))
            {
                classes.add(singleTeacherClass.getClasses());
            }   
        }
        
        return classes;
    }
    
    public List<Teacher> getTeacherbyClassId(String classId)
    {
        List<Teacher> classes = new ArrayList <Teacher>();
        teacherClassService.listAll();
        for(Teacherclasses singleTeacherClass:teacherClassService.listAll())
        {
            if(singleTeacherClass.getClasses().getClassId() == Integer.valueOf(classId))
            {
                classes.add(singleTeacherClass.getTeacher());
            }
        }
        
        return classes;
    };
    
}
