/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;


import EJB.Services.IService;
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

    private String Message;
    private int Number;
    private String ipAddress;
    private String  Teacher;

    @EJB
    private IService service;
    
    
    /**
     * Creates a new instance of JSFPractice
     */
    public JSFPractice() 
    {
        this.Message="Hi There I am a bean";
        this.Number = 22;
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        this.ipAddress =   request.getRemoteAddr();
        
    }
    
    public String getMessage() {
        return "HI";
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }
   
    
    public String getIP()
    {
        return this.ipAddress;
    }
    

    
}
