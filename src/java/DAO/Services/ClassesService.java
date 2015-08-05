/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Services;

import DAO.ClassesDAO;
import Hibernate.Classes;
import java.util.List;

/**
 *
 * @author wilson.li
 */
public class ClassesService implements IService <Classes,String,ClassesDAO>
{
    private static ClassesDAO classesDAO;
    private final String ServiceName="ClassesService";
    
    public ClassesService()
    {
        classesDAO = new ClassesDAO();
    }
    
    @Override
    public void persist(Classes entity)
    {
        classesDAO.openCurrentSession();
        classesDAO.persist(entity);
        classesDAO.closeCurrentTransaction();
    }
    
    /**
     *
     * @param entity
     */
    @Override
    public void update (Classes entity)
    {
        classesDAO.openCurrentSession();
        classesDAO.update(entity);
        classesDAO.closeCurrentTransaction();
    }
    
    @Override
    public Classes findByID(String id)
    {
        classesDAO.getCurrentSession();
        Classes singleClass = classesDAO.findById(id);
        classesDAO.closeCurrentSession();
        return singleClass;
    }
    
    @Override
    public void deleteAll()
    {
        classesDAO.openCurrentSession();
        classesDAO.deleteAll();
        classesDAO.closeCurrentTransaction();
    }
    
    @Override
    public void deleteByID(String ID)
    {
        classesDAO.openCurrentTransaction();
        Classes singleClass = classesDAO.findById(ID);
        classesDAO.delete(singleClass);
        classesDAO.closeCurrentTransaction();
    }
    
    @Override
    public List<Classes> listAll()
    {
        classesDAO.openCurrentTransaction();
        List<Classes> listClasses = classesDAO.findAll();
        classesDAO.closeCurrentTransaction();
        return listClasses;
    }
    
    @Override
    public ClassesDAO getClassesDAO()
    {
        
        return classesDAO;
    }

    @Override
    public String getServiceName() {
        return this.ServiceName;
    }
    
    
}
