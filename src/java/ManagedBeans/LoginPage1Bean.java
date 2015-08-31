/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Hibernate.Classes;
import com.Web.CurrentPageEnum;
import com.Web.WebClassService;
import com.Web.WebCookieService;
import com.Web.WebStudentService;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author wilson.li
 */
@ManagedBean(name="LoginPage1Bean",eager=true)
@SessionScoped
public class LoginPage1Bean implements Serializable {

    @ManagedProperty(value="#{WebUserLoggedIn}")
    private WebUserLoggedIn webUserLoggedIn;
    
    @ManagedProperty(value="#{WebCookieService}")
    private  WebCookieService webCookieService;
    
    @ManagedProperty(value="#{WebClassService}")
    private  WebClassService classService;    
    
    @ManagedProperty(value="#{WebStudentService}")
    private  WebStudentService studentService;    
    
    @ManagedProperty(value="#{Login}")
    private  Login login;    
    
    private String CurentPage;
    
    private List<Classes> classes;

    @PostConstruct
    public void init()
    {
        
    }   

    public String getCurentPage() {
        return CurentPage;
    }

    public void setCurentPage(String CurentPage) {
        this.CurentPage = CurentPage;
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

    public WebClassService getClassService() {
        return classService;
    }

    public void setClassService(WebClassService classService) {
        this.classService = classService;
    }

    public WebStudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(WebStudentService studentService) {
        this.studentService = studentService;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }
    public List<Classes> getClassesbyTeacherID()
    {
        return classService.getClassByTeacher(this.webUserLoggedIn.getTeacherID());
    }
    
    public List<Classes> getClassByStudentID()
    {
        return studentService.getClassesByStudent(this.webUserLoggedIn.getStudentID());
    }
    
    public String LogOut()
    {
        
        webUserLoggedIn.logOut();
        webCookieService.removeUserFromUserCookieBank();
        return "Home.xhtml";
    }
    
    public void AJAX(AjaxBehaviorEvent  event)
    {
       Random rand = new Random();
       Object thing = event.getSource();
       HtmlForm item1 = (HtmlForm) event.getComponent();
       HtmlForm item = (HtmlForm) event.getSource();
       System.out.print(item.getChildren().size());
       List<UIComponent> components = item.getChildren();
       HtmlOutputText text = (HtmlOutputText)components.get(0);
       String id = text.getId();
       if(id.contains("Student"))
       {
        this.CurentPage = CurrentPageEnum.StudentPage.getPageName();
       }
       if(id.contains("Teacher"))
       {
        this.CurentPage = CurrentPageEnum.TeacherPage.getPageName();   
       }
       
       
       
       //HtmlOutputText text = (HtmlOutputText) item.getParent().getChildren().get(1);
       
       
       
       
       this.webUserLoggedIn.setUserName(String.format("AJAX + %s", rand.nextInt()));
           
    }
    
    public void AJAX()
    {
       Random rand = new Random();
       
       
       this.webUserLoggedIn.setUserName(String.format("AJAX + %s", rand.nextInt()));
           
    }
}   
