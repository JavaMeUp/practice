/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;



import DAO.Services.IServiceLocator;
import DAO.Services.ServiceEnumContext;
import static DAO.Services.ServiceEnumContext.StudentService;
import DAO.Services.ServiceLocator;
import DAO.Services.StudentService;
import Hibernate.Student;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author wilson.li
 */
@ManagedBean(name="Login",eager=true)
@RequestScoped
public class Login {


    @EJB
    private IServiceLocator serviceLocator;
    
    private String ipAddress;
    private String  teacher;
    private String message;
    private StudentService studentService;
    private List<Student> studentList;


    
    
    /**
     * Creates a new instance of JSFPractice
     */
    public Login() 
    {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        this.ipAddress =   request.getRemoteAddr();
     
        
        
    }
    
    @PostConstruct
    public void init()
    {
        studentService  = (StudentService) serviceLocator.getService(StudentService);
        message = studentService.listAll().get(2).getFirstName();
        studentList = studentService.listAll();
    }

    public List<Student> getStudentList() 
    {
        return studentList;
    }
        
    
    public String getIP()
    {
        return this.ipAddress;
    }
    public String getMessage() {
        return message;
    }

    
}
