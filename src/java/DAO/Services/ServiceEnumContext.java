/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Services;

/**
 *
 * @author wilson.li
 */
public enum ServiceEnumContext 
{
    ClassesService(1),
    StudentService(2),
    TeacherService(3),
    UsersService(4),
    VisitorsService(5),
    StudentClassesService(6),
    TeacherClassesService(7);
    
    
    private String ServiceName;
   
    
    private ServiceEnumContext(int indicator)
    {
        switch (indicator)
        {
            case 1:
                this.ServiceName = "ClassesService";
                break;
            case 2:
                this.ServiceName = "StudentService";
                break;                
            case 3:
                this.ServiceName = "TeacherService";
                break;                
            case 4:
                this.ServiceName = "UsersService";
                break;                
            case 5:
                this.ServiceName = "VisitorsService";
                break;       
            case 6:
                this.ServiceName = "StudentClassesService";
                break;
            case 7:
                this.ServiceName = "TeacherClassesService";
            default:
                
                
        }
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }
    
    
}
