/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

import EJB.UsersDAO;
import Hibernate.Users;
import java.util.List;

/**
 *
 * @author wilson.li
 */
public class UsersService implements IGenericService <Users,String,UsersDAO>
{
    private static UsersDAO UsersDAO;
    
    protected UsersService()
    {
        UsersDAO = new UsersDAO();
    }
    
    public void persist(Users entity)
    {
        UsersDAO.openCurrentSession();
        UsersDAO.persist(entity);
        UsersDAO.closeCurrentTransaction();
    }
    
    public void update (Users entity)
    {
        UsersDAO.openCurrentSession();
        UsersDAO.update(entity);
        UsersDAO.closeCurrentTransaction();
    }
    
    public Users findByID(String id)
    {
        UsersDAO.getCurrentSession();
        Users Users = UsersDAO.findById(id);
        UsersDAO.closeCurrentSession();
        return Users;
    }
    
    public void deleteAll()
    {
        UsersDAO.openCurrentSession();
        UsersDAO.deleteAll();
        UsersDAO.closeCurrentTransaction();
    }
    
    public void deleteByID(String ID)
    {
        UsersDAO.openCurrentTransaction();
        Users singleClass = UsersDAO.findById(ID);
        UsersDAO.delete(singleClass);
        UsersDAO.closeCurrentTransaction();
    }
    
    public List<Users> listAll()
    {
        UsersDAO.openCurrentTransaction();
        List<Users> listUserss = UsersDAO.findAll();
        UsersDAO.closeCurrentTransaction();
        return listUserss;
    }
    
    public UsersDAO getClassesDAO()
    {
        
        return UsersDAO;
    }
    
    
}