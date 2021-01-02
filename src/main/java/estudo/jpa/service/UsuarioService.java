package estudo.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estudo.jpa.model.Usuario;
import estudo.jpa.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new estudo.jpa.service.exceptions.ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
				
	}

}
