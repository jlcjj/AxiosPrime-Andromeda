package com.andromeda.apirest.dto;

import java.io.Serializable;

import com.andromeda.apirest.moldels.Telefones;

public class TelefonesDTO  implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String tipo_tel;
	private String numero;
	private String nome_contato;
	private String Status;
	
	
	public TelefonesDTO () {}
	
	public TelefonesDTO(Telefones obj) {
		
		id = obj.getId();
		tipo_tel = obj.getTipo_tel();
		numero = obj.getNumero();
		nome_contato = obj.getNome_contato();
		Status = obj.getStatus();
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo_tel() {
		return tipo_tel;
	}

	public void setTipo_tel(String tipo_tel) {
		this.tipo_tel = tipo_tel;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome_contato() {
		return nome_contato;
	}

	public void setNome_contato(String nome_contato) {
		this.nome_contato = nome_contato;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
