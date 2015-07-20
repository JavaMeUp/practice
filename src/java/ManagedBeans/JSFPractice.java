/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;



import EJB.Services.IServiceLocator;
import EJB.Services.ServiceEnumContext;
import static EJB.Services.ServiceEnumContext.StudentService;
import EJB.Services.ServiceLocator;
import EJB.Services.StudentService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author wilson.li
 */
@ManagedBean(name="JSFPractice",eager=true)
@RequestScoped
public class JSFPractice {


    @EJB
    private IServiceLocator serviceLocator;
    
    private String ipAddress;
    private String  Teacher;
    private String message;


    
    
    /**
     * Creates a new instance of JSFPractice
     */
    public JSFPractice() 
    {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        this.ipAddress =   request.getRemoteAddr();
     
        serviceLocator.getService("Student");
        
    }
    
    public String getIP()
    {
        return this.ipAddress;
    }
    public String getMessage() {
        return message;
    }

    
}
