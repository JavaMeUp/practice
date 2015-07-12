/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB.Services;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author wilton
 */
@Local
public interface IGenericService <T,id extends Serializable,O>
{
    
    public void persist(T entity);
    public void update (T entity);
    public T findByID(String id);
    public void deleteAll();
    public void deleteByID(String ID);
    public List<T> listAll();
    public O getClassesDAO();
    
    
}
