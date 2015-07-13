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

public class VisitorsService implements IService <Visitors,String,VisitorsDAO>
{
    private static VisitorsDAO VisitorsDAO;
    
    protected VisitorsService()
    {
        VisitorsDAO = new VisitorsDAO();
    }
    
    @Override
    public void persist(Visitors entity)
    {
        VisitorsDAO.openCurrentSession();
        VisitorsDAO.persist(entity);
        VisitorsDAO.closeCurrentTransaction();
    }
    
    @Override
    public void update (Visitors entity)
    {
        VisitorsDAO.openCurrentSession();
        VisitorsDAO.update(entity);
        VisitorsDAO.closeCurrentTransaction();
    }
    
    @Override
    public Visitors findByID(String id)
    {
        VisitorsDAO.getCurrentSession();
        Visitors Visitors = VisitorsDAO.findById(id);
        VisitorsDAO.closeCurrentSession();
        return Visitors;
    }
    
    @Override
    public void deleteAll()
    {
        VisitorsDAO.openCurrentSession();
        VisitorsDAO.deleteAll();
        VisitorsDAO.closeCurrentTransaction();
    }
    
    @Override
    public void deleteByID(String ID)
    {
        VisitorsDAO.openCurrentTransaction();
        Visitors singleClass = VisitorsDAO.findById(ID);
        VisitorsDAO.delete(singleClass);
        VisitorsDAO.closeCurrentTransaction();
    }
    
    @Override
    public List<Visitors> listAll()
    {
        VisitorsDAO.openCurrentTransaction();
        List<Visitors> listVisitorss = VisitorsDAO.findAll();
        VisitorsDAO.closeCurrentTransaction();
        return listVisitorss;
    }
    
    @Override
    public VisitorsDAO getClassesDAO()
    {
        
        return VisitorsDAO;
    }
    
    
}