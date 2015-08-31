/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wilton
 */
@ManagedBean(name="WebCurrentPageEnum",eager=true)
@SessionScoped
public enum CurrentPageEnum 
{
    TeacherPage(1),
    StudentPage(2);
    
    private String PageName;
    
    private CurrentPageEnum(int i)
    {
        switch(i)
        {
            case 1:
                   this.PageName = "Teacher";
                    break;
            case 2:
                    this.PageName = "Student";
                    break;
        }
    }

    public String getPageName() {
        return PageName;
    }

    public void setPageName(String PageName) {
        this.PageName = PageName;
    }
}
