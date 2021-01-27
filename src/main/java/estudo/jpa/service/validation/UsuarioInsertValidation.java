package estudo.jpa.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;


import estudo.jpa.dto.UsuarioDTOInsert;
import estudo.jpa.model.Usuario;
import estudo.jpa.repositories.UsuarioRepository;
import estudo.jpa.resources.exceptions.FieldMessage;
import estudo.jpa.service.validation.util.BR;

public class UsuarioInsertValidation implements ConstraintValidator<UsuarioInsert, UsuarioDTOInsert >{

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public boolean isValid(UsuarioDTOInsert objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		
		if(objDto.getCpf().equals(context) && !BR.isValidCPF(objDto.getCpf())) {
			System.out.println("Cpf inválido");
		}
		
		Usuario aux = usuarioRepo.findByEmail(objDto.getEmail());
		
		if(aux != null) {
			System.out.println("Email já existe");
		}
		
		for (FieldMessage e: list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
		
		
	}
}
