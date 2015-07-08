/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author wilton
 */
public abstract class GenericDAO 
{
    protected Transaction currentTransaction;
    protected Session currentSession;
    
    private static SessionFactory getSessionFactory()
    {
        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        SessionFactory sessionfactory = config.buildSessionFactory(builder.build());
        return sessionfactory;
        
    }
    
   
    
}
