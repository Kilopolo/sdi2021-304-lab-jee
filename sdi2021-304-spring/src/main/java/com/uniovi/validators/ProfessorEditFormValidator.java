package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@Component
public class ProfessorEditFormValidator implements Validator{

	@Autowired
	private ProfessorService profServ;
	@Override
	public boolean supports(Class<?> clazz) {
		return Professor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Professor prof = (Professor) target;
		Character character = prof.getDni().charAt(prof.getDni().length() -1);
		
		if (prof.getDni().length()!=9 && Character.isLetter(character)) {// 
			errors.rejectValue("dni", "Error.prof.edit.dni.length");
		}
		if (profServ.getProfessorByDni(prof.getDni()) != null) {
			errors.rejectValue("dni", "Error.prof.edit.dni.unique");
		}
	}

}
