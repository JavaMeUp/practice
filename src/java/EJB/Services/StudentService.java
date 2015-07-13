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
public class StudentService implements IService <Student,String,StudentDAO>
{
    private static StudentDAO StudentDAO;
    
    protected StudentService()
    {
        StudentDAO = new StudentDAO();
    }
    
    @Override
    public void persist(Student entity)
    {
        StudentDAO.openCurrentSession();
        StudentDAO.persist(entity);
        StudentDAO.closeCurrentTransaction();
    }
    
    @Override
    public void update (Student entity)
    {
        StudentDAO.openCurrentSession();
        StudentDAO.update(entity);
        StudentDAO.closeCurrentTransaction();
    }
    
    @Override
    public Student findByID(String id)
    {
        StudentDAO.getCurrentSession();
        Student student = StudentDAO.findById(id);
        StudentDAO.closeCurrentSession();
        return student;
    }
    
    @Override
    public void deleteAll()
    {
        StudentDAO.openCurrentSession();
        StudentDAO.deleteAll();
        StudentDAO.closeCurrentTransaction();
    }
    
    @Override
    public void deleteByID(String ID)
    {
        StudentDAO.openCurrentTransaction();
        Student singleClass = StudentDAO.findById(ID);
        StudentDAO.delete(singleClass);
        StudentDAO.closeCurrentTransaction();
    }
    
    @Override
    public List<Student> listAll()
    {
        StudentDAO.openCurrentTransaction();
        List<Student> listStudents = StudentDAO.findAll();
        StudentDAO.closeCurrentTransaction();
        return listStudents;
    }
    
    @Override
    public StudentDAO getClassesDAO()
    {
        
        return StudentDAO;
    }
    
    
}