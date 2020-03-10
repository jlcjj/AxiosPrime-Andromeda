package com.andromeda.apirest.moldels;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbd_telefones")
public class Telefones implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	@Basic
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Clientes clientes = new Clientes();
	
	@Column(nullable = false, length = 20)
	private String tipo_tel;
	
	@Column(nullable = true, length = 20)
	private String numero;
	
	@Column(nullable = true, length = 80)
	private String nome_contato;
	
	@Column(nullable = true, length = 10)
	private String Status;
	
	
	public Telefones () {}


	public Telefones(Long id, String tipo_tel, String numero, String nome_contato, String status) {
		super();
		this.id = id;
		this.tipo_tel = tipo_tel;
		this.numero = numero;
		this.nome_contato = nome_contato;
		Status = status;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}





	public Clientes getClientes() {
		return clientes;
	}


	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefones other = (Telefones) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Telefones [id=" + id + ", clientes=" + clientes + ", tipo_tel=" + tipo_tel + ", numero=" + numero
				+ ", nome_contato=" + nome_contato + ", Status=" + Status + "]";
	}



	
	
}
