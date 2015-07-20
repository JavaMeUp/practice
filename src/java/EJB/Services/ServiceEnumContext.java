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
public enum ServiceEnumContext 
{
    ClassesService(1),
    StudentService(2),
    TeacherService(3),
    UsersService(4),
    VisitorsService(5);
    
    
    private IService ServiceName;
    
    private ServiceEnumContext(int indicator)
    {
        switch (indicator)
        {
            case 1:
                this.ServiceName = new ClassesService();
                break;
            case 2:
                this.ServiceName = new StudentService();
                break;                
            case 3:
                this.ServiceName = new TeacherService();
                break;                
            case 4:
                this.ServiceName = new UsersService();
                break;                
            case 5:
                this.ServiceName = new VisitorsService();
                break;                
            default:
                
                
        }
    }

    public IService getServiceName() {
        return ServiceName;
    }

    public void setServiceName(IService ServiceName) {
        this.ServiceName = ServiceName;
    }
    

    
}
