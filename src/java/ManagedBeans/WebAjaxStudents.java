/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import com.Web.WebAjaxSingleStudent;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wilson.li
 */
@ManagedBean(name="WebAjaxStudents",eager=true)
@SessionScoped
public class WebAjaxStudents implements Serializable {

    private List<WebAjaxSingleStudent> student;
    /**
     * Creates a new instance of AjaxStudents
     */
    public WebAjaxStudents() {
    }

    public List<WebAjaxSingleStudent> getStudent() {
        return student;
    }

    public void setStudent(List<WebAjaxSingleStudent> student) {
        this.student = student;
    }
    
    
    

    
    
    
    
}
