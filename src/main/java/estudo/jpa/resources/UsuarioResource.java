package estudo.jpa.resources;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import estudo.jpa.dto.UsuarioDTOInsert;
import estudo.jpa.dto.UsuarioDTOUpdate;
import estudo.jpa.model.Usuario;
import estudo.jpa.service.UsuarioService;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	// injeção de dependência
	
	@Autowired
	private UsuarioService usuarioService;

	// RequestMapping passa um valor de parâmetro como id para a url e o RequestMehod irá  
	//ResponseEntity usa como parametro a classe de dominio e pathVariable recebe como parâmetro o id do obj
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		Usuario obj =  usuarioService.find(id);
		return ResponseEntity.ok().body(obj);


	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void>insert (@Valid @RequestBody UsuarioDTOInsert objDtoInsert){
		Usuario objUsuario = usuarioService.fromDTOInsert(objDtoInsert);
		objUsuario = usuarioService.insert(objUsuario);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objUsuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTOUpdate objDtoUpdate, @PathVariable Integer id){
		Usuario usuario = usuarioService.fromDTOUpdate(objDtoUpdate);
		usuario.setId(id);
		usuario = usuarioService.update(usuario);
		return ResponseEntity.noContent().build();
	}
	
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	

}
