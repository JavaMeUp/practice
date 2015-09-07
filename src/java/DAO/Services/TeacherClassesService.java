/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Services;

import DAO.TeacherClassesDAO;
import Hibernate.Teacherclasses;
import java.util.List;



/**
 *
 * @author wilson.li
 */


public class TeacherClassesService implements IService <Teacherclasses,String,TeacherClassesDAO>
{
    private static TeacherClassesDAO teacherClassesDAO;
    private final String ServiceName ="TeacherClassesService";
    
    public TeacherClassesService()
    {
        teacherClassesDAO = new TeacherClassesDAO();
    }
    
    @Override
    public void persist(Teacherclasses entity)
    {
        teacherClassesDAO.openCurrentSession();
        teacherClassesDAO.persist(entity);
        teacherClassesDAO.closeCurrentTransaction();
    }
    
    @Override
    public void update (Teacherclasses entity)
    {
        teacherClassesDAO.openCurrentSession();
        teacherClassesDAO.update(entity);
        teacherClassesDAO.closeCurrentTransaction();
    }
    
    @Override
    public Teacherclasses findByID(String id)
    {
        teacherClassesDAO.getCurrentSession();
        Teacherclasses singleTeacherClassesDAO = teacherClassesDAO.findById(id);
        teacherClassesDAO.closeCurrentSession();
        return singleTeacherClassesDAO;
    }
    
    @Override
    public void deleteAll()
    {
        teacherClassesDAO.openCurrentSession();
        teacherClassesDAO.deleteAll();
        teacherClassesDAO.closeCurrentTransaction();
    }
    
    @Override
    public void deleteByID(String ID)
    {
        teacherClassesDAO.openCurrentTransaction();
        Teacherclasses singleTeacherClasses = teacherClassesDAO.findById(ID);
        teacherClassesDAO.delete(singleTeacherClasses);
        teacherClassesDAO.closeCurrentTransaction();
    }
    
    @Override
    public List<Teacherclasses> listAll()
    {
        teacherClassesDAO.openCurrentTransaction();
        List<Teacherclasses> allTeacherClasses = teacherClassesDAO.findAll();
        teacherClassesDAO.closeCurrentTransaction();
        return allTeacherClasses;
    }

    @Override
    public String getServiceName() {
        return this.ServiceName;
    }

    @Override
    public TeacherClassesDAO getClassesDAO() {
         return teacherClassesDAO;
    }
    
    
}