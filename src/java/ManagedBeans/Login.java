/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;



import DAO.Services.IServiceLocator;
import static DAO.Services.ServiceEnumContext.StudentService;
import DAO.Services.StudentService;
import Hibernate.Student;
import Hibernate.Users;
import com.Web.WebCookieService;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author wilson.li
 */
@ManagedBean(name="Login",eager=true)
@SessionScoped
public class Login  implements Serializable {

    @EJB
    private IServiceLocator serviceLocator;
    
    @ManagedProperty(value="#{WebUserLoggedIn}")
    private LoggedInUser webUserLogedIn;
    @ManagedProperty(value="#{WebCookieService}")
    private WebCookieService webCookieService;
    
    private String ipAddress;
    private String userName;
    private String password;
    private StudentService studentService;
    private List<Student> studentList;
    private final String SessionID;
    private final Random SessionIDGenerator;
    private boolean isValidUser;


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
        studentList = studentService.listAll();
    }
    

    public LoggedInUser getWebUserLogedIn() {
        return webUserLogedIn;
    }

    public void setWebUserLogedIn(LoggedInUser webUserLogedIn) {
        this.webUserLogedIn = webUserLogedIn;
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
    
    public WebCookieService getWebCookieService() {
        return webCookieService;
    }

    public void setWebCookieService(WebCookieService webCookieService) {
        this.webCookieService = webCookieService;
    }
    
    public boolean isIsValidUser() {
        return isValidUser;
    }

    public void setIsValidUser(boolean isValidUser) {
        this.isValidUser = isValidUser;
    }
    
    public String Login()
    {       
        if(isValidUser = webCookieService.isValidUser(userName, password))
        {
            webCookieService.setValidUserCookie(userName, SessionID);
            webCookieService.updateValidUser(SessionID);
            webUserLogedIn.setUser(webCookieService.getUserFromUserCookieBank());
            
            
            return "LoggedInPage.xhtml?faces-redirect=true";                
        }
        else
        {
            //Should this be in web cookie service or in webUserService?
            webCookieService.insertInvalidUser(ipAddress, userName, password);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("LoginForm", new FacesMessage("UserName or Password not Valid"));                
        }
        return "Home.xhtml";

    }
    

    

}
