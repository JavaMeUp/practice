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
import Hibernate.Student;
import Hibernate.Studentclasses;
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
@ManagedBean(name="WebStudentClassesService",eager=true)
@SessionScoped
public class WebStudentClassesService implements Serializable{

   @EJB
   private IServiceLocator sLocator;
   private ClassesService classesService;
   private StudentClassesService studentClassesService;
    
    @PostConstruct
    public void init()
    {
        this.classesService = (ClassesService) sLocator.getService(ServiceEnumContext.ClassesService);
        this.studentClassesService = (StudentClassesService) sLocator.getService(ServiceEnumContext.StudentClassesService);
    }
    
    public List<Classes> getClassesByStudent(String id)
    {
        //Need to get a list of the Studentenrolledclasses and then see what classeIds are present for the student and then query again to get the classes and return it.
        List<Classes> studentClasses = new ArrayList<Classes>();
        
        for(Studentclasses singleClass : this.studentClassesService.listAll())
        {
            if(singleClass.getStudent().getStudentId() == Integer.parseInt(id))
            {
                studentClasses.add(singleClass.getClasses());
            }
        }
        
        return studentClasses;
    }
    
    public List<Student> getStudentByClassID(String id)
    {
        List<Student> students = new ArrayList<Student>();
        
        
        for(Studentclasses singleStudentClasses : studentClassesService.listAll())
        {
            if(singleStudentClasses.getClasses().getClassId() == Integer.parseInt(id))
            {
                students.add(singleStudentClasses.getStudent());
            }
        }
        
        return students;
        
        
    }
    
}
