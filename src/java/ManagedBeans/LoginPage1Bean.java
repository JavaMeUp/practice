/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DAO.Services.StudentService;
import Hibernate.Classes;
import Hibernate.Users;
import com.Web.WebClassService;
import com.Web.CookieUserChecker;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author wilson.li
 */
@ManagedBean(name="LoginPage1Bean",eager=true)
@RequestScoped
public class LoginPage1Bean implements Serializable {

    private Users use;

    @ManagedProperty(value="#{CookieUserChecker}")
    private  CookieUserChecker userCheck;
    
    @ManagedProperty(value="#{ClassService}")
    private  WebClassService classService;    
    
    @ManagedProperty(value="#{StudentService}")
    private  StudentService studentService;    
    
    private List<Classes> classes;

    @PostConstruct
    public void init()
    {
        use  = userCheck.getUserFromUserCookieBank();
        
    }
    
    public Users getUse() {
        return use;
    }

    public void setUse(Users use) {
        this.use = use;
    }
    
   public CookieUserChecker getUserCheck() {
        return userCheck;
    }

    public void setUserCheck(CookieUserChecker userCheck) {
        this.userCheck = userCheck;
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
        return classService.getClassByTeacher(this.use.getTeacherId());
    }
    
    
    public String LogOut()
    {
        return "Home.xhtml";
    }
    
    
}
