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

public class TeacherService implements IService <Teacher,String,TeacherDAO>
{
    private static TeacherDAO TeacherDAO;
    
    protected TeacherService()
    {
        TeacherDAO = new TeacherDAO();
    }
    
    @Override
    public void persist(Teacher entity)
    {
        TeacherDAO.openCurrentSession();
        TeacherDAO.persist(entity);
        TeacherDAO.closeCurrentTransaction();
    }
    
    @Override
    public void update (Teacher entity)
    {
        TeacherDAO.openCurrentSession();
        TeacherDAO.update(entity);
        TeacherDAO.closeCurrentTransaction();
    }
    
    @Override
    public Teacher findByID(String id)
    {
        TeacherDAO.getCurrentSession();
        Teacher Teacher = TeacherDAO.findById(id);
        TeacherDAO.closeCurrentSession();
        return Teacher;
    }
    
    @Override
    public void deleteAll()
    {
        TeacherDAO.openCurrentSession();
        TeacherDAO.deleteAll();
        TeacherDAO.closeCurrentTransaction();
    }
    
    @Override
    public void deleteByID(String ID)
    {
        TeacherDAO.openCurrentTransaction();
        Teacher singleClass = TeacherDAO.findById(ID);
        TeacherDAO.delete(singleClass);
        TeacherDAO.closeCurrentTransaction();
    }
    
    @Override
    public List<Teacher> listAll()
    {
        TeacherDAO.openCurrentTransaction();
        List<Teacher> listTeachers = TeacherDAO.findAll();
        TeacherDAO.closeCurrentTransaction();
        return listTeachers;
    }
    
    @Override
    public TeacherDAO getClassesDAO()
    {
        
        return TeacherDAO;
    }
    
    
}