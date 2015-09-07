/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import com.Web.Ajax.WebAjaxStudents;
import com.Web.Ajax.WebAjaxTeachers;
import Hibernate.Classes;
import Hibernate.Student;
import Hibernate.Teacher;
import com.Web.Ajax.WebAjaxSingleStudent;
import com.Web.Ajax.WebAjaxSingleTeacher;
import com.Web.WebCurrentPageEnum;
import com.Web.WebClassService;
import com.Web.WebCookieService;
import com.Web.WebStudentClassesService;
import com.Web.WebTeacherClassService;
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
    private  WebClassService webclassService;    
    
    @ManagedProperty(value="#{WebStudentClassesService}")
    private  WebStudentClassesService webStudentClassesService;    
    
    @ManagedProperty(value="#{WebTeacherClassService}")
    private WebTeacherClassService webTeacherClassService;
    
    @ManagedProperty(value="#{WebAjaxTeachers}")
    private  WebAjaxTeachers webAjaxTeachers;    
    
    @ManagedProperty(value="#{WebAjaxStudents}")
    private  WebAjaxStudents webAjaxStudents;    

    @ManagedProperty(value="#{Login}")
    private  Login login;    
    
    private String CurentPage;
    
    private List<Classes> classes;

    @PostConstruct
    public void init()
    {
        
    }   

    public WebTeacherClassService getWebTeacherClassService() {
        return webTeacherClassService;
    }

    public void setWebTeacherClassService(WebTeacherClassService webTeacherClassService) {
        this.webTeacherClassService = webTeacherClassService;
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

    public WebClassService getWebclassService() {
        return webclassService;
    }

    public void setWebclassService(WebClassService webclassService) {
        this.webclassService = webclassService;
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
        return webTeacherClassService.getClassByTeacher(this.webUserLoggedIn.getTeacherID());
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
           String classId = id.replace("Student_ID_","");
           List<Student> students =  webStudentClassesService.getStudentByClassID(classId);
           ArrayList<WebAjaxSingleStudent>  newAjax = new ArrayList<WebAjaxSingleStudent>();
           
           for(Student singleStudent: students)
           {
               newAjax.add( new WebAjaxSingleStudent(singleStudent.getFirstName(),singleStudent.getLastName(),String.valueOf(singleStudent.getDob())));
           }
           
           this.webAjaxStudents.setStudent(newAjax);
           this.CurentPage = WebCurrentPageEnum.StudentPage.getPageName();
       }
       
       
       if(id.contains("Teacher"))
       {
           String classId = id.replace("webAjaxTeachers","");
           List<Classes> classes = webTeacherClassService.getClassByTeacher(classId);
           List<Teacher>  teach = webTeacherClassService.getTeacherbyClassId(classId);
           ArrayList<WebAjaxSingleTeacher>  newAjax = new ArrayList<WebAjaxSingleTeacher>();
           
           for(Classes singleClass : classes)
           {
               newAjax.add(new WebAjaxSingleTeacher());
           }
           this.webAjaxTeachers.setTeacher(newAjax);
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
