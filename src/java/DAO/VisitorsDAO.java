/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.Visitors;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author wilson.li
 */
public class VisitorsDAO implements IDAO <Visitors,String>
{
    private Transaction currentTransaction;
    private Session currentSession;
    
    private static SessionFactory getSessionFactory()
    {
        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        SessionFactory sessionfactory = config.buildSessionFactory(builder.build());
        return sessionfactory;   
    }
    
    public Session openCurrentSession()
    {
        this.currentSession = getSessionFactory().openSession();
        return this.currentSession;
    }
    
    public Transaction openCurrentTransaction()
    {
       this.currentSession = getSessionFactory().openSession();
       this.currentTransaction =this.currentSession.beginTransaction();
       return this.currentTransaction;
    }
    
   
    public void closeCurrentSession()
    {
        this.currentSession.close();
    }
    
    public void closeCurrentTransaction()
    {
        this.currentSession.close();
        this.currentTransaction.commit();
    }
    
    public Session getCurrentSession()
    {
        return this.currentSession;
    }
    
    public Transaction getCurrentTransaction()
    {
        return this.currentTransaction;
    }
    
    public void setCurrentSession(Session session)
    {
        this.currentSession = session;
    }
    
    public void setCurrentTransaction(Transaction transaction)
    {
        this.currentTransaction = transaction;
    }
    
    @Override
    public void persist(Visitors entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Visitors entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Visitors findById(String id) {
        Visitors visitors = (Visitors) getCurrentSession().get(Visitors.class, id);
        return visitors;
    }

    @Override
    public void delete(Visitors entity) {
        getCurrentSession().delete (entity);
    }

    @Override
    public List<Visitors> findAll() 
    {
        List<Visitors> visitors;
        visitors = (List<Visitors>) getCurrentSession().createQuery("From Visitors").list();
        return visitors;        
    }

    @Override
    public void deleteAll() 
    {
        List<Visitors> allVisitors = findAll();
        
        for(Visitors singleVisitors :allVisitors)
        {
            getCurrentSession().delete(singleVisitors);
        }    
    }
}