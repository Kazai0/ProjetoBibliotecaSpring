package estudo.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import estudo.jpa.dto.UsuarioDTOInsert;
import estudo.jpa.dto.UsuarioDTOUpdate;
import estudo.jpa.model.Usuario;
import estudo.jpa.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	//método utilizado para a busca dos objetos no banco de dados
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new estudo.jpa.service.exceptions.ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
				
	}
	
	//método utilizado para inserir um objeto no banco
	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		repo.save(obj);
		return obj;
	}
	
	//método utilizado para atualizar um objeto no banco
	public Usuario update(Usuario obj) {
		Usuario obje = find(obj.getId());
		return repo.save(obj);
	}
	
	//método utilizado para deleter um objeto do banco
	public void delete (Integer id) {
		find(id);
		try {
			
			repo.deleteById(id);
			
		} catch (Exception e) {
			System.out.println("e");
		}
	}
	
	//objeto retorna lista de objetos do banco
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	public Usuario fromDTOInsert(UsuarioDTOInsert objDtoInsert) {
		Usuario usu = new Usuario(null, objDtoInsert.getNome(), objDtoInsert.getSenha(), objDtoInsert.getEmail(), objDtoInsert.getCpf(), objDtoInsert.getTelefone());
		return usu;
	}
	
	public Usuario fromDTOUpdate(UsuarioDTOUpdate objDtoUpdate) {
		Usuario usu = new Usuario(objDtoUpdate.getId(), objDtoUpdate.getNome(), objDtoUpdate.getSenha(), objDtoUpdate.getEmail(), objDtoUpdate.getCpf(), objDtoUpdate.getTelefone());
		return usu;
	}

	
	
}
