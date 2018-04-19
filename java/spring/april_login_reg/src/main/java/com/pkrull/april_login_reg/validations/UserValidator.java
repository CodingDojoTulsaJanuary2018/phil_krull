package com.pkrull.april_login_reg.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pkrull.april_login_reg.models.User;
import com.pkrull.april_login_reg.services.UserService;

@Component
public class UserValidator implements Validator {
	private UserService uService;
	
	public UserValidator(UserService uService) {
		this.uService = uService;
	}
	
	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        if (!user.getConfirm_password().equals(user.getPassword())) {
            // 3
            errors.rejectValue("confirm_password", "Match");
        }
        User foundUser = uService.findByEmail(user.getEmail());
        if(foundUser != null) {
        	errors.rejectValue("email", "Unique");
        }
    }

}
