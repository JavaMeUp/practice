/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

import EJB.TeacherDAO;
import Hibernate.Teacher;
import java.util.List;

/**
 *
 * @author wilson.li
 */

public class TeacherService 
{
    private static TeacherDAO TeacherDAO;
    
    public TeacherService()
    {
        TeacherDAO = new TeacherDAO();
    }
    
    public void persist(Teacher entity)
    {
        TeacherDAO.openCurrentSession();
        TeacherDAO.persist(entity);
        TeacherDAO.closeCurrentTransaction();
    }
    
    public void update (Teacher entity)
    {
        TeacherDAO.openCurrentSession();
        TeacherDAO.update(entity);
        TeacherDAO.closeCurrentTransaction();
    }
    
    public Teacher findByID(String id)
    {
        TeacherDAO.getCurrentSession();
        Teacher Teacher = TeacherDAO.findById(id);
        TeacherDAO.closeCurrentSession();
        return Teacher;
    }
    
    public void deleteAll()
    {
        TeacherDAO.openCurrentSession();
        TeacherDAO.deleteAll();
        TeacherDAO.closeCurrentTransaction();
    }
    
    public void deleteByID(String ID)
    {
        TeacherDAO.openCurrentTransaction();
        Teacher singleClass = TeacherDAO.findById(ID);
        TeacherDAO.delete(singleClass);
        TeacherDAO.closeCurrentTransaction();
    }
    
    public List<Teacher> listAll()
    {
        TeacherDAO.openCurrentTransaction();
        List<Teacher> listTeachers = TeacherDAO.findAll();
        TeacherDAO.closeCurrentTransaction();
        return listTeachers;
    }
    
    public TeacherDAO getClassesDAO()
    {
        
        return TeacherDAO;
    }
    
    
}