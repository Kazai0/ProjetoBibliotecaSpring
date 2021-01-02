package estudo.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.jpa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	
	
}
