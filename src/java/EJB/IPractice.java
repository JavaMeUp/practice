/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Hibernate.Teacher;
import javax.ejb.Local;



/**
 *
 * @author wilson.li
 */

@Local
public interface IPractice {
    
    public void setItems();
    
    public String getMessage();

    public String getTeacher();
    
}
