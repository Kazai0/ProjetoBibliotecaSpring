package estudo.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import estudo.jpa.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {



	@Transactional(readOnly = true)
	Usuario findByEmail(String email);
	
	
}
