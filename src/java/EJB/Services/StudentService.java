/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

import EJB.StudentDAO;
import Hibernate.Student;
import java.util.List;

/**
 *
 * @author wilson.li
 */
public class StudentService 
{
    private static StudentDAO StudentDAO;
    
    public StudentService()
    {
        StudentDAO = new StudentDAO();
    }
    
    public void persist(Student entity)
    {
        StudentDAO.openCurrentSession();
        StudentDAO.persist(entity);
        StudentDAO.closeCurrentTransaction();
    }
    
    public void update (Student entity)
    {
        StudentDAO.openCurrentSession();
        StudentDAO.update(entity);
        StudentDAO.closeCurrentTransaction();
    }
    
    public Student findByID(String id)
    {
        StudentDAO.getCurrentSession();
        Student student = StudentDAO.findById(id);
        StudentDAO.closeCurrentSession();
        return student;
    }
    
    public void deleteAll()
    {
        StudentDAO.openCurrentSession();
        StudentDAO.deleteAll();
        StudentDAO.closeCurrentTransaction();
    }
    
    public void deleteByID(String ID)
    {
        StudentDAO.openCurrentTransaction();
        Student singleClass = StudentDAO.findById(ID);
        StudentDAO.delete(singleClass);
        StudentDAO.closeCurrentTransaction();
    }
    
    public List<Student> listAll()
    {
        StudentDAO.openCurrentTransaction();
        List<Student> listStudents = StudentDAO.findAll();
        StudentDAO.closeCurrentTransaction();
        return listStudents;
    }
    
    public StudentDAO getClassesDAO()
    {
        
        return StudentDAO;
    }
    
    
}