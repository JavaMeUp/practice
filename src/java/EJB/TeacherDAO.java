/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Hibernate.Classes;
import Hibernate.Teacher;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author wilton
 */
public class TeacherDAO implements IDAO <Teacher ,String>
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
    public void persist(Teacher entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Teacher entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Teacher findById(String id) {
        Teacher teacher = (Teacher) getCurrentSession().get(Teacher.class, id);
        return teacher;
    }

    @Override
    public void delete(Teacher entity) {
        getCurrentSession().delete (entity);
    }

    @Override
    public List<Teacher> findAll() 
    {
        List<Teacher> teachers;
        teachers = (List<Teacher>) getCurrentSession().createQuery("From Teacher").list();
        return teachers;        
    }

    @Override
    public void deleteAll() 
    {
        List<Teacher> allTeachers = findAll();
        
        for(Teacher teacher :allTeachers)
        {
            getCurrentSession().delete(teacher);
        }    
    }
    
}
