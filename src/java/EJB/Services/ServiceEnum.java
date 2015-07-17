/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

/**
 *
 * @author wilson.li
 */
public enum ServiceEnum 
{
    ClassesService,
    StudentService,
    TeacherService,
    UsersService,
    VisitorsService;
    
    ServiceEnum()
    {
        
    }
    
    public String iterate(String test)
    {
        
        return "hi";
    }
    
}
