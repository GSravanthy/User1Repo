package com.project.main.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import com.project.main.Repo.CitizenRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<UniqueEmailValidator, String>{

	@Autowired
	CitizenRepo repo;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(repo.findByEmail(value).size() == 0)	
			return true;
		return false;
	}

}
