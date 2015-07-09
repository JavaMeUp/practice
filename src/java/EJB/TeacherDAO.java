/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Hibernate.Teacher;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author wilton
 */
public class TeacherDAO extends GenericDAO  implements IDAO <Teacher ,String>
{
    private Session session;
    private Transaction transaction;
    
    
    @Override
    public void persist(Teacher entity) 
    {
        try
        {
            this.transaction = super.openCurrentTransaction();
            this.session = super.getCurrentSession();
            this.session.persist(entity);
            super.closeCurrentTransaction();
        }
        catch(Exception e )
        {
            System.out.format("Thre was an error in persisting the Teacher Object %s", e.getMessage());
        }
    }

    @Override
    public void update(Teacher entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Teacher findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Teacher entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Teacher> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
