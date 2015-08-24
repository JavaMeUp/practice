/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Hibernate.Classes;
import Hibernate.Users;
import com.Web.WebClassService;
import com.Web.WebCookieService;
import com.Web.WebStudentService;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wilson.li
 */
@ManagedBean(name="LoginPage1Bean",eager=true)
@SessionScoped
public class LoginPage1Bean implements Serializable {

    @ManagedProperty(value="#{userLogedIn")
    private UserLogedIn use;

    @ManagedProperty(value="#{WebCookieService}")
    private  WebCookieService webCookieService;
    
    @ManagedProperty(value="#{WebClassService}")
    private  WebClassService classService;    
    
    @ManagedProperty(value="#{WebStudentService}")
    private  WebStudentService studentService;    
    
    @ManagedProperty(value="#{Login}")
    private  Login login;    
    
    private List<Classes> classes;

    @PostConstruct
    public void init()
    {
        
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public WebCookieService getWebCookieService() {
        return webCookieService;
    }

    public void setWebCookieService(WebCookieService webCookieService) {
        this.webCookieService = webCookieService;
    }    
    
    public WebStudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(WebStudentService studentService) {
        this.studentService = studentService;
    }
    
    public UserLogedIn getUse() {
        return use;
    }

    public void setUse(UserLogedIn use) {
        this.use = use;
    }
    
   public WebCookieService getUserCheck() {
        return webCookieService;
    }

    public void setUserCheck(WebCookieService webCookieService) {
        this.webCookieService = webCookieService;
    }
    
    public WebClassService getClassService() {
        return classService;
    }

    public void setClassService(WebClassService classService) {
        this.classService = classService;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }
    
    public List<Classes> getClassesbyTeacherID()
    {
        return classService.getClassByTeacher(this.use.getUse().getTeacherId());
    }
    
    public List<Classes> getClassByStudentID()
    {
        return studentService.getClassesByStudent(use.getUse().getStudentId());
    }
    
    public String LogOut()
    {
        
        use.setUse(null);
        
        webCookieService.removeUserFromUserCookieBank();
        login.setIsValidUser(false);
        return "Home.xhtml";
    }
}
