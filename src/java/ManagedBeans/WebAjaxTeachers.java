/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import com.Web.WebAjaxSingleTeacher;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wilson.li
 */
@ManagedBean(name="WebAjaxTeachers",eager=true)
@SessionScoped
public class WebAjaxTeachers implements Serializable {

    private List<WebAjaxSingleTeacher> teacher;
    /**
     * Creates a new instance of AjaxStudents
     */
    public WebAjaxTeachers() {
    }

    public List<WebAjaxSingleTeacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<WebAjaxSingleTeacher> teacher) {
        this.teacher = teacher;
    }
    
}
