/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Hibernate.Classes;
import Hibernate.Student;
import com.Web.WebAjaxSingleStudent;
import com.Web.WebCurrentPageEnum;
import com.Web.WebClassService;
import com.Web.WebCookieService;
import com.Web.WebStudentClassesService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    
    @ManagedProperty(value="#{WebStudentClassesService}")
    private  WebStudentClassesService webStudentClassesService;    
    
    /////
    @ManagedProperty(value="#{WebAjaxTeachers}")
    private  WebAjaxTeachers webAjaxTeachers;    
    
    @ManagedProperty(value="#{WebAjaxStudents}")
    private  WebAjaxStudents webAjaxStudents;    
    
    
    /////
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

    public WebAjaxTeachers getWebAjaxTeachers() {
        return webAjaxTeachers;
    }

    public void setWebAjaxTeachers(WebAjaxTeachers webAjaxTeachers) {
        this.webAjaxTeachers = webAjaxTeachers;
    }

    public WebAjaxStudents getWebAjaxStudents() {
        return webAjaxStudents;
    }

    public void setWebAjaxStudents(WebAjaxStudents webAjaxStudents) {
        this.webAjaxStudents = webAjaxStudents;
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

    public WebStudentClassesService getWebStudentClassesService() {
        return webStudentClassesService;
    }

    public void setWebStudentClassesService(WebStudentClassesService webStudentClassesService) {
        this.webStudentClassesService = webStudentClassesService;
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
        return webStudentClassesService.getClassesByStudent(this.webUserLoggedIn.getStudentID());
    }
    
    public String LogOut()
    {
        this.CurentPage = null;
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
           
           List<Student> studentClasses =  webStudentClassesService.getStudentByClassID("1");
           Student i = studentClasses.get(0);
           System.out.print(i.getFirstName());
           System.out.print(i.getClass());
           System.out.print(i.getDob());
           System.out.print(i.getFirstName());
           System.out.print(i.getFirstName());
           this.CurentPage = WebCurrentPageEnum.StudentPage.getPageName();
           
           ArrayList<WebAjaxSingleStudent>  ish = new ArrayList<WebAjaxSingleStudent>();
           ish.add(new WebAjaxSingleStudent(i.getFirstName(), String.valueOf(i.getStudentId()), i.getLastName()));
           webAjaxStudents.setStudent(ish);
           
       }
       
       
       if(id.contains("Teacher"))
       {
           
           
        this.CurentPage = WebCurrentPageEnum.TeacherPage.getPageName();   
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
