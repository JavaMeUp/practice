/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Services;

import DAO.StudentDAO;
import DAO.TeacherDAO;
import DAO.UsersDAO;
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
        UsersDAO.openCurrentTransaction();
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
    
    public Users getUser (String username , String password) throws NullPointerException
    {
        
        List<Users> users =  this.listAll();
        
        for(Users user : users)
        {
            if(user.getUserName().equals(username) && user.getUserPassword().equals(password))
            {
                return user;
            }
        }
        return null;        
    }
    
    public Users getUserBySessionId(String sessionId) throws NullPointerException
    {
        for(Users user : this.listAll())
        {
            if(user.getSessionID() != null && user.getSessionID().equals(sessionId))
            {
                return user;
            }
        }
        return null;
    }
    
    public Users getUserBySessionIdAndUserName(String sessionId,String UserName) throws NullPointerException
    {
        for(Users user : this.listAll())
        {
            if(user.getSessionID() != null && user.getSessionID().equals(sessionId)&user.getUserName().equals(UserName))
            {
                return user;
            }
        }
        return null;
    }    
        
}