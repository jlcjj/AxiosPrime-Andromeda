package com.andromeda.apirest.dto;

import java.io.Serializable;

import com.andromeda.apirest.moldels.Usuarios;

public class UsuariosDTO  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String usuario;
	private String senha;
	private String status;
	
	public UsuariosDTO() {}
	
	public UsuariosDTO(Usuarios obj) {
		
		id = obj.getId();
		nome = obj.getNome();
		usuario = obj.getUsuario();
		senha = obj.getSenha();
		status = obj.getStatus();
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
