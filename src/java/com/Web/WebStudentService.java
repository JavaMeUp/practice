/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web;


import DAO.Services.ClassesService;
import DAO.Services.IServiceLocator;
import DAO.Services.ServiceEnumContext;
import DAO.Services.StudentService;
import Hibernate.Classes;
import Hibernate.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;



/**
 *
 * @author wilson.li
 */
@ManagedBean(name="StudentService",eager=true)
@ApplicationScoped
public class WebStudentService implements Serializable{

   @EJB
   private IServiceLocator sLocator;
   private ClassesService classesService;
    /**
     * Creates a new instance of ClassService
     */
    public WebStudentService() 
    {
        
    }
    
    @PostConstruct
    public void init()
    {
        this.classesService = (ClassesService) sLocator.getService(ServiceEnumContext.ClassesService);
    }
    
    public List<Classes> getClassByStudent(String id)
    {
        List<Classes> classes = new ArrayList<Classes>();
        
        
        //Wl; Could add somthing to either get validation if the student is already there or make the list unique after processing. 
        for(Classes singleclass: classesService.listAll())
        {
            for(Student singleStudent : singleclass.getStudents())
            {
                if(String.valueOf(singleStudent.getStudentId()).equals(id) )
                {
                    classes.add(singleclass);
                }
            }
        }
        
        
        return classes;
        
    }
    
}
