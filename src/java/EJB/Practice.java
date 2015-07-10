/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;


import Hibernate.HibernateUtil;
import Hibernate.Teacher;
import java.util.List;
import javax.ejb.Stateful;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author wilson.li
 */
@Stateful
public class Practice implements IPractice
{
    Session sess = null;
    

    @Override
    public void setItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getMessage()
    {
        return "I AM FROM THE EJB";
    }
    

    @Override
    public String getTeacher()
    {
        Teacher Rteacher = null;
        this.sess =  HibernateUtil.getSessionFactory().openSession();
        try
        {
            Transaction tx = this.sess.beginTransaction();
            Query q = this.sess.createQuery("from Teacher");
            List<Teacher> teachers = q.list();
            Rteacher = teachers.get(0);
            
            tx.commit();
        }
        catch(Exception e )
        {
            System.out.println("There was an error "+ e.getMessage());
        }
        
       return Rteacher.getFirstName();
    }
    
    
    
    
    
    
    
}
