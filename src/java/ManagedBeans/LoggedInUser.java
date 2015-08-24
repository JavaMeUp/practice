/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Hibernate.Users;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wilton
 */
@ManagedBean(name="WebUserLoggedIn",eager=false)
@SessionScoped
public class LoggedInUser {

    private Users user;
    private String userName;
    private int userID;
    private Boolean administrator;
    private String studentID;
    private String teacherID;
    

    /**
     * Creates a new instance of UserLogedIn
     */
    public LoggedInUser() 
    {
        
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
    
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
        this.administrator = this.user.isAdminister();
        this.userID = this.user.getId();
        this.userName = this.user.getUserName();
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
    
}
