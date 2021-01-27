package estudo.jpa.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import estudo.jpa.dto.UsuarioDTOUpdate;
import estudo.jpa.model.Usuario;
import estudo.jpa.repositories.UsuarioRepository;
import estudo.jpa.resources.exceptions.FieldMessage;

public class UsuarioUpdateValidation implements ConstraintValidator<UsuarioUpdate, UsuarioDTOUpdate>{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public void initialize(UsuarioUpdate ann) {
	
	}
	
	@Override
	public boolean isValid(UsuarioDTOUpdate objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Usuario aux = usuarioRepository.findByEmail(objDto.getEmail());

		if(aux!=null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "email já existente"));
			
			
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
			
		}
		
		return list.isEmpty();
	}
	
	
	

}
