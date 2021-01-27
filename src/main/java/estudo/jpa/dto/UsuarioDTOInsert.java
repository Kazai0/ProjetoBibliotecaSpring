package estudo.jpa.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import estudo.jpa.service.validation.UsuarioInsert;
import jdk.jfr.DataAmount;


@UsuarioInsert
public class UsuarioDTOInsert implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "preenchimento Obrigatório")
	@Length(min =5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message = "preenchimento obrigatório")
	private String senha;
	
	@NotEmpty(message = "prenchimento obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	

	
	
}
