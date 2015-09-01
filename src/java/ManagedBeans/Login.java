/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;



import DAO.Services.IServiceLocator;
import com.Web.WebCookieService;
import com.Web.WebUserService;
import java.io.Serializable;
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
    private WebUserLoggedIn webUserLoggedIn;
    
    @ManagedProperty(value="#{WebCookieService}")
    private WebCookieService webCookieService;
    
    @ManagedProperty(value="#{WebUserService}")
    private WebUserService webUserService;
    
    private String ipAddress;
    private String userName;
    private String password;
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

    }

    public IServiceLocator getServiceLocator() {
        return serviceLocator;
    }

    public void setServiceLocator(IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public WebUserLoggedIn getWebUserLoggedIn() {
        return webUserLoggedIn;
    }

    public void setWebUserLoggedIn(WebUserLoggedIn webUserLoggedIn) {
        this.webUserLoggedIn = webUserLoggedIn;
    }

    public WebCookieService getWebCookieService() {
        return webCookieService;
    }

    public void setWebCookieService(WebCookieService webCookieService) {
        this.webCookieService = webCookieService;
    }

    public WebUserService getWebUserService() {
        return webUserService;
    }

    public void setWebUserService(WebUserService webUserService) {
        this.webUserService = webUserService;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    

    
    public String Login()
    {       
        if(webUserService.isValidUser(userName, password))
        {
            webCookieService.setValidUserCookie(userName, SessionID);
            webUserService.updateValidUser(SessionID);
            
            webUserLoggedIn.setUser(webUserService.getUserByNameAndPassword(userName, password));
            
            
            return "LoggedInPage.xhtml?faces-redirect=true";                
        }
        else
        {
            //Should this be in web cookie service or in webUserService?
            webUserService.insertInvalidUser(ipAddress, userName, password);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("LoginForm", new FacesMessage("UserName or Password not Valid"));                
        }
        return "Home.xhtml";

    }
    

    

}
