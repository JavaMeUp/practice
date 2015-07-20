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
public class UsersService implements IService <Users,String,UsersDAO>
{
    private static UsersDAO UsersDAO;
    private final String ServiceName = "UsersService";
    
    public UsersService()
    {
        UsersDAO = new UsersDAO();
    }
    
    @Override
    public void persist(Users entity)
    {
        UsersDAO.openCurrentSession();
        UsersDAO.persist(entity);
        UsersDAO.closeCurrentTransaction();
    }
    
    @Override
    public void update (Users entity)
    {
        UsersDAO.openCurrentSession();
        UsersDAO.update(entity);
        UsersDAO.closeCurrentTransaction();
    }
    
    @Override
    public Users findByID(String id)
    {
        UsersDAO.getCurrentSession();
        Users Users = UsersDAO.findById(id);
        UsersDAO.closeCurrentSession();
        return Users;
    }
    
    @Override
    public void deleteAll()
    {
        UsersDAO.openCurrentSession();
        UsersDAO.deleteAll();
        UsersDAO.closeCurrentTransaction();
    }
    
    @Override
    public void deleteByID(String ID)
    {
        UsersDAO.openCurrentTransaction();
        Users singleClass = UsersDAO.findById(ID);
        UsersDAO.delete(singleClass);
        UsersDAO.closeCurrentTransaction();
    }
    
    @Override
    public List<Users> listAll()
    {
        UsersDAO.openCurrentTransaction();
        List<Users> listUserss = UsersDAO.findAll();
        UsersDAO.closeCurrentTransaction();
        return listUserss;
    }
    
    @Override
    public UsersDAO getClassesDAO()
    {
        
        return UsersDAO;
    }
    
    @Override
    public String getServiceName() {
        return this.ServiceName;
    }
    
}