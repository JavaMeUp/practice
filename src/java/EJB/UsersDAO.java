/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Hibernate.Users;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author wilson.li
 */
public class UsersDAO implements IDAO <Users,String>
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
    public void persist(Users entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Users entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Users findById(String id) {
        Users user = (Users) getCurrentSession().get(Users.class, id);
        return user;
    }

    @Override
    public void delete(Users entity) {
        getCurrentSession().delete (entity);
    }

    @Override
    public List<Users> findAll() 
    {
        List<Users> users;
        users = (List<Users>) getCurrentSession().createQuery("From Users").list();
        return users;        
    }

    @Override
    public void deleteAll() 
    {
        List<Users> allUsers = findAll();
        
        for(Users user :allUsers)
        {
            getCurrentSession().delete(user);
        }    
    }
}