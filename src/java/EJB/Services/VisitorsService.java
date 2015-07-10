/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

import EJB.VisitorsDAO;
import Hibernate.Visitors;
import java.util.List;

/**
 *
 * @author wilson.li
 */

public class VisitorsService 
{
    private static VisitorsDAO VisitorsDAO;
    
    public VisitorsService()
    {
        VisitorsDAO = new VisitorsDAO();
    }
    
    public void persist(Visitors entity)
    {
        VisitorsDAO.openCurrentSession();
        VisitorsDAO.persist(entity);
        VisitorsDAO.closeCurrentTransaction();
    }
    
    public void update (Visitors entity)
    {
        VisitorsDAO.openCurrentSession();
        VisitorsDAO.update(entity);
        VisitorsDAO.closeCurrentTransaction();
    }
    
    public Visitors findByID(String id)
    {
        VisitorsDAO.getCurrentSession();
        Visitors Visitors = VisitorsDAO.findById(id);
        VisitorsDAO.closeCurrentSession();
        return Visitors;
    }
    
    public void deleteAll()
    {
        VisitorsDAO.openCurrentSession();
        VisitorsDAO.deleteAll();
        VisitorsDAO.closeCurrentTransaction();
    }
    
    public void deleteByID(String ID)
    {
        VisitorsDAO.openCurrentTransaction();
        Visitors singleClass = VisitorsDAO.findById(ID);
        VisitorsDAO.delete(singleClass);
        VisitorsDAO.closeCurrentTransaction();
    }
    
    public List<Visitors> listAll()
    {
        VisitorsDAO.openCurrentTransaction();
        List<Visitors> listVisitorss = VisitorsDAO.findAll();
        VisitorsDAO.closeCurrentTransaction();
        return listVisitorss;
    }
    
    public VisitorsDAO getClassesDAO()
    {
        
        return VisitorsDAO;
    }
    
    
}