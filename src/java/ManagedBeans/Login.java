/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;



import DAO.Services.IServiceLocator;
import DAO.Services.ServiceEnumContext;
import static DAO.Services.ServiceEnumContext.StudentService;
import DAO.Services.StudentService;
import DAO.Services.UsersService;
import DAO.Services.VisitorsService;
import Hibernate.Student;
import Hibernate.Users;
import Hibernate.Visitors;
import com.Web.State.Cookies;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
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
    private String userName;
    private String password;
    private String message;
    private StudentService studentService;
    private List<Student> studentList;
    private UsersService service;
    private final String SessionID;
    private final Random SessionIDGenerator;


    
    
    /**
     * Creates a new instance of JSFPractice
     */
    public Login() 
    {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        this.ipAddress =   request.getRemoteAddr();
        this.SessionIDGenerator = new Random();
        this.SessionID = String.valueOf(SessionIDGenerator.nextDouble());
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
    
    public void setIP(String ip)
    {
        this.ipAddress = ip;
    }
    
    public String getMessage() {
        return message;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String Login()
    {       
            Date date = new Date();
            Cookies cookie = new Cookies();
            service = (UsersService) serviceLocator.getService(ServiceEnumContext.UsersService);
            Users loginUser = service.getUser(this.userName, this.password);
            Cookie c = cookie.getCookie(this.userName);
            
            if(loginUser != null )
            {
                cookie.SetCookie(this.userName,this.SessionID,-1);
                UsersService uService = (UsersService) serviceLocator.getService(ServiceEnumContext.UsersService);
                loginUser.setLastLogin(date);
                loginUser.setSessionID(SessionID);
                uService.update(loginUser);
                return "page1.xhtml";                
            }
            else
            {
                VisitorsService vService = (VisitorsService) serviceLocator.getService(ServiceEnumContext.VisitorsService);
                Visitors v = new Visitors(this.ipAddress,this.userName,this.password);
                v.setLastRequested(date);
                vService.persist(v);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("LoginForm", new FacesMessage("UserName or Password not Valid"));                
            }
            return "Home.xhtml";
    }
    

}
