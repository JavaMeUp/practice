/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Hibernate.Users;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wilton
 */
@ManagedBean(name="WebUserLoggedIn",eager=true)
@SessionScoped
public class WebUserLoggedIn  implements Serializable {

    private Users user;
    private String userName;
    private int userID;
    private Boolean administrator;
    private String studentID;
    private String teacherID;
    

    /**
     * Creates a new instance of UserLogedIn
     */
    public WebUserLoggedIn() 
    {
        
    }
    
    @PostConstruct
    public void init()
    {
        
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
        this.userName =this.user.getUserName();
        this.studentID =this.user.getStudentId();
        this.teacherID =this.user.getTeacherId();
        this.userID =this.user.getId();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public void logOut()
    {
        this.user = null;
        this.userName =null;
        this.studentID =null;
        this.teacherID =null;
        this.userID =0;
    }
    
}
