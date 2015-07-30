/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormValidation;

import DAO.Services.ServiceEnumContext;
import DAO.Services.ServiceLocator;
import DAO.Services.UsersService;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author wilton
 */
@FacesValidator("com.LoginValidator")
public class LoginValidation  implements Validator
{
    private UsersService service;
    private ServiceLocator serviceLocator;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        System.out.println("hi");
        
        /*
            FacesMessage message = new FacesMessage("ERROR HERE !!!!!!!!!!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        */
    }
    
}
