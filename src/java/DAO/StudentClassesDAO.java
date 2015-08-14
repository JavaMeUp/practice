/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.Classes;
import Hibernate.Studentclasses;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author wilson.li
 */

public class StudentClassesDAO implements IDAO <Studentclasses,String>
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
    public void persist(Studentclasses entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Studentclasses entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Studentclasses findById(String id) {
        Studentclasses singleStudentenrolledclasses = (Studentclasses) getCurrentSession().get(Studentclasses.class, id);
        return singleStudentenrolledclasses;
    }

    @Override
    public void delete(Studentclasses entity) {
        getCurrentSession().delete (entity);
    }

    @Override
    public List<Studentclasses> findAll() 
    {
        List<Studentclasses> AllStudentenrolledclasses;
        AllStudentenrolledclasses = (List<Studentclasses>) getCurrentSession().createQuery("From Studentclasses").list();
        return AllStudentenrolledclasses;        
    }

    @Override
    public void deleteAll() 
    {
        List<Studentclasses> allStudentenrolledclasses = findAll();
        
        for(Studentclasses singleStudentenrolledclasses :allStudentenrolledclasses)
        {
            getCurrentSession().delete(singleStudentenrolledclasses);
        }    
    }
    
    public List<Classes> findClassesByStudentID(int id) 
    {
        List<Classes> classes= getCurrentSession().createQuery("from Classes  c join c.studentclasseses s where s.id.studentId = :id").setInteger("id", id).list();        
        return classes;        
    }
    
    public List<Studentclasses> findStudentsbyClassID() 
    {
        List<Studentclasses> AllStudentenrolledclasses;
        AllStudentenrolledclasses = (List<Studentclasses>) getCurrentSession().createQuery("select s.student from Classes  c join c.studentclasseses s").list();
        return AllStudentenrolledclasses;        
    }
    
}