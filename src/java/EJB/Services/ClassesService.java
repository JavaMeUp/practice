/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

import EJB.ClassesDAO;
import Hibernate.Classes;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author wilson.li
 */
@Stateless
public class ClassesService implements IGenericService <Classes,String,ClassesDAO>
{
    private static ClassesDAO classesDAO;
    
    protected ClassesService()
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
    public void update (Classes entity)
    {
        classesDAO.openCurrentSession();
        classesDAO.update(entity);
        classesDAO.closeCurrentTransaction();
    }
    
    public Classes findByID(String id)
    {
        classesDAO.getCurrentSession();
        Classes singleClass = classesDAO.findById(id);
        classesDAO.closeCurrentSession();
        return singleClass;
    }
    
    public void deleteAll()
    {
        classesDAO.openCurrentSession();
        classesDAO.deleteAll();
        classesDAO.closeCurrentTransaction();
    }
    
    public void deleteByID(String ID)
    {
        classesDAO.openCurrentTransaction();
        Classes singleClass = classesDAO.findById(ID);
        classesDAO.delete(singleClass);
        classesDAO.closeCurrentTransaction();
    }
    
    public List<Classes> listAll()
    {
        classesDAO.openCurrentTransaction();
        List<Classes> listClasses = classesDAO.findAll();
        classesDAO.closeCurrentTransaction();
        return listClasses;
    }
    
    public ClassesDAO getClassesDAO()
    {
        
        return classesDAO;
    }
    
    
}
