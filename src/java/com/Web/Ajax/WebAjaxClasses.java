/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web.Ajax;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wilson.li
 */
@ManagedBean(name="WebAjaxClasses",eager=true)
@SessionScoped
public class WebAjaxClasses implements Serializable {

    private List<WebAjaxClasses> classes;
    /**
     * Creates a new instance of WebAjaxClasses
     */
    public WebAjaxClasses() 
    {
        
    }

    public List<WebAjaxClasses> getClasses() {
        return classes;
    }

    public void setClasses(List<WebAjaxClasses> classes) {
        this.classes = classes;
    }

    

    
}
