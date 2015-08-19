/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Hibernate.Classes;
import Hibernate.Studentclasses;
import Hibernate.Users;
import com.Web.WebClassService;
import com.Web.CookieUserChecker;
import com.Web.WebStudentService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wilson.li
 */
@ManagedBean(name="LoginPage1Bean",eager=true)
@SessionScoped
public class LoginPage1Bean implements Serializable {

    private Users use;

    @ManagedProperty(value="#{CookieUserChecker}")
    private  CookieUserChecker userCheck;
    
    @ManagedProperty(value="#{ClassService}")
    private  WebClassService classService;    
    
    @ManagedProperty(value="#{StudentService}")
    private  WebStudentService studentService;    


    private List<Classes> classes;

    @PostConstruct
    public void init()
    {
        use  = userCheck.getUserFromUserCookieBank();
        
    }
    
    public WebStudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(WebStudentService studentService) {
        this.studentService = studentService;
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
    
    public List<Classes> getClassByStudentID()
    {
        return studentService.getClassesByStudent(use.getStudentId());
    }
    
    public String LogOut()
    {
        userCheck.removeUserFromUserCookieBank();
        return "Home.xhtml";
    }
    
    
}
