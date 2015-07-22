/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.Student;
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

public class StudentDAO implements IDAO <Student,String>
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
    public void persist(Student entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Student entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Student findById(String id) {
        Student student = (Student) getCurrentSession().get(Student.class, id);
        return student;
    }

    @Override
    public void delete(Student entity) {
        getCurrentSession().delete (entity);
    }

    @Override
    public List<Student> findAll() 
    {
        List<Student> students;
        students = (List<Student>) getCurrentSession().createQuery("From Student").list();
        return students;        
    }

    @Override
    public void deleteAll() 
    {
        List<Student> allClass = findAll();
        
        for(Student singleClass :allClass)
        {
            getCurrentSession().delete(singleClass);
        }    
    }
}
