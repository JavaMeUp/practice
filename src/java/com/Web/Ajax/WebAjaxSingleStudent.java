/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web.Ajax;

/**
 *
 * @author wilson.li
 */
public class WebAjaxSingleStudent 
{
    private String Name;
    private String StudentID;
    private String imageURL;

    public WebAjaxSingleStudent(String Name, String StudentID, String imageURL) {
        this.Name = Name;
        this.StudentID = StudentID;
        this.imageURL = imageURL;
    }
    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    
    
    
    
    
    
    
}
