/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Services;

import DAO.StudentClassesDAO;
import Hibernate.Classes;
import Hibernate.Student;
import Hibernate.Studentclasses;
import java.util.List;



/**
 *
 * @author wilson.li
 */


public class StudentClassesService implements IService <Studentclasses,String,StudentClassesDAO>
{
    private static StudentClassesDAO StudentClassesServiceDAO;
    private final String ServiceName ="StudentClassesService";
    
    public StudentClassesService()
    {
        StudentClassesServiceDAO = new StudentClassesDAO();
    }
    
    @Override
    public void persist(Studentclasses entity)
    {
        StudentClassesServiceDAO.openCurrentSession();
        StudentClassesServiceDAO.persist(entity);
        StudentClassesServiceDAO.closeCurrentTransaction();
    }
    
    @Override
    public void update (Studentclasses entity)
    {
        StudentClassesServiceDAO.openCurrentSession();
        StudentClassesServiceDAO.update(entity);
        StudentClassesServiceDAO.closeCurrentTransaction();
    }
    
    @Override
    public Studentclasses findByID(String id)
    {
        StudentClassesServiceDAO.getCurrentSession();
        Studentclasses EnrolledClasses = StudentClassesServiceDAO.findById(id);
        StudentClassesServiceDAO.closeCurrentSession();
        return EnrolledClasses;
    }
    
    @Override
    public void deleteAll()
    {
        StudentClassesServiceDAO.openCurrentSession();
        StudentClassesServiceDAO.deleteAll();
        StudentClassesServiceDAO.closeCurrentTransaction();
    }
    
    @Override
    public void deleteByID(String ID)
    {
        StudentClassesServiceDAO.openCurrentTransaction();
        Studentclasses singleClass = StudentClassesServiceDAO.findById(ID);
        StudentClassesServiceDAO.delete(singleClass);
        StudentClassesServiceDAO.closeCurrentTransaction();
    }
    
    @Override
    public List<Studentclasses> listAll()
    {
        StudentClassesServiceDAO.openCurrentTransaction();
        List<Studentclasses> listEnrolledClass = StudentClassesServiceDAO.findAll();
        StudentClassesServiceDAO.closeCurrentTransaction();
        return listEnrolledClass;
    }

    @Override
    public String getServiceName() {
        return this.ServiceName;
    }

    @Override
    public StudentClassesDAO getClassesDAO() {
         return StudentClassesServiceDAO;
    }
    
    
     
    
}