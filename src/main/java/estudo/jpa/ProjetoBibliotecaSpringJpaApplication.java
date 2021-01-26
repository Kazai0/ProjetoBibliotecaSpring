package estudo.jpa;
//md5
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//Assim diz o Senhor: Maldito o homem que confia no homem, 

//que faz daquilo mortal a sua força e 
//afasta do do Senhor o seu coração

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import estudo.jpa.model.Usuario;
import estudo.jpa.repositories.UsuarioRepository;

@SpringBootApplication
public class ProjetoBibliotecaSpringJpaApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoBibliotecaSpringJpaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Usuario usuario1 = new Usuario(1, "Joao", "teste", "joao.armindo@hotmail.com", 1999, 945805485);
		Usuario usuario2 = new Usuario(2, "Jucelia", "123", "jucelia.chagas@hotmail.com", 1998, 998329832);
		Usuario usuario3 = new Usuario(3, "Manoel", "987", "manoel.augusto@gmail.com", 1998, 948748748);
		
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));
		
		
		
	}

}
